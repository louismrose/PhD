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
import static org.junit.Assert.fail;

import java.io.IOException;

import org.eclipse.epsilon.hutn.xmi.HutnXmiBridgeException;
import org.eclipse.epsilon.hutn.xmi.Xmi2Hutn;
import org.eclipse.epsilon.hutn.xmi.test.acceptance.HutnXmiBridgeAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class DifferentNsUri extends HutnXmiBridgeAcceptanceTest {
	
	@BeforeClass
	public static void setup() throws IOException {
		try {
			spec = new Xmi2Hutn("<?xml version=\"1.0\" encoding=\"ASCII\"?>" +
			                    "<bankAccounts:Accounts xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bankAccounts=\"bankAccounts\" xmi:id=\"_I6yJURhKEd6d_-caKAfnUw\" />").getSpec();
		
		} catch (HutnXmiBridgeException e) {
			fail("Caught exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void hasOneNsUri() {
		assertEquals(1, spec.getNsUris().size());
	}
	
	@Test
	public void hasCorrectNsUriValue() {
		assertEquals("bankAccounts", spec.getNsUris().get(0).getValue());
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
	public void linkedToBankAccountsEPackage() {
		assertEquals("bankAccounts", getPackageObject().getMetamodel().get(0).getName());
	}
}
