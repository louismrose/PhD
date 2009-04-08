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
import org.eclipse.emf.ecore.EDataType;
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
	
	public static Slot<?> determineSlotFromTypeOfMetaFeature(ClassObject classObject, ClassObjectCache cache, String featureName, String value) {
		if (classObject.hasEClass()) {
	    	for (EStructuralFeature feature : classObject.getEClass().getEAllStructuralFeatures()) {
	    		if (featureName.equals(feature.getName())) {
	    			
	    			final Slot<?> slot;
	    			
	    			if (feature instanceof EAttribute) {
	    				slot = determineSlotFromEAttribute(feature.getEType(), value);
	    				
	    			} else {
	    				slot = determineSlotFromEReference(cache, value);
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
		
		final Object convertedValue;

		if (type instanceof EDataType) {
			convertedValue = EmfUtil.createFromString((EDataType)type, value);
		
		} else {
			convertedValue = value;
		}
		
		slot.getValues().add(convertedValue);
		
		return slot;
	}
	
	private static ReferenceSlot determineSlotFromEReference(ClassObjectCache cache, String value) {
		final ReferenceSlot slot = HutnFactory.eINSTANCE.createReferenceSlot();		
		
		slot.getValues().add(cache.get(value).getIdentifier());
		
		return slot;
	}
}
