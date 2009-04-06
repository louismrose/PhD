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
package org.eclipse.epsilon.hutn.xmi.transform.resource;

import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.hutn.test.model.bankAccounts.BankAccountsFactory;
import org.eclipse.epsilon.hutn.xmi.transform.AbstractResourceTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class ResourceWithObject extends AbstractResourceTest {

	@BeforeClass
	public static void setup() {
		resourceTest(BankAccountsFactory.eINSTANCE.createAccount());
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
	public void hasOneClassObject() {
		assertEquals(1, spec.getObjects().get(0).getClassObjects().size());
	}
}
