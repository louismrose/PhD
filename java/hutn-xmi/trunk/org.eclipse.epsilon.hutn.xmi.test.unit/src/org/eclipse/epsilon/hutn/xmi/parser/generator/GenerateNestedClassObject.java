/*******************************************************************************
 * Copyright (c) 2009 The University of York.
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
package org.eclipse.epsilon.hutn.xmi.parser.generator;

import static org.junit.Assert.assertEquals;
import static org.eclipse.epsilon.hutn.xmi.test.util.HutnTestUtil.slotTest;

import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.ContainmentSlot;
import org.eclipse.epsilon.hutn.model.hutn.PackageObject;
import org.junit.BeforeClass;
import org.junit.Test;

public class GenerateNestedClassObject {

	private static final SpecGenerator generator = new SpecGenerator();
	
	@BeforeClass
	public static void setup() {
		generator.initialise();
		generator.generateTopLevelClassObject("foo");
		generator.generateContainedClassObject("bar", "bars");
	}
	
	@Test
	public void packageShouldContainOneClassObject() {
		assertEquals(1, getFirstPackage().getClassObjects().size());
	}
	
	@Test
	public void firstClassObjectShouldHaveOneSlot() {
		assertEquals(1, getFirstClassObject().getSlots().size());
	}
	
	@Test
	public void barsSlot() {
		slotTest(getFirstClassObject().getSlots().get(0), ContainmentSlot.class, "bars", "bar");
	}
	
	@Test
	public void nestedClassObjectShouldBeTheNewClassObject() {
		assertEquals(getNestedClassObject(), generator.getCurrentClassObject());
	}
	
	@Test(expected=IllegalStateException.class)
	public void cannotCreateUnnestedContainedClassObject() {
		final SpecGenerator generator = new SpecGenerator();
		generator.initialise();
		generator.generateContainedClassObject("bar", "bars");
	}
	
	
	private static PackageObject getFirstPackage() {
		return generator.getSpec().getObjects().get(0);
	}
	
	private static ClassObject getFirstClassObject() {
		return getFirstPackage().getClassObjects().get(0);
	}
	
	private static ClassObject getNestedClassObject() {
		return (ClassObject)getFirstClassObject().getSlots().get(0).getValues().get(0);
	}
}
