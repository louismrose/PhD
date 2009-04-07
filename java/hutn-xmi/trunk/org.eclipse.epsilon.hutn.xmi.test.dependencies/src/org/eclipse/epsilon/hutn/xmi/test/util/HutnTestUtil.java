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
package org.eclipse.epsilon.hutn.xmi.test.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.ClassObjectSlot;
import org.eclipse.epsilon.hutn.model.hutn.Slot;

public abstract class HutnTestUtil {
	
	private HutnTestUtil() {}
	
	public static void slotTest(Slot<?> slot, Class<? extends Slot<?>> expectedType, String expectedFeature, Object... expectedValues) {
		assertTrue(expectedType.isInstance(slot));
		assertEquals(expectedFeature, slot.getFeature());
		assertEquals(expectedValues.length, slot.getValues().size());
		
		
		if (slot instanceof ClassObjectSlot<?>) {
			// compare types of class objects
			for (int index = 0; index < ((ClassObjectSlot<?>)slot).getClassObjects().size(); index++) {
				final ClassObject value     = ((ClassObjectSlot<?>)slot).getClassObjects().get(index);
				final Object expectedValue = expectedValues[index];
				
				assertEquals(expectedValue, value.getType());
			}
		
		
		} else {
			// compare values
			for (int index = 0; index < slot.getValues().size(); index++) {
				final Object value         = slot.getValues().get(index);
				final Object expectedValue = expectedValues[index]; 
	
					assertTrue(expectedValue.getClass().isInstance(value));
					assertEquals(expectedValue, value);
			}
		}
	}
}
