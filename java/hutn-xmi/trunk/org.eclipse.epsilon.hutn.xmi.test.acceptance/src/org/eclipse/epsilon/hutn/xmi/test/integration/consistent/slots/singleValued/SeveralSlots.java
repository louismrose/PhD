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
package org.eclipse.epsilon.hutn.xmi.test.integration.consistent.slots.singleValued;

import static org.eclipse.epsilon.hutn.xmi.test.util.HutnTestUtil.slotTest;
import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.hutn.model.hutn.AttributeSlot;
import org.eclipse.epsilon.hutn.model.hutn.ReferenceSlot;
import org.eclipse.epsilon.hutn.xmi.HutnXmiBridgeException;
import org.eclipse.epsilon.hutn.xmi.test.integration.HutnXmiBridgeIntegrationTest;
import org.junit.Before;
import org.junit.Test;

public class SeveralSlots extends HutnXmiBridgeIntegrationTest {
	
	@Before
	public void setup() throws HutnXmiBridgeException {
		integrationTest("<?xml version=\"1.0\" encoding=\"ASCII\"?>" +
		                "<families:Family xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:families=\"families\" xmi:id=\"_seJr0BPDEd6ysY9kXe1lIA\" " + getAttributes() + " />");
	}
	
	private java.lang.String getAttributes() {
		return "pets=\"_OI43YBPgEd6ysY9kXe1lIA\" " +
		       "name=\"The Smiths\" " +
		       "numberOfChildren=\"2\" " +
		       "nuclear=\"false\"";
	}

	@Test
	public void correctNumberOfSlots() {
		assertEquals(4, getModel().getSlots().size());
	}
	
	@Test
	public void petsSlot() {
		slotTest(getModel().findSlot("pets"), ReferenceSlot.class, "pets", "Pet");
	}
	
	@Test
	public void nameSlot() {
		slotTest(getModel().findSlot("name"), AttributeSlot.class, "name", "The Smiths");
	}
	
	@Test
	public void numberOfChildrenSlot() {
		slotTest(getModel().findSlot("numberOfChildren"), AttributeSlot.class, "numberOfChildren", 2);
	}
	
	@Test
	public void nuclearSot() {
		slotTest(getModel().findSlot("nuclear"), AttributeSlot.class, "nuclear", false);
	}
}
