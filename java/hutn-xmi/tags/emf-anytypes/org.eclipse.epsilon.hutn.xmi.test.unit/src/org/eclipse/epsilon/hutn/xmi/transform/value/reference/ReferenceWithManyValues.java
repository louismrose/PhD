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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.epsilon.hutn.model.hutn.ReferenceSlot;
import org.eclipse.epsilon.hutn.test.model.families.FamiliesFactory;
import org.eclipse.epsilon.hutn.test.model.families.FamiliesPackage;
import org.eclipse.epsilon.hutn.test.model.families.Pet;
import org.eclipse.epsilon.hutn.xmi.transform.AbstractReferenceValueTest;
import org.eclipse.epsilon.hutn.xmi.transform.util.ClassObjectCache;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReferenceWithManyValues extends AbstractReferenceValueTest {
	
	private static final ClassObjectCache cache       = new ClassObjectCache();
	private static final EList<Pet>       pets        = new BasicEList<Pet>();
	private static final List<String>     identifiers = new LinkedList<String>();
	
	private static void createPet() {
		final Pet pet = FamiliesFactory.eINSTANCE.createPet();
		
		pets.add(pet);
		identifiers.add(cache.getFor(pet).getIdentifier());
	}
	
	@BeforeClass
	public static void setup() {
		createPet(); createPet();
		
		referenceValueTest(pets, FamiliesPackage.eINSTANCE.getFamily_Pets(), cache);
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
	public void slotHasCorrectValues() {
		assertEquals(identifiers, slot.getValues());
	}
}
