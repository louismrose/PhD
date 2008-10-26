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
package migration.migrator;

import static org.junit.Assert.*;

import java.util.List;

import migration.HutnModuleFacade;

import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.junit.BeforeClass;
import org.junit.Test;

public class AllClassObjects {

	private static List<ClassObject> classObjects;
	
	@BeforeClass
	public static void setup() {
		final String hutn = "ports {"                      +
                            "  Signature \"s\" {"          +
                            "    inPorts: Port \"p1\" {}"  +
                            "    outPorts: Port \"p2\" {}" +
                            "  }"                          +
                            "}";
		
		final Migrator migrator = new Migrator(new HutnModuleFacade().constructSpec(hutn));
		migrator.initialiseMigratedModel();
		classObjects = migrator.getClassObjects();
	}
	
	private static boolean hasClassObjectCalled(String s) {
		for (ClassObject co : classObjects) {
			if (s.equals(co.getIdentifier()))
				return true;
		}
		
		return false;
	}
	
	@Test
	public void correctNumberOfClassObjects() {
		assertEquals(3, classObjects.size());
	}
	
	@Test
	public void containsS() {
		assertTrue(hasClassObjectCalled("s"));
	}
	
	@Test
	public void containsP1() {
		assertTrue(hasClassObjectCalled("p1"));
	}
	
	@Test
	public void containsP2() {
		assertTrue(hasClassObjectCalled("p2"));
	}
}
