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

import static org.eclipse.epsilon.hutn.xmi.test.util.HutnTestUtil.slotTest;

import org.eclipse.epsilon.hutn.model.hutn.AttributeSlot;
import org.eclipse.epsilon.hutn.test.model.HutnTestWithFamiliesMetaModel;
import org.junit.Before;
import org.junit.Test;

public class AddAttributeValue extends HutnTestWithFamiliesMetaModel {

	private SpecGenerator generator;
	
	@Before
	public void setup() {
		generator = new SpecGenerator();
		generator.initialise("families");
		generator.generateTopLevelClassObject("f", "Family");
	}
	
	@Test
	public void addsSlotToTopLevelClassObject() {
		generator.addAttributeValue("averageAge", "32.4");
		
		slotTest(generator.getCurrentClassObject().getSlots().get(0), AttributeSlot.class, "averageAge", 32.4f);
	}
	
	@Test
	public void addsSlotToNestedClassObject() {
		generator.generateContainedClassObject("p", "members", "Person");
		generator.addAttributeValue("name", "John");
		
		slotTest(generator.getCurrentClassObject().getSlots().get(0), AttributeSlot.class, "name", "John");
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void unknownAttribute() {
		generator.addAttributeValue("foo", "bar");
	}
	
	@Test
	public void addSecondValueToSameAttribute() {
		generator.addAttributeValue("address", "10 Main Street");
		generator.addAttributeValue("address", "123 Heslington Road");
		
		slotTest(generator.getCurrentClassObject().getSlots().get(0), AttributeSlot.class, "address", "10 Main Street", "123 Heslington Road");
	}
}
