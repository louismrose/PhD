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

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.Slot;
import org.eclipse.epsilon.hutn.xmi.transform.slots.AnyType2Slots;
import org.eclipse.epsilon.hutn.xmi.transform.slots.EObject2Slots;
import org.eclipse.epsilon.hutn.xmi.transform.util.ClassObjectCache;

class EObject2ClassObject {
		
	private final EObject object;
	private final ClassObjectCache cache;
	
	private ClassObject classObject;

	public EObject2ClassObject(EObject object, ClassObjectCache cache) {
		this.object = object;
		this.cache  = cache;
	}

	ClassObject transform() {
		this.classObject = cache.getFor(object);
		
		transformRecognisedFeatures();
		transformUnrecognisedFeatures();
		
		return classObject;
	}
	
	
	private void transformRecognisedFeatures() {
		addSlots(new EObject2Slots(object, cache).transform());
	}
	
	private void transformUnrecognisedFeatures() {
		addSlots(new AnyType2Slots(object, cache).transform());
	}
	
	private void addSlots(List<Slot<?>> slots) {
		classObject.getSlots().addAll(slots);
	}
	
}
