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
package org.eclipse.epsilon.hutn.xmi.transform.eObject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.epsilon.hutn.model.hutn.ContainmentSlot;
import org.eclipse.epsilon.hutn.model.hutn.Slot;
import org.eclipse.epsilon.hutn.xmi.test.unit.util.FamilyFactory;
import org.eclipse.epsilon.hutn.xmi.test.unit.util.PersonFactory;
import org.eclipse.epsilon.hutn.xmi.transform.AbstractEObjectTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class EObjectContainerWithTwoObjects extends AbstractEObjectTest {

	private static Slot<?> slot;
	
	@BeforeClass
	public static void setup() {
		eObjectTest(FamilyFactory.createFamily(PersonFactory.createPerson("Jack"),
		                                       PersonFactory.createPerson("Jill")));
		
		slot = classObject.getSlots().get(0);
	}
	
	@Test
	public void hasOneSlot() {
		assertEquals(1, classObject.getSlots().size());
	}
	
	@Test
	public void slotHasCorrectFeature() {
		assertEquals("members", slot.getFeature());
	}
	
	@Test
	public void slotIsCorrectType() {
		assertTrue(slot instanceof ContainmentSlot);
	}
	
	@Test
	public void slotContainsTwoItems() {
		assertEquals(2, slot.getValues().size());
	}
	
	@Test
	public void slotContainsFirstPerson() {
		assertEquals("Person", ((ContainmentSlot)slot).getValues().get(0).getType());
	}
	
	@Test
	public void firstPersonHasNameJack() {
		assertEquals("Jack", ((ContainmentSlot)slot).getValues().get(0).findSlot("name").getValues().get(0));
	}
	
	@Test
	public void slotContainsSecondPerson() {
		assertEquals("Person", ((ContainmentSlot)slot).getValues().get(1).getType());
	}
	
	@Test
	public void secondPersonHasNameJill() {
		assertEquals("Jill", ((ContainmentSlot)slot).getValues().get(1).findSlot("name").getValues().get(0));
	}
}
