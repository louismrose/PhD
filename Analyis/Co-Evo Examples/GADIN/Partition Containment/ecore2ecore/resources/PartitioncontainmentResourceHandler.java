package partitioncontainment.resources;
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


import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.BasicResourceHandler;
import org.eclipse.emf.ecore.xml.type.AnyType;

import partitioncontainment.Action;
import partitioncontainment.PartitioncontainmentFactory;
import partitioncontainment.PartitioncontainmentPackage;
import partitioncontainment.Proposition;

public class PartitioncontainmentResourceHandler extends BasicResourceHandler {

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
		for (Iterator<FeatureMap.Entry> iter = featureMap.iterator(); iter.hasNext();) {
			final FeatureMap.Entry entry = iter.next();
			
			final XMLResource resource = (XMLResource)owner.eResource();
			
			if (isAction(owner)) {
				if (isPreconditions(entry.getEStructuralFeature()) && entry.getValue() instanceof AnyType) {
					addPrecondition((Action)owner, convertToProposition(entry, resource));
					iter.remove();
				}
			} else {
				System.err.println("Not an action: " + owner);
			}
		}
	}

	private Proposition convertToProposition(FeatureMap.Entry entry, XMLResource resource) {
		return (Proposition)convert((AnyType)entry.getValue(), PartitioncontainmentPackage.eINSTANCE.getProposition(), resource);
	}

	private boolean isAction(EObject eObject) {
		return PartitioncontainmentPackage.eINSTANCE.getAction().isInstance(eObject);
	}
	
	private boolean isPreconditions(EStructuralFeature feature) {
		return "preconditions".equals(feature.getName());
	}
	
	protected EObject convert(AnyType extension, EClass eClass, XMLResource resource) {
		
		final EObject newEObject = EcoreUtil.create(eClass);

		if (resource != null) {
			resource.setID(newEObject, resource.getID(extension));
		}
		
		for (FeatureMap.Entry entry : extension.getAnyAttribute()) {
			final EStructuralFeature eStructuralFeature = entry.getEStructuralFeature();
			
			if (eStructuralFeature.isChangeable() &&
				((EStructuralFeature.Internal) eStructuralFeature).getEOpposite() == null &&
				eClass.getEStructuralFeature(eStructuralFeature.getName()) != null) {

				try {
					newEObject.eSet(eClass.getEStructuralFeature(eStructuralFeature.getName()), entry.getValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return newEObject;
	}
	
	private void addPrecondition(Action owner, Proposition precondition) {
		if (owner.getPreconditionSets().isEmpty()) {
			owner.getPreconditionSets().add(PartitioncontainmentFactory.eINSTANCE.createPropositionSet());
		}
		
		owner.getPreconditionSets().get(0).getPreconditions().add(precondition);
	}
}
