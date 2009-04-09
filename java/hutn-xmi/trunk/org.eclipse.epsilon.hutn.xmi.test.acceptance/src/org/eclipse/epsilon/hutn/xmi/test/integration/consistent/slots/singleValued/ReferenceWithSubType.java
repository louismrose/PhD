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

import org.eclipse.epsilon.hutn.model.hutn.ReferenceSlot;
import org.eclipse.epsilon.hutn.xmi.test.integration.HutnXmiBridgeIntegrationTest;
import org.junit.BeforeClass;
import org.junit.Test;


public class ReferenceWithSubType extends HutnXmiBridgeIntegrationTest {
	
	@BeforeClass
	public static void setup() {
		integrationTestWithModelAsRoot("<contents xsi:type=\"families:Family\" xmi:id=\"_Qy0uEBPgEd6ysY9kXe1lIA\" pets=\"_OI43YBPgEd6ysY9kXe1lIA\"/>" +
		                               "<contents xsi:type=\"families:Dog\" xmi:id=\"_OI43YBPgEd6ysY9kXe1lIA\" />");
	}
	
	@Test
	public void testSlot() {
		slotTest(getFirstSlotOfFamily(), ReferenceSlot.class, "pets", "Dog");
	}
}
