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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.hutn.xmi.transform.util.ClassObjectCache;

public class EObject2Slots extends Object2Slots {
	
	public EObject2Slots(EObject object, ClassObjectCache cache) {
		super(object, cache);
	}

	protected void doTransform() {
		for (EStructuralFeature feature : object.eClass().getEAllStructuralFeatures()) {
			if (object.eIsSet(feature)) {
				transform(object.eGet(feature), feature);
			}
		}
	}
	
	private void transform(Object value, EStructuralFeature feature) {
		if (feature instanceof EAttribute) {
			transformAttributeValue(value, feature.getName());
			
		} else if (feature instanceof EReference) {
			transformReferenceValue(value, feature.getName(), ((EReference)feature).isContainment());
		
		} else {
			throw new IllegalStateException("Cannot transform values of feature: " + feature);
		}
	}
}
