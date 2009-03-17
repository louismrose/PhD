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

public class OnlyIncludeClassesWithCorrectSlots extends AcceptanceTest {
	
	@BeforeClass
	public static void setup() {
		metamodel = "Metamodel {"                                                        +
		            "  EPackage \"Metamodel\" {"                                         +
		            "    eClassifiers: EClass \"Port\"  {"                               +
		            "                    eStructuralFeatures: EAttribute \"id\" {}, "    +
		            "                                         EReference \"source\" {}," +
		            "                                         EReference \"target\" {}"  +
		            "                  },"                                               +
		            "                  EClass \"Component\" {}"                          +
		            "  }"                                                                +
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