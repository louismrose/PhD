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
package org.eclipse.epsilon.hutn.xmi.transform;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.ClassObjectSlot;
import org.eclipse.epsilon.hutn.model.hutn.HutnFactory;
import org.eclipse.epsilon.hutn.xmi.transform.util.ClassObjectCache;
import org.eclipse.epsilon.hutn.xmi.transform.util.EListUtil;

public class ReferenceValue2ClassObjectSlot {

	private final EList<EObject> values;
	private final String featureName;
	private final boolean featureIsContainment;
	private final ClassObjectCache cache;
	
	
	public ReferenceValue2ClassObjectSlot(Object value, EReference feature, ClassObjectCache cache) {
		this(value, feature.getName(), feature.isContainment(), cache);
	}

	public ReferenceValue2ClassObjectSlot(Object value,
	                                      String featureName,
	                                      boolean featureIsContainment,
	                                      ClassObjectCache cache) {
		
		if (value instanceof EObject) {
			this.values = EListUtil.singletonEList((EObject)value);
		
		} else if (value instanceof EList && EListUtil.elementsAreAllInstancesOf((EList<?>)value, EObject.class)) {
			this.values = EListUtil.castElements((EList<?>)value, EObject.class);
		
		} else {
			throw new IllegalArgumentException("value must be an instance of either EObject or EList<EObject>");
		}
		
		this.featureName = featureName;
		this.featureIsContainment = featureIsContainment;
		this.cache   = cache;
	}

	public ClassObjectSlot<?> transform() {
		final ClassObjectSlot<?> slot = createSlot();
		
		slot.setFeature(featureName);
		slot.setClassObjects(getClassObjects());
		
		return slot;
	}
	
	private ClassObjectSlot<?> createSlot() {
		return featureIsContainment ?
		       HutnFactory.eINSTANCE.createContainmentSlot() :
		       HutnFactory.eINSTANCE.createReferenceSlot();
	}
	
	private EList<ClassObject> getClassObjects() {
		final EList<ClassObject> results = new BasicEList<ClassObject>();
		
		for (EObject value : values) {
			if (featureIsContainment) {
				results.add(new EObject2ClassObject(value, cache).transform());
			} else {
				results.add(cache.getFor(value));
			}
		}
		
		return results;
	}
}
