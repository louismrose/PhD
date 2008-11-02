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
public class ExtractClass extends AcceptanceTest {

	@BeforeClass
	public static void setup() {
		metamodel = "Metamodel {"                                                                    +
		            "  EPackage \"Metamodel\" {"                                                     +
		            "    eClassifiers: EClass \"Person\" {"                                          +
		            "                    eStructuralFeatures: EAttribute \"name\" {"                 +
		            "                                           eType: EDataType \"String\""         +
		            "                                         },"                                    +
		            "                                         containment EReference \"telNo\" {"    +
		            "                                           eType: EClass \"TelephoneNumber\""   +
		            "                                           lowerBound: 1"                       +
		            "                                           upperBound: 1"                       +
		            "                                         }"                                     +
		            "                  },"                                                           +
		            "                  EClass \"TelephoneNumber\" {"                                 +
		            "                    eStructuralFeatures: EAttribute \"areaCode\" {"             +
		            "                                           eType: EDataType \"String\""         +
		            "                                         },"                                    +
		            "                                         EAttribute \"number\" {"               +
		            "                                           eType: EDataType \"String\""         +
		            "                                         }"                                     +
		            "                  },"                                                           +
		            "                  EDataType \"String\" { "                                      +
		            "                    instanceTypeName: \"java.lang.String\""                     +
		            "                  }"                                                            +
		            "  }"                                                                            +
		            "}";
		
		slotModel = "SlotModel {"                     +
		            "  Person \"John\" {"             +
		            "    name:     \"John\""          +
		            "    areaCode: \"01234\""         +
		            "    number:   \"567890\""        +
		            "  }"                             +
		            "}";
		
		acceptanceTest("Debug.model");
		
		migratedModel.setVariable("john",          "ClassObject.all.selectOne(c|c.identifier='John')");
		migratedModel.setVariable("nameSlot",      "john.slots.first");
		migratedModel.setVariable("telephoneSlot", "john.slots.last");
		
		migratedModel.setVariable("telephone",     "ClassObject.all.selectOne(c|c.identifier<>'John')");
		migratedModel.setVariable("areaCodeSlot",  "telephone.slots.first");
		migratedModel.setVariable("numberSlot",    "telephone.slots.last");
	}
	
	@Test
	public void johnHasTwoSlots() {
		migratedModel.assertEquals(2, "john.slots.size()");
	}
	
	@Test
	public void johnHasCorrectName() {
		migratedModel.assertEquals("John", "nameSlot.values.first");
	}
	
	@Test
	public void telephoneSlotIsCorrectType() {
		migratedModel.assertTrue("ContainmentSlot.isType(telephoneSlot)");
	}
	
	@Test
	public void telephoneSlotContainsOneObject() {
		migratedModel.assertEquals(1, "telephoneSlot.classObjects.size()");
	}
	
	@Test
	public void telephoneSlotContainsTelephoneNumber() {
		migratedModel.assertTrue("telephoneSlot.classObjects.includes(telephone)");
	}
	
	@Test
	public void telephoneHasTwoSlots() {
		migratedModel.assertEquals(2, "telephone.slots.size()");
	}
	
	@Test
	public void telephoneHasCorrectAreaCode() {
		migratedModel.assertEquals("01234", "areaCodeSlot.values.first");
	}
	
	@Test
	public void telephoneHasCorrectNumber() {
		migratedModel.assertEquals("567890", "numberSlot.values.first");
	}
	
}
