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
package migration.migrator.strategy;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.Slot;
import org.eclipse.epsilon.hutn.model.hutn.Spec;

public class ReconcileFeatureTypeMigrationStrategy extends MigrationStrategy<Slot> {

	public ReconcileFeatureTypeMigrationStrategy(Spec migratedModel, EPackage metamodel) {
		super(migratedModel, metamodel);
	}

	protected List<Slot> getMigratableModelElements() {
		final List<Slot> migrateable = new LinkedList<Slot>();
		
		for (ClassObject classObject : getClassObjects()) {
			for (Slot slot : classObject.getSlots()) {
				if (findEClassByName(slot.getFeature()) == null) {
					migrateable.add(slot);
				}
			}
		}
		
		return migrateable;
	}
	
	protected void migrate(Slot slot) {
		final EClass owner = findEClassByName(slot.getOwner().getType());
		
		for (EStructuralFeature feature : owner.getEStructuralFeatures()) {
			if (slot.typeCompatibleWith(feature)) {
				
				final Slot existingSlot = slot.getOwner().findSlot(feature.getName());
				
				if (existingSlot == null) {
					slot.setFeature(feature.getName());
				} else {
					existingSlot.append(slot);
					delete(slot);
				}
			}
		}
	}
}
