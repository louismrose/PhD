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

import static org.junit.Assert.assertTrue;

import org.eclipse.epsilon.hutn.xmi.HutnXmiBridgeException;
import org.eclipse.epsilon.hutn.xmi.Xmi2Hutn;
import org.eclipse.epsilon.hutn.xmi.test.acceptance.HutnXmiBridgeAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmptyModel extends HutnXmiBridgeAcceptanceTest {
	
	@BeforeClass
	public static void setup() throws HutnXmiBridgeException {
		spec = new Xmi2Hutn("<?xml version=\"1.0\" encoding=\"ASCII\"?>\n").getSpec();
	}
	
	@Test
	public void hasNoNsUris() {
		assertTrue(spec.getNsUris().isEmpty());
	}
	
	@Test
	public void hasNoPackageObjects() {
		assertTrue(spec.getObjects().isEmpty());
	}
}
