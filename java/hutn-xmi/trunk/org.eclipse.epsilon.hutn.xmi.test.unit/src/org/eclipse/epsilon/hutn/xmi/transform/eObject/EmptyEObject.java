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
 * $Id$
 */
package org.eclipse.epsilon.hutn.xmi.transform.eObject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.epsilon.hutn.xmi.test.unit.util.PersonFactory;
import org.eclipse.epsilon.hutn.xmi.transform.AbstractEObjectTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmptyEObject extends AbstractEObjectTest {

	@BeforeClass
	public static void setup() {
		eObjectTest(PersonFactory.createPerson());
	}
	
	@Test
	public void hasCorrectType() {
		assertEquals("Person", classObject.getType());
	}
	
	@Test
	public void hasAnIdentifier() {
		assertNotNull(classObject.getIdentifier());
	}
	
	@Test
	public void hasNoSlots() {
		assertTrue(classObject.getSlots().isEmpty());
	}
}
