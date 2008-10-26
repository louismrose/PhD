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
package trash;

import static org.junit.Assert.assertEquals;

import migration.test.acceptance.AcceptanceTest;

import org.junit.BeforeClass;
import org.junit.Test;

public class OnlyIncludeClassesWithCorrectlyTypedSlots extends AcceptanceTest {
	
	@BeforeClass
	public static void setup() {
		metamodel = "Metamodel {"                                                                                      +
		            "  EPackage \"Metamodel\" {"                                                                       +
		            "    eClassifiers: EClass \"Port\"  {"                                                             +
		            "                    eStructuralFeatures: EAttribute \"id\"     { eType: EDataType \"String\" },"  +
		            "                                         EReference \"source\" { eType: EClass \"Component\" },"  +
		            "                                         EReference \"target\" { eType: EClass \"Component\" }"   +
		            "                  },"                                                                             +
		            "                  EClass \"FirstWrongTypeOfPort\"  {"                                             +
		            "                    eStructuralFeatures: EAttribute \"id1\"     { name: \"id\""                   + // Wrong type
		            "                                                                  eType: EDataType \"Float\" },"  + 
		            "                                         EReference \"source1\" { name: \"source\""               +
		            "                                                                  eType: EClass \"Component\" }," +
		            "                                         EReference \"target1\" { name: \"target\""               +
		            "                                                                  eType: EClass \"Component\" }"  +
		            "                  },"                                                                             +
		            "                  EClass \"SecondWrongTypeOfPort\"  {"                                            +
		            "                    eStructuralFeatures: EAttribute \"id2\"     { name: \"id\""                   + 
		            "                                                                  eType: EDataType \"String\" }," + 
		            "                                         EReference \"source2\" { name: \"source\""               + // Wrong type
		            "                                                                  eType: EDataType \"String\" }," +
		            "                                         EReference \"target2\" { name: \"target\""               +
		            "                                                                  eType: EClass \"Component\" }"  +
		            "                  },"                                                                             +
		            "                  EClass \"ThirdWrongTypeOfPort\"  {"                                             +
		            "                    eStructuralFeatures: EAttribute \"id3\"     { name: \"id\""                   + 
		            "                                                                  eType: EDataType \"String\" }," + 
		            "                                         EReference \"source3\" { name: \"source\""               +
		            "                                                                  eType: EClass \"Component\" }," +
		            "                                         EReference \"target3\" { name: \"target\""               + // Wrong type
		            "                                                                  eType: EClass \"Port\" }"       +
		            "                  },"                                                                             +
		            "                  EClass \"Component\" {},"                                                       +
		            "                  EDataType \"String\" {"                                                         +
		            "                    instanceClassName: \"java.lang.String\""                                      +
		            "                  },"                                                                             +
		            "                  EDataType \"Float\" {"                                                          +
		            "                    instanceClassName: \"float\""                                                 +
		            "                  }"                                                                              +
		            "  }"                                                                                              +
		            "}";
		
		slotModel = "SlotModel {"                  +
                    "  Connector \"aConnector\" {" +
                    "    id: \"001\""              +
                    "    source: Component \"a\""  +
                    "    target: Component \"b\""  +
                    "  }"                          +
                    "  Component \"a\" {}"         +
                    "  Component \"b\" {}"         +
                    "}";
		
		acceptanceTest();
	}
	
	@Test
	public void correctNumberOfClassesSuggested() {
		assertEquals(1, classes.size());
	}
	
	@Test
	public void correctFirstClassSuggested() {
		assertEquals("Port", classes.get(0));
	}
}