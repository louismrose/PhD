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
public class PushDownFeature extends AcceptanceTest {

	@BeforeClass
	public static void setup() {
		metamodel = "Metamodel {"                                                             +
		            "  EPackage \"Metamodel\" {"                                              +
		            "    eClassifiers: EClass \"Employee\" {"                                 +
		            "                    eStructuralFeatures: EAttribute \"name\" {"          +
		            "                                           eType: EDataType \"String\""  +
		            "                                         }"                              +
		            "                  },"                                                    +
		            "                  EClass \"Salesperson\" {"                              +
		            "                    eStructuralFeatures: EAttribute \"quota\" {"         +
		            "                                           eType: EDataType \"Integer\"" +
		            "                                         }"                              +
		            "                    eSuperTypes: EClass \"Employee\""                    +
		            "                  },"                                                    +
		            "                  EDataType \"String\" { "                               +
		            "                    instanceTypeName: \"java.lang.String\""              +
		            "                  },"                                                    +
		            "                  EDataType \"Integer\" { "                              +
		            "                    instanceTypeName: \"int\""                           +
		            "                  }"                                                     +
		            "  }"                                                                     +
		            "}";
		
		slotModel = "SlotModel {"             +
                    "  Employee \"barney\" {" +
                    "    name: \"Barney\""    +
                    "  }"                     +
		            "  Employee \"emily\" {"  +
		            "    name: \"Emily\""     +
		            "    quota: 1"            +
		            "  }"                     +
		            "  Salesperson \"sam\" {" +
		            "    name: \"Sam\""       +
		            "    quota: 2"            +
		            "  }"                     +
		            "}";
		
		acceptanceTest("Debug.model");
		
		migratedModel.setVariable("barney", "ClassObject.all.selectOne(c|c.identifier='barney')");
		migratedModel.setVariable("emily",  "ClassObject.all.selectOne(c|c.identifier='emily')");
		migratedModel.setVariable("sam",    "ClassObject.all.selectOne(c|c.identifier='sam')");
	}
	
	@Test
	public void barneyHasOneSlot() {
		migratedModel.assertEquals(1, "barney.slots.size()");
	}
	
	@Test
	public void barneyIsEmployee() {
		migratedModel.assertEquals("Employee", "barney.type");
	}
	
	@Test
	public void emilyHasTwoSlots() {
		migratedModel.assertEquals(2, "emily.slots.size()");
	}
	
	@Test
	public void emilyIsSalesperson() {
		migratedModel.assertEquals("Salesperson", "emily.type");
	}
	
	@Test
	public void emilyHasCorrectQuota() {
		migratedModel.assertEquals(1, "emily.findSlot('quota').values.first");
	}
	
	@Test
	public void samHasTwoSlots() {
		migratedModel.assertEquals(2, "sam.slots.size()");
	}
	
	@Test
	public void samIsSalesperson() {
		migratedModel.assertEquals("Salesperson", "sam.type");
	}
	
	@Test
	public void samHasCorrectQuota() {
		migratedModel.assertEquals(2, "sam.findSlot('quota').values.first");
	}
}
