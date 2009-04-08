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
package org.eclipse.epsilon.hutn.xmi.test.integration.inconsistent.object;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.eclipse.epsilon.hutn.xmi.test.util.HutnTestUtil.slotTest;

import java.net.URISyntaxException;

import org.eclipse.epsilon.hutn.model.hutn.AttributeSlot;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.ContainmentSlot;
import org.eclipse.epsilon.hutn.model.hutn.PackageObject;
import org.eclipse.epsilon.hutn.test.models.util.FileUtil;
import org.eclipse.epsilon.hutn.xmi.test.integration.HutnXmiBridgeIntegrationTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class AbstractClass extends HutnXmiBridgeIntegrationTest {
	
	@BeforeClass
	public static void setup() throws URISyntaxException {
		integrationTestWithModelAsRoot(FileUtil.getFile("ObjectWithAbstractClass.model", AbstractClass.class));
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
	public void modelContainmentSlotContainsANamedElement() {
		assertEquals("NamedElement", getNamedElement().getType());
	}
	
	@Test
	public void namedElementContainsAttributeSlot() {
		assertTrue(getNamedElement().getSlots().get(0) instanceof AttributeSlot);
	}
	
	@Test
	public void namedElementAttributeSlotContainsOneObject() {
		assertEquals(1, getNamedElement().getSlots().get(0).getValues().size());
	}
	
	@Test
	public void namedElementAttributeSlotContainsCorrectValue() {
		assertEquals("element", getNamedElement().getSlots().get(0).getValues().get(0));
	}
	
	
	private static ClassObject getNamedElement() {
		return (ClassObject)getModel().getSlots().get(0).getValues().get(0);
	}
}
