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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.HutnFactory;

public class ClassObjectCache {

	private final Map<EObject, ClassObject> cache = new HashMap<EObject, ClassObject>();
	
	public ClassObject getFor(EObject object) {
		if (!cache.containsKey(object)) {
			cache.put(object, createFor(object));
		}
		
		return cache.get(object);
	}
	
	private ClassObject createFor(EObject object) {
		final ClassObject co = HutnFactory.eINSTANCE.createClassObject();
		co.setType(object.eClass().getName());
		co.setIdentifier(newIdentifierFor(object.eClass()));
		return co;
	}
	
	
	private final List<String> identifiers = new LinkedList<String>();
	private String newIdentifierFor(EClass type) {
		final String base = type.getName();
		int suffix = 1;
		
		while (identifiers.contains(base + suffix)) {
			suffix++;
		}
		
		return base + suffix;
	}
}
