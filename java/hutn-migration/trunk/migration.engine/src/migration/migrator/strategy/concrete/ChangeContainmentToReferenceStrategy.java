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
package migration.migrator.strategy.concrete;

import java.util.LinkedList;
import java.util.List;

import migration.migrator.strategy.EverySlotMigrationStrategy;
import migration.migrator.strategy.MigrationException;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.ContainmentSlot;
import org.eclipse.epsilon.hutn.model.hutn.HutnFactory;
import org.eclipse.epsilon.hutn.model.hutn.ReferenceSlot;
import org.eclipse.epsilon.hutn.model.hutn.Slot;
import org.eclipse.epsilon.hutn.model.hutn.Spec;

public class ChangeContainmentToReferenceStrategy extends EverySlotMigrationStrategy<ContainmentSlot> {

	public ChangeContainmentToReferenceStrategy(Spec migratedModel, EPackage metamodel) {
		super(migratedModel, metamodel, ContainmentSlot.class);
	}

	private List<ClassObject> cloned = new LinkedList<ClassObject>(); 
	
	@Override
	protected void initialise () {
		cloned.clear();
	}
	

	@Override
	protected boolean isMigratable(ContainmentSlot slot) {
		return isNonContainmentReference(slot.getEStructuralFeature());
	}
	
	private boolean isNonContainmentReference(EStructuralFeature feature) {
		return feature instanceof EReference && !((EReference)feature).isContainment();
	}
	
	@Override
	protected void migrate(ContainmentSlot slot) throws MigrationException {
		final ReferenceSlot migratedSlot = HutnFactory.eINSTANCE.createReferenceSlot();
		
		migratedSlot.setFeature(slot.getFeature());
		migratedSlot.setOwner(slot.getOwner());
		
		for (ClassObject classObject : slot.getClassObjects()) {
			migratedSlot.getIdentifiers().add(classObject.getIdentifier());
		}
		
		moveContents(slot);
		delete(slot);
	}

	private void moveContents(ContainmentSlot slot) throws MigrationException {
		final ContainmentSlot newHome = findNewHomeFor(slot);

		final List<ClassObject> moving = new LinkedList<ClassObject>();
		
		for (ClassObject classObject : slot.getClassObjects()) {
			if (!newHome.getClassObjects().contains(classObject)) {
				moving.add(classObject);
			}
		}
		
		newHome.getClassObjects().addAll(moving);
	}

	private ContainmentSlot findNewHomeFor(ContainmentSlot slot) throws MigrationException {
		ClassObject host = slot.getOwner();
		
		while(true) {
			for (Slot candidate : host.getSlots()) {
				if (isSuitableHome(candidate, slot)) {
					System.out.println("Moving " + slot);
					System.out.println("To " + candidate);
					return (ContainmentSlot)candidate;
				}
			}
			
			if (containedInSlot(host)) {
				host = getParentClassObject(host); 
			
			} else {
				throw new MigrationException("No suitable home for " + slot);
			}
		}
	}

	private boolean isSuitableHome(Slot candidate, Slot slot) {
		return candidate instanceof ContainmentSlot &&
		       !candidate.equals(slot)              && 
		       canHouse(candidate, slot);
	}
	
	private boolean canHouse(Slot candidate, Slot slot) {
		return slot.typeCompatibleWith(candidate.getEStructuralFeature());
	}
	
	private boolean containedInSlot(ClassObject host) {
		return host.getContainer() instanceof ContainmentSlot;
	}
	
	private ClassObject getParentClassObject(ClassObject host) {
		assert(containedInSlot(host));
		return ((ContainmentSlot)host.getContainer()).getOwner();
	}	
}
