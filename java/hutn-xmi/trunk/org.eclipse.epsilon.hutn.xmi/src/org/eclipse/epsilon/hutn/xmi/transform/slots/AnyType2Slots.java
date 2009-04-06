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
package org.eclipse.epsilon.hutn.xmi.transform.slots;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.ContainmentSlot;
import org.eclipse.epsilon.hutn.model.hutn.HutnFactory;
import org.eclipse.epsilon.hutn.xmi.coerce.ValueCoercer;
import org.eclipse.epsilon.hutn.xmi.transform.util.AnyTypeUtil;
import org.eclipse.epsilon.hutn.xmi.transform.util.ClassObjectCache;
import org.eclipse.epsilon.hutn.xmi.transform.util.EListUtil;

public class AnyType2Slots extends Object2Slots {
	
	private final ValueCoercer coercer; 
	private final AnyType any;

	public AnyType2Slots(EObject object, ClassObjectCache cache) {
		super(object, cache);

		this.coercer = new ValueCoercer(object.eResource());
		this.any     = AnyTypeUtil.findAnyTypeFor(object);
		
		AnyTypeUtil.inspectAnyType(any);
	}

	protected void doTransform() {
		if (any != null) {
			transformUnrecognisedXmlAttributes();
			transformUnrecognisedNestedXml();
		}
	}
	
	/**
	 * Unrecognised XML attributes are either (1) a value for a single-valued
	 * EAttribute, or (2) one or more values for a non-containment EReference.
	 * 
	 * In both cases, the values are stored as strings and must, therefore, 
	 * be coerced.
	 * 
	 * Exemplar AnyType structure for (1):
	 *   anyAttribute: numberOfCars [EAttribute] = "2" [String]
	 *   any: {}
	 *   mixed:{}
	 * 
	 * Exemplar AnyType structure for (2):
	 *   anyAttribute: {animals [EAttribute] = "_4yG-UBiFEd6-Eob-hyWntQ _HiVRYBiGEd6-Eob-hyWntQ" [String]}
	 *   any: {}
	 *   mixed: {}
	 */
	// FIXME: Support Enum values; currently just returns a String.
	private void transformUnrecognisedXmlAttributes() {
		for (FeatureMap.Entry entry : any.getAnyAttribute()) {
			final Object coercedValue = coerce(entry.getValue());
			
			if (isListOfReferences(coercedValue)) {
				transformReferenceValue(coercedValue, entry.getEStructuralFeature().getName(), false);
			} else {
				transformAttributeValue(coercedValue, entry.getEStructuralFeature().getName());
			}
		}
	}
	
	private static boolean isListOfReferences(Object value) {
		return value instanceof EList<?> &&
		       EListUtil.elementsAreAllInstancesOf((EList<?>)value, EObject.class);
	}
	
	
	
	private final Map<EStructuralFeature, EList<EObject>> unrecognisedFeatures = new HashMap<EStructuralFeature, EList<EObject>>();
	
