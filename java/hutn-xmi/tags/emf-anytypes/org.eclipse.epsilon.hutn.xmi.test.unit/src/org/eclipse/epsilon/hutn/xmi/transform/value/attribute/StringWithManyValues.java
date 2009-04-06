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
package org.eclipse.epsilon.hutn.xmi.transform.value.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.epsilon.hutn.model.hutn.AttributeSlot;
import org.eclipse.epsilon.hutn.test.model.families.FamiliesPackage;
import org.eclipse.epsilon.hutn.xmi.transform.AbstractAttributeValueTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringWithManyValues extends AbstractAttributeValueTest {

	@BeforeClass
	public static void setup() {
		final EList<String> addresses = new BasicEList<String>();
		addresses.add("10 Main Street");
		addresses.add("12 Heslington Road");
		
		attributeValueTest(addresses, FamiliesPackage.eINSTANCE.getFamily_Address());
	}
	
	@Test
	public void slotHasCorrectFeatureName() {
		assertEquals("address", slot.getFeature());
	}
	
	@Test
	public void slotIsCorrectType() {
		assertTrue(slot instanceof AttributeSlot);
	}
	
	@Test
	public void slotHasTwoValues() {
		assertEquals(2, slot.getValues().size());
	}
	
	@Test
	public void slotHasCorrectFirstValue() {
		assertEquals("10 Main Street", slot.getValues().get(0));
	}
	
	@Test
	public void slotHasCorrectSecondValue() {
		assertEquals("12 Heslington Road", slot.getValues().get(1));
	}
}
