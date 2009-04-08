/*******************************************************************************
 * Copyright (c) 2008 The University of York.
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
package org.eclipse.epsilon.hutn.xmi.util;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.hutn.model.hutn.AttributeSlot;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.HutnFactory;
import org.eclipse.epsilon.hutn.model.hutn.ReferenceSlot;
import org.eclipse.epsilon.hutn.model.hutn.Slot;


public abstract class HutnUtil {

	private HutnUtil() {}
	
	public static String determineTypeOfFeatureFromMetaClass(ClassObject classObject, String featureName, String defaultType) {
    	if (classObject.hasEClass()) {
    		for (EStructuralFeature feature : classObject.getEClass().getEAllStructuralFeatures()) {
    			if (featureName.equals(feature.getName())) {
    				return feature.getEType().getName();
    			}
    		}
    	}
    	
    	return defaultType;
	}
	
	public static Slot<?> determineSlotFromTypeOfMetaFeature(ClassObject classObject, String featureName, String value) {
		if (classObject.hasEClass()) {
	    	for (EStructuralFeature feature : classObject.getEClass().getEAllStructuralFeatures()) {
	    		if (featureName.equals(feature.getName())) {
	    			
	    			final Slot<?> slot;
	    			
	    			if (feature instanceof EAttribute) {
	    				slot = determineSlotFromEAttribute(feature.getEType(), value);
	    				
	    			} else {
	    				slot = determineSlotFromEReference(value);
	    			}
	    			
	    			slot.setFeature(featureName);    			
	    			return slot;
	    		}
	    	}
		}
    	
    	return null;
    }
    
	private static AttributeSlot determineSlotFromEAttribute(EClassifier type, String value) {
		final AttributeSlot slot = HutnFactory.eINSTANCE.createAttributeSlot();

		final String typeName = type.getInstanceClassName(); 
		final Object convertedValue;

		if (type instanceof EEnum) {
			convertedValue = ((EEnum)type).getEEnumLiteralByLiteral(value);

			if (convertedValue == null)
				throw new IllegalArgumentException("Expected an enumeration value from " + typeName + "  but received: " + value);

		} else if ("java.lang.Integer".equals(typeName) || "int".equals(typeName)) {
			convertedValue = Integer.parseInt(value);

		} else if ("java.lang.Float".equals(typeName) || "float".equals(typeName)) {
			convertedValue = Float.parseFloat(value);

		} else if ("java.lang.Boolean".equals(typeName) || "boolean".equals(typeName)) {
			if ("true".equals(value))
				convertedValue = true;
			else if ("false".equals(value))
				convertedValue = false;
			else
				throw new IllegalArgumentException("Expected a boolean but received: " + value);

		} else {
			convertedValue = value;
		}

		slot.getValues().add(convertedValue);
		
		return slot;
	}
	
	private static ReferenceSlot determineSlotFromEReference(String value) {
		// TODO: will have to use a cache between xmi id and class object
		return HutnFactory.eINSTANCE.createReferenceSlot();
	}
}
