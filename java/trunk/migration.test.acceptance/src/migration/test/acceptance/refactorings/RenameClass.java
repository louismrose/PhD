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
package migration.test.acceptance.refactorings;

import migration.test.acceptance.AcceptanceTest;

import org.junit.BeforeClass;
import org.junit.Test;

public class RenameClass extends AcceptanceTest {
	
	@BeforeClass
	public static void setup() {
		metamodel = "Metamodel {"                          +
		            "  EPackage \"Metamodel\" {"           +
		            "    eClassifiers: EClass \"Port\" {}" +
		            "  }"                                  +
		            "}";
		
		slotModel = "SlotModel {"                   +
		            "  Connector \"aConnector\" {}" +
		            "}";
		
		acceptanceTest();
		
		migratedModel.setVariable("aConnector", "ClassObject.all.selectOne(c|c.identifier='aConnector')");
	}
	
	@Test
	public void aConnectorHasRightType() {
		migratedModel.assertEquals("Port", "aConnector.type");
	}
}