	/**
	 * Unrecognised nested XML tags form either (1) one or more values for 
	 * a multi-valued EAttribute, or (2) one or more values for a containment 
	 * EReference.
	 * 
	 * In both cases, the values are stored as strings and must, therefore, 
	 * be coerced.
	 * 
	 * Exemplar AnyType structure for (1):
	 *   anyAttribute:
	 *   any:   {telNumber [EReference] = any2, telNumber [EReference] = any3}
	 *   mixed: {telNumber [EReference] = any2, telNumber [EReference] = any3}
	 *   
	 *   any2:
	 *     anyAttribute: {}
	 *     any: {}
	 *     mixed: text [EAttribute] = "01904 665544" [String]
	 *     
	 *   any3:
	 *     anyAttribute:{}
	 *     any: {}
	 *     mixed: text [EAttribute] = "07777 889900" [String]
	 * 
	 * 
	 * Exemplar AnyType structure for (2):
	 *   anyAttribute:
	 *   any:   {people [EReference] = f [DynamicEObject#eClass=Family], people [EReference] = p [DynamicEObject#eClass=Person]}
	 *   mixed: {people [EReference] = f [DynamicEObject#eClass=Family], people [EReference] = p [DynamicEObject#eClass=Person]}
	 *   
	 * 
	 * When the type of a containment reference can be inferred, EMF does not include
	 * type information during serialisation:
	 * 
	 * [contents xsi:type="families:Family"]
	 *   [people /]
	 *   [people /]
	 * [/contents]
	 * 
	 * as opposed to:
	 *   
	 *   [families:Model]
	 *     [elements xsi:type="families:Family"/]
	 *     [elements xsi:type="families:People"/]
	 *   [/families:Model]
	 *   
	 * When no type information is available and the feature is unrecognised, no 
	 * type for the nested XML can be inferred. Exemplar AnyType structure:
	 * 
	 * anyAttribute:
	 * any:   {elements [EReference] = any2, elements [EReference] = any3}
	 * mixed: {elements [EReference] = any2, elements [EReference] = any3}
	 * 
	 *   any2:
	 *     anyAttribute:
	 *     any:
	 *     mixed:
	 *     
	 *   any3:
	 *     anyAttribute:
	 *     any:
	 *     mixed:
	 */
	private void transformUnrecognisedNestedXml() {
		if (!any.getMixed().isEmpty()) {
			
			determineUnrecognisedFeatures();
			
			for (Map.Entry<EStructuralFeature, EList<EObject>> unrecognisedFeature : unrecognisedFeatures.entrySet()) {
				
				if (unrecognisedFeature.getValue().get(0) instanceof AnyType) {
					transformUnrecognisedAnys(unrecognisedFeature.getKey().getName(), EListUtil.castElements(unrecognisedFeature.getValue(), AnyType.class));
				} else {
					transformUnrecognisedContainment(unrecognisedFeature.getKey().getName(), unrecognisedFeature.getValue());
				}
			}
			
		}
	}
	
	private void determineUnrecognisedFeatures() {
		unrecognisedFeatures.clear();
		
		for (FeatureMap.Entry entry : any.getMixed()) {
			if (!unrecognisedFeatures.containsKey(entry.getEStructuralFeature())) {
				unrecognisedFeatures.put(entry.getEStructuralFeature(), new BasicEList<EObject>());
			}
			
			unrecognisedFeatures.get(entry.getEStructuralFeature()).add((EObject)entry.getValue());
		}
		
		System.err.println(unrecognisedFeatures);
	}

	private void transformUnrecognisedAnys(String featureName, EList<AnyType> unrecognisedAnys) {		
		if (isEObjectWithUnknownType(unrecognisedAnys.get(0))) {
			transformEObjectsWithUnknownType(featureName, unrecognisedAnys);
		
		} else {
			tranformUnrecognisedManyValuedAttribute(featureName, unrecognisedAnys);
		}
	}
	
	private static boolean isEObjectWithUnknownType(AnyType any) {
		return any.getMixed().isEmpty() && any.getAny().isEmpty() && any.getAnyAttribute().isEmpty();
	}
	
	private void transformEObjectsWithUnknownType(String featureName, EList<AnyType> unrecognisedEObjects) {
		final ContainmentSlot slot = HutnFactory.eINSTANCE.createContainmentSlot();
		slot.setFeature(featureName);
		
		for (EObject unrecognisedEObject : unrecognisedEObjects) {
			final ClassObject classObject = HutnFactory.eINSTANCE.createClassObject();
			classObject.setType("UnknownType");
			
			slot.addClassObject(classObject);
		}
		
		addSlot(slot);		
	}
	
	private void tranformUnrecognisedManyValuedAttribute(String featureName, EList<AnyType> unrecognisedAttributeValues) {
		final EList<Object> values = new BasicEList<Object>();
		
		for (AnyType anyType : unrecognisedAttributeValues) {
			
			for (FeatureMap.Entry nestedEntry : anyType.getMixed()) {
				values.add(nestedEntry.getValue());
			}
		}
		
		transformAttributeValue(coerce(values), featureName);
	}
	
	
	private void transformUnrecognisedContainment(String featureName, EList<EObject> unrecognisedContainmentValues) {
		transformReferenceValue(unrecognisedContainmentValues, featureName, true);	
	}

	
	private Object coerce(Object value) {
		return coercer.coerce(value);
	}

}
