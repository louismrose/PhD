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
package migration.test.acceptance.refactorings.fowler;

import migration.test.acceptance.AcceptanceTest;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Based on the Fowler Refactoring "Change Reference to Value."
 *
 * @author louis
 */
public class ChangeContainmentToReference extends AcceptanceTest {

	@BeforeClass
	public static void setup() {
		metamodel = "Metamodel {"                                                                    +
		            "  EPackage \"Metamodel\" {"                                                     +
		            "    eClassifiers: EClass \"System\" {"                                          +
		            "                    eStructuralFeatures: containment EReference \"contents\" {" +
		            "                                           eType: EClass \"ModelElement\""      +
		            "                                           lowerBound: 0"                       +
		            "                                           upperBound: -1"                      +
		            "                                         }"                                     +
		            "                  },"                                                           +
		            "                  abstract EClass \"ModelElement\" {},"                         +
		            "                  EClass \"Signature\" {"                                       +
		            "                    eSuperTypes: EClass\"ModelElement\""                        +
		            "                    eStructuralFeatures: EReference \"ports\" {"                +
		            "                                           eType: EClass \"Port\""              +
		            "                                           lowerBound: 0"                       +
		            "                                           upperBound: -1"                      +
		            "                                         }"                                     +
		            "                  },"                                                           +
		            "                  EClass \"Port\" { "                                           +
		            "                    eStructuralFeatures: EAttribute \"name\" {"                 +
		            "                                           eType: EDataType \"String\""         +
		            "                                         }"                                     +
		            "                    eSuperTypes: EClass \"ModelElement\""                       +
		            "                  },"                                                           +
		            "                  EDataType \"String\" { "                                      +
		            "                    instanceTypeName: \"java.lang.String\""                     +
		            "                  }"                                                            +
		            "  }"                                                                            +
		            "}";
		
		slotModel = "SlotModel {"                                          +
		            "  System \"sys\" {"                                   +
		            "    contents: Signature \"s1\" {"                     +
		            "                ports: Port \"p1\" { name: \"p1\" }"  +
		            "              },"                                     +
		            "              Signature \"s2\" {"                     +
		            "                ports: Port \"p2\" { name: \"p2\" }"  +
		            "              }"                                      +
		            "  }"                                                  +
		            "}";
		
		acceptanceTest("Debug.model");
		
		
		migratedModel.setVariable("sys",   "ClassObject.all.selectOne(c|c.identifier='sys')");
		
		migratedModel.setVariable("s1",    "ClassObject.all.selectOne(c|c.identifier='s1')");
		migratedModel.setVariable("s2",    "ClassObject.all.selectOne(c|c.identifier='s2')");
		
		migratedModel.setVariable("contents", "sys.slots.first.classObjects");
		
		migratedModel.setVariable("slot1", "s1.slots.first");
		migratedModel.setVariable("slot2", "s2.slots.first");
	}
	
	@Test
	public void systemContainsFourObjects() {
		migratedModel.assertEquals(4, "contents.size()");
	}
	
	@Test
	public void s1HasOnlyOneSlot() {
		migratedModel.assertEquals(1, "s1.slots.size()");
	}
	
	@Test
	public void s2HasOnlyOneSlot() {
		migratedModel.assertEquals(1, "s2.slots.size()");
	}
	
	@Test
	public void s1SlotIsCorrectType() {
		migratedModel.assertTrue("ReferenceSlot.isType(slot1)");
	}
	
	@Test
	public void s2SlotIsCorrectType() {
		migratedModel.assertTrue("ReferenceSlot.isType(slot2)");
	}
	
	@Test
	public void slot1IsForPorts() {
		migratedModel.assertEquals("ports", "slot1.feature");
	}
	
	@Test
	public void slot2IsForPorts() {
		migratedModel.assertEquals("ports", "slot2.feature");
	}
	
	@Test
	public void slot1ReferencesOnePort() {
		migratedModel.assertEquals(1, "slot1.identifiers.size()");
	}
	
	@Test
	public void slot2ReferencesOnePort() {
		migratedModel.assertEquals(1, "slot2.identifiers.size()");
	}
	
	@Test
	public void slot1ReferencesAPortNamedP1() {
		migratedModel.assertTrue("slot1.classObjects.exists(c|c.findSlot('name').values.first = 'p1')");
	}
	
	@Test
	public void slot2ReferencesAPortNamedP1() {
		migratedModel.assertTrue("slot2.classObjects.exists(c|c.findSlot('name').values.first = 'p2')");
	}
	
	@Test
	public void systemContainsP1() {
		migratedModel.assertTrue("contents.exists(c|c.findSlot('name').isDefined() and c.findSlot('name').values.first = 'p1')");
	}
	
	@Test
	public void systemContainsP2() {
		migratedModel.assertTrue("contents.exists(c|c.findSlot('name').isDefined() and c.findSlot('name').values.first = 'p2')");
	}
}
