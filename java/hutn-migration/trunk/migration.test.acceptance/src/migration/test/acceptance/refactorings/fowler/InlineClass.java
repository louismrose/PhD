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
public class InlineClass extends AcceptanceTest {

	@BeforeClass
	public static void setup() {
		metamodel = "Metamodel {"                                                            +
		            "  EPackage \"Metamodel\" {"                                             +
		            "    eClassifiers: EClass \"Person\" {"                                  +
		            "                    eStructuralFeatures: EAttribute \"name\" {"         +
		            "                                           eType: EDataType \"String\"" +
		            "                                         },"                            +
		            "                                         EAttribute \"areaCode\" {"     +
		            "                                           eType: EDataType \"String\"" +
		            "                                         },"                            +
		            "                                         EAttribute \"number\" {"       +
		            "                                           eType: EDataType \"String\"" +
		            "                                         }"                             +
		            "                  },"                                                   +
		            "                  EDataType \"String\" { "                              +
		            "                    instanceTypeName: \"java.lang.String\""             +
		            "                  }"                                                    +
		            "  }"                                                                    +
		            "}";
		
		slotModel = "SlotModel {"                          +
		            "  Person \"John\" {"                  +
		            "    name:  \"John\""                  +
		            "    telNo: TelephoneNumber \"tel\" {" +
		            "      areaCode: \"01234\""            +
		            "      number:   \"567890\""           +
		            "    }"                                +
		            "  }"                                  +
		            "}";
		
		acceptanceTest("Debug.model");
		
		migratedModel.setVariable("john",          "ClassObject.all.selectOne(c|c.identifier='John')");
		migratedModel.setVariable("nameSlot",      "john.findSlot('name')");
		migratedModel.setVariable("areaCodeSlot",  "john.findSlot('areaCode')");
		migratedModel.setVariable("numberSlot",    "john.findSlot('number')");
	}
	
	@Test
	public void johnHasThreeSlots() {
		migratedModel.assertEquals(3, "john.slots.size()");
	}
	
	@Test
	public void johnHasNameSlot() {
		migratedModel.assertTrue("nameSlot.isDefined()");
	}
	
	@Test
	public void johnHasAreaCodeSlot() {
		migratedModel.assertTrue("areaCodeSlot.isDefined()");
	}
	
	@Test
	public void johnHasNumberSlot() {
		migratedModel.assertTrue("numberSlot.isDefined()");
	}
	
	@Test
	public void johnHasCorrectName() {
		migratedModel.assertEquals("John", "nameSlot.values.first");
	}
	
	@Test
	public void johnHasCorrectAreaCode() {
		migratedModel.assertEquals("01234", "areaCodeSlot.values.first");
	}
	
	@Test
	public void telephoneHasCorrectNumber() {
		migratedModel.assertEquals("567890", "numberSlot.values.first");
	}
	
}
