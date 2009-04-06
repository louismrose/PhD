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
package org.eclipse.epsilon.hutn.xmi.transform.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xml.type.AnyType;

public abstract class AnyTypeUtil {

	private AnyTypeUtil() {}
		
	public static AnyType findAnyTypeFor(EObject object) {
		if (object.eResource() instanceof XMLResource) {
			return ((XMLResource)object.eResource()).getEObjectToExtensionMap().get(object);
		}
		
		return null;
	}
	
	// For debugging 
	public static void inspectAnyType(AnyType any) {
		inspectAnyType(any, "");
	}
	
	private static void inspectAnyType(AnyType any, String indentation) {
		if (any != null) {
			System.out.println(indentation + "eClass: " + any.eClass().getName());
			
			System.out.println(indentation + "Mixed");
			for (FeatureMap.Entry entry : any.getMixed()) {
				System.out.println(indentation + "\t" + toString(entry.getEStructuralFeature()));
				System.out.println(indentation + "\t" + toString(entry.getValue()));
			}
			
			System.out.println(indentation + "Any");
			for (FeatureMap.Entry entry : any.getAny()) {
				System.out.println(indentation + "\t" + toString(entry.getEStructuralFeature()));
				System.out.println(indentation + "\t" + toString(entry.getValue()));
			}
			
			System.out.println(indentation + "AnyAttribute");
			for (FeatureMap.Entry entry : any.getAnyAttribute()) {
				System.out.println(indentation + "\t" + toString(entry.getEStructuralFeature()));
				System.out.println(indentation + "\t" + toString(entry.getValue()));
			}
			
			for (FeatureMap.Entry entry : any.getMixed()) {
				if (entry.getValue() instanceof AnyType) {
					inspectAnyType((AnyType)entry.getValue(), indentation + "\t");
				}
			}
			
			for (FeatureMap.Entry entry : any.getAny()) {
				if (entry.getValue() instanceof AnyType) {
					inspectAnyType((AnyType)entry.getValue(), indentation + "\t");
				}
			}
			
			for (FeatureMap.Entry entry : any.getAnyAttribute()) {
				if (entry.getValue() instanceof AnyType) {
					inspectAnyType((AnyType)entry.getValue(), indentation + "\t");
				}
			}
			
			System.out.println("end");
		}
	}
	
	
	private static String toString(EStructuralFeature feature) {
		if (feature instanceof EReference) {
			return "EReference (name: " + feature.getName() + ", containment: " + ((EReference)feature).isContainment() + ")";
			
		} else {
			return "EAttribute (name: " + feature.getName() + ")";
		}
	}
	
	private static String toString(Object o) {
		if (o instanceof AnyType) {
			return "AnyType";
			
		} else if (o instanceof DynamicEObjectImpl) {
			return "DynamicEObject (eClass: " + ((EObject)o).eClass().getName() + ")"; 
		
		} else {
			return o.toString();
		}
	}
}
