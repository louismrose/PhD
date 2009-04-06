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

import org.eclipse.epsilon.hutn.model.hutn.AttributeSlot;
import org.eclipse.epsilon.hutn.test.model.families.FamiliesPackage;
import org.eclipse.epsilon.hutn.xmi.transform.AbstractAttributeValueTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringWithSingleValue extends AbstractAttributeValueTest {

	@BeforeClass
	public static void setup() {
		attributeValueTest("John Doe", FamiliesPackage.eINSTANCE.getNamedElement_Name());
	}
	
	@Test
	public void slotHasCorrectFeatureName() {
		assertEquals("name", slot.getFeature());
	}
	
	@Test
	public void slotIsCorrectType() {
		assertTrue(slot instanceof AttributeSlot);
	}
	
	@Test
	public void slotHasOneValue() {
		assertEquals(1, slot.getValues().size());
	}
	
	@Test
	public void slotHasCorrectValue() {
		assertEquals("John Doe", slot.getValues().get(0));
	}
}
