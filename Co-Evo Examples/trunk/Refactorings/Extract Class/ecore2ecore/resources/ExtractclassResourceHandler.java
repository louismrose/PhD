package extractclass.resources;
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.BasicResourceHandler;
import org.eclipse.emf.ecore.xml.type.AnyType;

import extractclass.ExtractclassFactory;
import extractclass.ExtractclassPackage;
import extractclass.Person;

public class ExtractclassResourceHandler extends BasicResourceHandler {

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
					
			if (isPerson(owner)) {
				if (isAreaCode(entry.getEStructuralFeature())) {
					addAreaCode((Person)owner, (String)entry.getValue());
					iter.remove();
					
				} else if (isNumber(entry.getEStructuralFeature())) {
					addNumber((Person)owner, (String)entry.getValue());
					iter.remove();
				}
			} else {
				System.err.println("Not a person: " + owner);
			}
		}
	}
	private boolean isPerson(EObject eObject) {
		return ExtractclassPackage.eINSTANCE.getPerson().isInstance(eObject);
	}
	
	private boolean isAreaCode(EStructuralFeature feature) {
		return "areaCode".equals(feature.getName());
	}
	
	private boolean isNumber(EStructuralFeature feature) {
		return "number".equals(feature.getName());
	}
	
	private void addAreaCode(Person owner, String areaCode) {
		initialiseTelephoneNumber(owner);
		
		owner.getTelephoneNumber().setAreaCode(areaCode);
	}
	
	private void addNumber(Person owner, String number) {
		initialiseTelephoneNumber(owner);
		
		owner.getTelephoneNumber().setNumber(number);
	}
	
	private void initialiseTelephoneNumber(Person owner) {
		if (owner.getTelephoneNumber() == null) {
			owner.setTelephoneNumber(ExtractclassFactory.eINSTANCE.createTelephoneNumber());
		}
	}
}
