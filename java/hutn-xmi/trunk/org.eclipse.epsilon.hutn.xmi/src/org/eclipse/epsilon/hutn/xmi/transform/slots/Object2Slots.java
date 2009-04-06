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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.hutn.model.hutn.Slot;
import org.eclipse.epsilon.hutn.xmi.transform.AttributeValue2AttributeSlot;
import org.eclipse.epsilon.hutn.xmi.transform.ReferenceValue2ClassObjectSlot;
import org.eclipse.epsilon.hutn.xmi.transform.util.ClassObjectCache;

public abstract class Object2Slots {
	
	protected final EObject object;
	private final ClassObjectCache cache;
	private final List<Slot<?>> slots = new LinkedList<Slot<?>>();
	
	public Object2Slots(EObject object, ClassObjectCache cache) {
		this.object = object;
		this.cache  = cache;
	}
	
	public List<Slot<?>> transform() {
		slots.clear();
		doTransform();
		return slots;
	}
	
	protected abstract void doTransform();
	
	protected void addSlot(Slot<?> slot) {
		slots.add(slot);
	}
	
	protected void transformAttributeValue(Object value, String featureName) {
		addSlot(new AttributeValue2AttributeSlot(value, featureName).transform());
	}
	
	protected void transformReferenceValue(Object value, String featureName, boolean featureIsContainment) {
		addSlot(new ReferenceValue2ClassObjectSlot(value, featureName, featureIsContainment, cache).transform());
	}

}
