package inlineclass.resources;
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


import inlineclass.InlineclassPackage;
import inlineclass.Person;

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


public class InlineclassResourceHandler extends BasicResourceHandler {

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
				if (isTelephoneNumber(entry.getEStructuralFeature()) && entry.getValue() instanceof AnyType) {
					final AnyType anyType = (AnyType)entry.getValue();
					migrateTelephoneNumber((Person)owner, (String)getAttributeValue(anyType, "areaCode"), (String)getAttributeValue(anyType, "number"));
					iter.remove();	
				}
			} else {
				System.err.println("Not a job item: " + owner);
			}
		}
	}

	private boolean isPerson(EObject eObject) {
		return InlineclassPackage.eINSTANCE.getPerson().isInstance(eObject);
	}
	
	private boolean isTelephoneNumber(EStructuralFeature feature) {
		return "telephoneNumber".equals(feature.getName());
	}
	
	private Object getAttributeValue(AnyType anyType, String featureName) {
		for (FeatureMap.Entry entry : anyType.getAnyAttribute()) {
			if (featureName.equals(entry.getEStructuralFeature().getName())) {
				return entry.getValue();
			}
		}
		
		return null;
	}
	
	private void migrateTelephoneNumber(Person owner, String areaCode, String number) {
		owner.setAreaCode(areaCode);
		owner.setNumber(number);
	}
}
