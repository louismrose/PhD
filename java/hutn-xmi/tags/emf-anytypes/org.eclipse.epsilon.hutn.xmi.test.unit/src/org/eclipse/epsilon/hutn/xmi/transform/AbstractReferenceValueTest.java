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

import org.eclipse.emf.ecore.EReference;
import org.eclipse.epsilon.hutn.model.hutn.Slot;
import org.eclipse.epsilon.hutn.xmi.transform.util.ClassObjectCache;

public class AbstractReferenceValueTest {

	protected static Slot<?> slot;
	
	protected static void referenceValueTest(Object object, EReference feature) {
		referenceValueTest(object, feature, new ClassObjectCache());
	}
	
	protected static void referenceValueTest(Object object, EReference feature, ClassObjectCache cache) {
		slot = new ReferenceValue2ClassObjectSlot(object, feature, cache).transform();
	}
}
