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
package org.eclipse.epsilon.hutn.xmi.transform.value.reference;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.epsilon.hutn.model.hutn.ReferenceSlot;
import org.eclipse.epsilon.hutn.test.model.families.FamiliesPackage;
import org.eclipse.epsilon.hutn.test.model.families.Pet;
import org.eclipse.epsilon.hutn.xmi.test.unit.util.PetFactory;
import org.eclipse.epsilon.hutn.xmi.transform.AbstractReferenceValueTest;
import org.eclipse.epsilon.hutn.xmi.transform.util.ClassObjectCache;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReferenceWithSingleValue extends AbstractReferenceValueTest {
	
	private static final ClassObjectCache cache      = new ClassObjectCache();
	private static final Pet              pet        = PetFactory.createPet();
	private static final String           identifier = cache.getFor(pet).getIdentifier();
	
	@BeforeClass
	public static void setup() {
		referenceValueTest(pet, FamiliesPackage.eINSTANCE.getFamily_Pets(), cache);
	}
	
	@Test
	public void slotHasCorrectFeatureName() {
		assertEquals("pets", slot.getFeature());
	}
	
	@Test
	public void slotIsCorrectType() {
		assertTrue(slot instanceof ReferenceSlot);
	}
	
	@Test
	public void slotHasOneValue() {
		assertEquals(1, slot.getValues().size());
	}
	
	@Test
	public void slotHasCorrectValue() {
		assertEquals(identifier, slot.getValues().get(0));
	}
}
