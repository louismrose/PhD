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
package org.eclipse.epsilon.hutn.xmi.test.acceptance.valid.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URISyntaxException;

import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.PackageObject;
import org.eclipse.epsilon.hutn.model.hutn.ReferenceSlot;
import org.eclipse.epsilon.hutn.model.hutn.Slot;
import org.eclipse.epsilon.hutn.test.models.util.FileUtil;
import org.eclipse.epsilon.hutn.xmi.test.acceptance.valid.ValidAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;


public class Reference extends ValidAcceptanceTest {
	
	private static PackageObject pkg;
	private static ClassObject model;
	private static ClassObject family;
	private static Slot<?> slot;
	
	@BeforeClass
	public static void setup() throws URISyntaxException {
		validAcceptanceTest(FileUtil.getFile("TypesReferences.model", Reference.class));
		
		pkg    = spec.getObjects().get(0);
		model  = pkg.getClassObjects().get(0);
		family = (ClassObject)model.findSlot("contents").getValues().get(1);
		slot   = family.findSlot("pets");
	}
	
	@Test
	public void slotIsCorrectType() {
		assertTrue(slot instanceof ReferenceSlot);
	}

	@Test
	public void slotHasCorrectNumberOfValues() {
		assertEquals(1, slot.getValues().size());
	}
	
	@Test
	public void slotHasCorrectContent() {
		assertEquals("Pet", ((ReferenceSlot)slot).getClassObjects().get(0).getType());
	}
}
