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
package org.eclipse.epsilon.hutn.xmi.test.acceptance.valid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URISyntaxException;

import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.ContainmentSlot;
import org.eclipse.epsilon.hutn.model.hutn.PackageObject;
import org.eclipse.epsilon.hutn.test.models.util.FileUtil;
import org.junit.BeforeClass;
import org.junit.Test;

public class NestedObjects extends ValidAcceptanceTest {
	
	@BeforeClass
	public static void setup() throws URISyntaxException {
		validAcceptanceTest(FileUtil.getFile("NestedObjects.model", NestedObjects.class));
	}
	
	@Test
	public void hasOneNsUris() {
		assertEquals(1, spec.getNsUris().size());
	}
	
	@Test
	public void hasFamiliesNsUri() {
		assertEquals("families", spec.getNsUris().get(0).getValue());
	}
	
	@Test
	public void hasOnePackageObject() {
		assertEquals(1, spec.getObjects().size());
	}
	
	@Test
	public void packageObjectContainsOneClassObject() {
		assertEquals(1, getPackageObject().getClassObjects().size());
	}
	
	@Test
	public void modelContainsOneSlot() {
		assertEquals(1, getModel().getSlots().size());
	}
	
	@Test
	public void modelContainsContainmentSlot() {
		assertTrue(getModel().getSlots().get(0) instanceof ContainmentSlot);
	}
	
	@Test
	public void modelContainmentSlotContainsOneObject() {
		assertEquals(1, getModel().getSlots().get(0).getValues().size());
	}
	
	@Test
	public void modelContainmentSlotContainsAFamily() {
		assertEquals("Family", getFamily().getType());
	}
	
	@Test
	public void familyContainsOneSlot() {
		assertEquals(1, getFamily().getSlots().size());
	}
	
	@Test
	public void familyContainsContainmentSlot() {
		assertTrue(getFamily().getSlots().get(0) instanceof ContainmentSlot);
	}
	
	@Test
	public void familyContainmentSlotContainsOneObject() {
		assertEquals(1, getFamily().getSlots().get(0).getValues().size());
	}
	
	@Test
	public void familyContainmentSlotContainsAPerson() {
		assertEquals("Person", ((ClassObject)getFamily().getSlots().get(0).getValues().get(0)).getType());
	}
}