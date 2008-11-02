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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.hutn.model.hutn.Slot;
import org.eclipse.epsilon.hutn.model.hutn.Spec;

public class ReconcileFeatureTypeMigrationStrategy extends EverySlotMigrationStrategy<Slot> {

	public ReconcileFeatureTypeMigrationStrategy(Spec migratedModel, EPackage metamodel) {
		super(migratedModel, metamodel, Slot.class);
	}

	@Override
	protected boolean isMigratable(Slot slot) {
		return slot.getEStructuralFeature() == null;
	}
	
	@Override
	protected void migrate(Slot slot) {
		final EClass owner = metamodel.findEClassByName(slot.getOwner().getType());
		
		for (EStructuralFeature feature : owner.getEStructuralFeatures()) {
			if (slot.typeCompatibleWith(feature)) {
				
				final Slot existingSlot = slot.getOwner().findSlot(feature.getName());
				
				if (existingSlot == null) {
					slot.setFeature(feature.getName());
				} else {
					if (feature.isMany()) {
						existingSlot.append(slot);
						delete(slot);
					}
				}
			}
		}
	}
}
