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
package org.eclipse.epsilon.hutn.xmi.test.acceptance.consistent.slots;

import static org.eclipse.epsilon.hutn.xmi.test.util.HutnTestUtil.slotTest;
import static org.eclipse.epsilon.hutn.xmi.test.util.HutnTestUtil.EnumValue;

import org.eclipse.epsilon.hutn.model.hutn.AttributeSlot;
import org.eclipse.epsilon.hutn.xmi.HutnXmiBridgeException;
import org.eclipse.epsilon.hutn.xmi.Xmi2Hutn;
import org.eclipse.epsilon.hutn.xmi.test.acceptance.HutnXmiBridgeAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;


public class Enum extends HutnXmiBridgeAcceptanceTest {
	
	@BeforeClass
	public static void setup() throws HutnXmiBridgeException {
		spec = new Xmi2Hutn("<?xml version=\"1.0\" encoding=\"ASCII\"?>" +
		                    "<families:Dog xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:families=\"families\" xmi:id=\"_seJr0BPDEd6ysY9kXe1lIA\" breed=\"labrador\"/>")
		       .getSpec();
	}
	
	@Test
	public void testSlot() {
		slotTest(getModel().getSlots().get(0), AttributeSlot.class, "breed", new EnumValue("labrador"));
	}
}
