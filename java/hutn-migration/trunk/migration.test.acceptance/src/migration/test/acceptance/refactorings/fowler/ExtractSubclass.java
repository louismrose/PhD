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
public class ExtractSubclass extends AcceptanceTest {

	@BeforeClass
	public static void setup() {
		metamodel = "Metamodel {"                                                                    +
		            "  EPackage \"Metamodel\" {"                                                     +
		            "    eClassifiers: EClass \"JobItem\" {"                                         +
		            "                    eStructuralFeatures: EAttribute \"totalPrice\" {"           +
		            "                                           eType: EDataType \"String\""         +
		            "                                         },"                                    +
		            "                                         EAttribute \"unitPrice\" {"            +
		            "                                           eType: EDataType \"String\""         +
		            "                                         }"                                     +
		            "                  },"                                                           +
		            "                  EClass \"LabourItem\" {"                                      +
		            "                    eStructuralFeatures: EAttribute \"employee\" {"             +
		            "                                           eType: EDataType \"String\""         +
		            "                                         }"                                     +
		            "                    eSuperTypes: EClass \"JobItem\""                            +
		            "                  },"                                                           +
		            "                  EDataType \"String\" { "                                      +
		            "                    instanceTypeName: \"java.lang.String\""                     +
		            "                  }"                                                            +
		            "  }"                                                                            +
		            "}";
		
		slotModel = "SlotModel {"                 +
		            "  JobItem \"plan\" {"        +
		            "    totalPrice: \"200.00\"" +
		            "    unitPrice:  \"50.00\""  +
		            "  }"                         +
		            "  JobItem \"build\" {"       +
		            "    totalPrice: \"82.00\""  +
		            "    unitPrice:  \"41.00\""  +
		            "    employee:   \"John\""    +
		            "  }"                         +
		            "}";
		
		acceptanceTest("Debug.model");
		
		migratedModel.setVariable("build",         "ClassObject.all.selectOne(c|c.identifier='build')");
		migratedModel.setVariable("plan",          "ClassObject.all.selectOne(c|c.identifier='plan')");
	}
	
	@Test
	public void planIsJobItem() {
		migratedModel.assertEquals("JobItem", "plan.type");
	}
	
	@Test
	public void buildIsLabourItem() {
		migratedModel.assertEquals("LabourItem", "build.type");
	}	
}
