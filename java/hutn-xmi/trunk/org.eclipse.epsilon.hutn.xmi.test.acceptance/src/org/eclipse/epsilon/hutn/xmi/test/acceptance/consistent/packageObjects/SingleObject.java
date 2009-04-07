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
package org.eclipse.epsilon.hutn.xmi.test.acceptance.consistent.packageObjects;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.eclipse.epsilon.hutn.xmi.test.acceptance.HutnXmiBridgeAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class SingleObject extends HutnXmiBridgeAcceptanceTest {
	
	@BeforeClass
	public static void setup() throws IOException {
		validAcceptanceTest("");
	}
	
	@Test
	public void hasOneNsUri() {
		assertEquals(1, spec.getNsUris().size());
	}
	
	@Test
	public void hasCorrectNsUriValue() {
		assertEquals("families", spec.getNsUris().get(0).getValue());
	}
	
	@Test
	public void hasOnePackageObject() {
		assertEquals(1, spec.getObjects().size());
	}
	
	@Test
	public void linkedToOneEPackage() {
		assertEquals(1, getPackageObject().getMetamodel().size());
	}
	
	@Test
	public void linkedToFamiliesEPackage() {
		assertEquals("families", getPackageObject().getMetamodel().get(0).getName());
	}
	
	@Test
	public void hasOneClassObject() {
		assertEquals(1, getPackageObject().getClassObjects().size());
	}
	
	@Test
	public void classObjectHasCorrectType() {
		assertEquals("Model", getModel().getType());
	}
}
