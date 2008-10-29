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
 * $Id:$
 */
package migration.test.acceptance.refactorings.mine;

import migration.test.acceptance.AcceptanceTest;

import org.junit.BeforeClass;
import org.junit.Test;

public class MergeReferences extends AcceptanceTest {

	@BeforeClass
	public static void setup() {
		metamodel = "Metamodel {"                                                                 +
		            "  EPackage \"Metamodel\" {"                                                  +
		            "    eClassifiers: EClass \"Signature\" {"                                    +
		            "                    eStructuralFeatures: containment EReference \"ports\" {" +
		            "                                           eType: EClass \"Port\""           +
		            "                                           lowerBound: 0"                    +
		            "                                           upperBound: -1"                   +
		            "                                         }"                                  +
		            "                  },"                                                        +
		            "                  abstract EClass \"Port\" {},"                              +
		            "                  EClass \"InPort\"  { eSuperTypes: EClass \"Port\" },"      +
		            "                  EClass \"OutPort\" { eSuperTypes: EClass \"Port\" }"       +
		            "  }"                                                                         +
		            "}";
		
		slotModel = "SlotModel {"                     +
		            "  Signature \"s\" {"             +
		            "    inPorts:  InPort \"p1\"  {}" +
		            "    outPorts: OutPort \"p2\" {}" +
		            "  }"                             +
		            "}";
		
		acceptanceTest();
		
		migratedModel.setVariable("s", "ClassObject.all.selectOne(c|c.identifier='s')");
		migratedModel.setVariable("slot", "s.slots.first");
		migratedModel.setVariable("p1", "ClassObject.all.selectOne(c|c.identifier='p1')");
		migratedModel.setVariable("p2", "ClassObject.all.selectOne(c|c.identifier='p2')");
	}
	
	@Test
	public void sHasOnlyOneSlot() {
		migratedModel.assertEquals(1, "s.slots.size()");
	}
	
	@Test
	public void slotIsCorrectType() {
		migratedModel.assertTrue("ContainmentSlot.isType(slot)");
	}
	
	@Test
	public void slotIsForPorts() {
		migratedModel.assertEquals("ports", "slot.feature");
	}
	
	@Test
	public void slotContainsP1() {
		migratedModel.assertTrue("slot.classObjects.includes(p1)");
	}
	
	@Test
	public void slotContainsP2() {
		migratedModel.assertTrue("slot.classObjects.includes(p2)");
	}
}
