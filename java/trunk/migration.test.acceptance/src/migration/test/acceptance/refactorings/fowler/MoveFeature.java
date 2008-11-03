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
 * Based on the Fowler Refactoring "Move Feature."
 *
 * @author louis
 */
public class MoveFeature extends AcceptanceTest {

	@BeforeClass
	public static void setup() {
		metamodel = "Metamodel {"                                                                +
		            "  EPackage \"Metamodel\" {"                                                 +
		            "    eClassifiers: EClass \"Account\" {"                                     +
		            "                    eStructuralFeatures: EAttribute \"code\" {"             +
		            "                                           eType: EDataType \"String\""     +
		            "                                         },"                                +
		            "                                         EReference \"type\" {"             +
		            "                                           eType: EClass \"AccountType\""   +
		            "                                           lowerBound: 1"                   +
		            "                                           upperBound: 1"                   +
		            "                                         }"                                 +
		            "                  },"                                                       +
		            "                  EClass \"AccountType\" {"                                 +
		            "                    eStructuralFeatures: EAttribute \"name\" {"             +
		            "                                           eType: EDataType \"String\""     +
		            "                                         },"                                +
		            "                                         EAttribute \"interestRate\" {"     +
		            "                                           eType: EDataType \"Float\""      +
		            "                                         }"                                 +
		            "                  },"                                                       +
		            "                  EDataType \"String\" { "                                  +
		            "                    instanceTypeName: \"java.lang.String\""                 +
		            "                  },"                                                       +
		            "                  EDataType \"Float\" { "                                   +
		            "                    instanceTypeName: \"float\""                            +
		            "                  }"                                                        +
		            "  }"                                                                        +
		            "}";
		
		slotModel = "SlotModel {"                               +
		            "  Account \"a\" {"                         +
		            "    code:         \"1234a\""               +
		            "    interestRate: 0.035"                   +
		            "    type:         AccountType \"current\"" +
		            "  }"                                       +
		            "  AccountType \"current\" {"               +
		            "    name: \"current\""                     +
		            "  }"                                       +
		            "}";
		
		acceptanceTest("Debug.model");
		
		migratedModel.setVariable("account",     "ClassObject.all.selectOne(c|c.identifier='a')");
		migratedModel.setVariable("accountType", "ClassObject.all.selectOne(c|c.identifier='current')");
		
		migratedModel.setVariable("interestRateSlot", "accountType.findSlot('interestRate')");
	}
	
	@Test
	public void accountHas2Slots() {
		migratedModel.assertEquals(2, "account.slots.size()");
	}
	
	@Test
	public void accountDoesNotHaveAnInterestRateSlot() {
		migratedModel.assertTrue("account.findSlot('interestRate').isUndefined()");
	}
	
	@Test
	public void accountTypeHas2Slots() {
		migratedModel.assertEquals(2, "accountType.slots.size()");
	}
	
	@Test
	public void accountTypeHasInterestRateSlot() {
		migratedModel.assertTrue("interestRateSlot.isDefined()");
	}
	
	@Test
	public void interestRateHasCorrectValue() {
		migratedModel.assertEquals(0.035, "interestRateSlot.values.first");
	}
}
