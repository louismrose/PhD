/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package lit_petriNets.resources;

import java.io.InputStream;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import lit_petriNets.Lit_petriNetsFactory;
import lit_petriNets.Lit_petriNetsPackage;
import lit_petriNets.PTArc;
import lit_petriNets.Place;
import lit_petriNets.TPArc;
import lit_petriNets.Transition;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.BasicResourceHandler;
import org.eclipse.emf.ecore.xml.type.AnyType;

public class PetriNetsResourceHandler extends BasicResourceHandler {

	@Override
	public void postLoad(XMLResource resource, InputStream inputStream, Map<?, ?> options) {
		final Map<EObject, AnyType> extMap = resource.getEObjectToExtensionMap();
		
		for(Entry<EObject, AnyType> entry : extMap.entrySet()) {
			handleUnknownData(entry.getKey(), entry.getValue());
		}
	}

	private void handleUnknownData(EObject eObj, AnyType unknownData) {
		handleUnknownFeatures(eObj, unknownData.getMixed());
		handleUnknownFeatures(eObj, unknownData.getAnyAttribute());
	}

	private void handleUnknownFeatures(EObject owner, FeatureMap featureMap) {
		for (FeatureMap.Entry entry : featureMap) {
			if (isTransition(owner)) {
				if (isCollectionOfPlaces(entry.getValue(), owner.eResource())) {
					final Transition transition    = (Transition)owner;
					final Collection<Place> places = toCollectionOfPlaces(entry.getValue(), owner.eResource());
					
					if (isSrc(entry.getEStructuralFeature())) {
						migrateSrc(transition, places);
						
					} else if (isDst(entry.getEStructuralFeature())) {
						migrateDest(transition, places);
					}
				
				} else {
					System.err.println("Not a collection of places: " + entry.getValue());
				}
			} else {
				System.err.println("Not a transition: " + owner);
			}
		}
	}

	private boolean isTransition(EObject eObject) {
		return Lit_petriNetsPackage.eINSTANCE.getTransition().isInstance(eObject);
	}
	
	private boolean isSrc(EStructuralFeature feature) {
		return "src".equals(feature.getName());
	}
	
	private boolean isDst(EStructuralFeature feature) {
		return "dst".equals(feature.getName());
	}
	
	private boolean isCollectionOfPlaces(Object value, Resource resource) {
		final String[] uriFragments = ((String)value).split(" ");
		
		for (String uriFragment : uriFragments) {
			final EObject eObject = resource.getEObject(uriFragment);
			
			if (eObject == null || !Lit_petriNetsPackage.eINSTANCE.getPlace().isInstance(eObject))
				return false;
		}
		
		return true;
	}
	
	private Collection<Place> toCollectionOfPlaces(Object value, Resource resource) {
		final String[] uriFragments = ((String)value).split(" ");
		
		final Collection<Place> places = new LinkedList<Place>();
		
		for (String uriFragment : uriFragments) {
			places.add((Place)resource.getEObject(uriFragment));
		}
		
		return places;
	}
	
	private void migrateSrc(Transition owner, Collection<Place> sources) {
		for (Place source : sources) {
			final PTArc arc = Lit_petriNetsFactory.eINSTANCE.createPTArc();
			arc.setSrc(source);
			arc.setDst(owner);
			arc.setNet(owner.getNet());
			
			owner.getIn().add(arc);
		}
	}
	
	private void migrateDest(Transition owner, Collection<Place> destinations) {
		for (Place destination : destinations) {
			final TPArc arc = Lit_petriNetsFactory.eINSTANCE.createTPArc();
			arc.setSrc(owner);
			arc.setDst(destination);
			arc.setNet(owner.getNet());
			
			owner.getOut().add(arc);
		}
	}
}
