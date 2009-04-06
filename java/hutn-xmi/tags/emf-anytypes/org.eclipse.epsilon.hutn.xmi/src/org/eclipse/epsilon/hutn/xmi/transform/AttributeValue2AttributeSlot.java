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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.epsilon.hutn.model.hutn.AttributeSlot;
import org.eclipse.epsilon.hutn.model.hutn.HutnFactory;
import org.eclipse.epsilon.hutn.xmi.transform.util.EListUtil;

public class AttributeValue2AttributeSlot {

	private final EList<?> values;
	private final String featureName;
	
	public AttributeValue2AttributeSlot(Object value, String featureName) {
		if (value instanceof EList<?>) {
			this.values = (EList<?>)value;
		} else {
			this.values = EListUtil.singletonEList(value);
		}
		
		this.featureName = featureName;
	}
	
	public AttributeValue2AttributeSlot(Object value, EAttribute feature) {
		this(value, feature.getName());
	}

	public AttributeSlot transform() {
		final AttributeSlot slot = HutnFactory.eINSTANCE.createAttributeSlot();
		slot.setFeature(featureName);
		slot.getValues().addAll(values);
		return slot;
	}
}
