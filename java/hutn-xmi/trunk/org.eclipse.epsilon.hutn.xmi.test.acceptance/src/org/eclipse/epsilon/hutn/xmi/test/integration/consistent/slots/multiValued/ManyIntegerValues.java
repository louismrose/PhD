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
package org.eclipse.epsilon.hutn.xmi.test.integration.consistent.slots.multiValued;

import static org.eclipse.epsilon.hutn.xmi.test.util.HutnTestUtil.slotTest;

import org.eclipse.epsilon.hutn.model.hutn.AttributeSlot;
import org.eclipse.epsilon.hutn.xmi.HutnXmiBridgeException;
import org.eclipse.epsilon.hutn.xmi.test.integration.HutnXmiBridgeIntegrationTest;
import org.junit.BeforeClass;
import org.junit.Test;


public class ManyIntegerValues extends HutnXmiBridgeIntegrationTest {

	@BeforeClass
	public static void setup() throws HutnXmiBridgeException {
		integrationTest("<?xml version=\"1.0\" encoding=\"ASCII\"?>" +
		                "<families:Family xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:families=\"families\" xmi:id=\"_seJr0BPDEd6ysY9kXe1lIA\">" +
		                 "	<lotteryNumbers>12</lotteryNumbers>" +
		                 "	<lotteryNumbers>32</lotteryNumbers>" +
		                 "</families:Family>");
	}
	
	@Test
	public void testSlot() {
		slotTest(getModel().getSlots().get(0), AttributeSlot.class, "lotteryNumbers", 12, 32);
	}
}
