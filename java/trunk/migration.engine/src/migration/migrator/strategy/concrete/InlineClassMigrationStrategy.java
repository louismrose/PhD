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

import migration.migrator.strategy.EverySlotMigrationStrategy;
import migration.migrator.strategy.MigrationException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.hutn.model.hutn.AssociativeSlot;
import org.eclipse.epsilon.hutn.model.hutn.Slot;
import org.eclipse.epsilon.hutn.model.hutn.Spec;

public class InlineClassMigrationStrategy extends EverySlotMigrationStrategy<AssociativeSlot> {

	public InlineClassMigrationStrategy(Spec migratedModel, EPackage metamodel) {
		super(migratedModel, metamodel, AssociativeSlot.class);
	}

	@Override
	protected boolean isMigratable(AssociativeSlot slot) {
		return !slot.hasEStructuralFeature() &&
		       slot.getClassObjects().size() == 1 &&
		       slotCanBeInlined(slot);
	}
	
	@Override
	protected void migrate(AssociativeSlot slot) throws MigrationException {
		final EList<Slot> movingSlots = slot.getClassObjects().get(0).getSlots();
		
		// Using a while loop to avoid concurrent modification problems
		while (!movingSlots.isEmpty()) {
			movingSlots.get(0).setOwner(slot.getOwner());
		}
		
		delete(slot);
	}
	
	private boolean slotCanBeInlined(AssociativeSlot slot) {
		if (!slot.getOwner().hasEClass()) return false;
		
		assert(slot.getClassObjects().size() == 1);
		
		return slot.getClassObjects().get(0).typeCompatibleWith(slot.getOwner().getEClass());
	}
}
