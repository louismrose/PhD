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

public class TwoPossibilities extends AcceptanceTest {
	
	@BeforeClass
	public static void setup() {
		metamodel = "Metamodel {"                              +
		            "  EPackage \"Metamodel\" {"               +
		            "    eClassifiers: EClass \"InPort\"  {}," +
		            "                  EClass \"OutPort\" {}"  +
		            "  }"                                      +
		            "}";
		
		slotModel = "SlotModel {"         +
		            "  Port \"aPort\" {}" +
		            "}";
		
		acceptanceTest();
	}
	

	@Test
	public void correctNumberOfClassesSuggested() {
		assertEquals(2, classes.size());
	}
	
	@Test
	public void correctFirstClassSuggested() {
		assertEquals("InPort", classes.get(0));
	}
	
	@Test
	public void correctSecondClassSuggested() {
		assertEquals("OutPort", classes.get(1));
	}
}