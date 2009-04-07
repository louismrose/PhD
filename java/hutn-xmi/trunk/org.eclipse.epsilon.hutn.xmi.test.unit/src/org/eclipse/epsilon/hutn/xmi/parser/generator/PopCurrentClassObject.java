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

import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.junit.Before;
import org.junit.Test;

public class PopCurrentClassObject {

	private SpecGenerator generator;
	
	@Before
	public void setup() {
		generator = new SpecGenerator();
		generator.initialise();
		generator.pushTopLevelClassObject("parent");
	}
	
	@Test
	public void nullAfterDoneWithLast() {
		generator.popCurrentClassObject();
		
		assertEquals(null, generator.getCurrentClassObject());
	}
	
	@Test
	public void parentAfterSimpleNesting() {
		final ClassObject parent = generator.getCurrentClassObject();
		
		generator.pushContainedClassObject("foo", "foos");
		generator.popCurrentClassObject();
		
		assertEquals(parent, generator.getCurrentClassObject());
	}
	
	@Test
	public void parentAfterTwoSimpleNestings() {
		final ClassObject parent = generator.getCurrentClassObject();
		
		generator.pushContainedClassObject("foo", "foos");
		generator.popCurrentClassObject();
		
		generator.pushContainedClassObject("bar", "bars");
		generator.popCurrentClassObject();
		
		assertEquals(parent, generator.getCurrentClassObject());
	}
	
	@Test
	public void secondLevelAfterThirdLevelNesting() {
		final ClassObject foo;
		
		generator.pushContainedClassObject("foo", "foos");
		foo = generator.getCurrentClassObject();
		
		generator.pushContainedClassObject("bar", "bars");
		generator.popCurrentClassObject();
		
		assertEquals(foo, generator.getCurrentClassObject());
	}
	
	@Test(expected=IllegalStateException.class)
	public void throwsExceptionWhenEmpty() {
		generator.popCurrentClassObject();
		generator.popCurrentClassObject();
	}
}
