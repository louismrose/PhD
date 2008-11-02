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
package migration.migrator;

import java.util.LinkedList;
import java.util.List;

import migration.migrator.strategy.MigrationException;
import migration.migrator.strategy.MigrationStrategy;
import migration.migrator.strategy.concrete.ChangeContainmentToReferenceStrategy;
import migration.migrator.strategy.concrete.ChangeReferenceToContainmentStrategy;
import migration.migrator.strategy.concrete.ExtractClassMigrationStrategy;
import migration.migrator.strategy.concrete.ExtractSubclassMigrationStrategy;
import migration.migrator.strategy.concrete.ReconcileClassMigrationStrategy;
import migration.migrator.strategy.concrete.ReconcileFeatureTypeMigrationStrategy;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.hutn.model.hutn.Spec;
import org.eclipse.epsilon.hutn.util.EmfUtil;

public class Migrator {
	
	private final Spec slotModel;
	
	public Migrator(Spec slotModel) {
		this.slotModel = slotModel;
	}
	
	public Spec suggestMigration(EPackage metamodel) {
		Spec migratedModel = EmfUtil.clone(slotModel);
		
		for (MigrationStrategy<?> strategy : getMigrationStrategies(migratedModel, metamodel)) {
			if (strategy.isApplicable()) {
				try {
					strategy.execute();
					
				} catch (MigrationException e) {
					System.out.println("\tEncountered exception: " + e.getMessage());
					// FIXME: This will reset model to before ALL strategies, not just the current
					// Rolling back to the model before the current strategy was executed might be better
					migratedModel = EmfUtil.clone(slotModel);
				}
			}
		}
		
		return migratedModel;
	}
	
	private List<MigrationStrategy<?>> getMigrationStrategies(Spec migratedModel, EPackage metamodel) {
		final List<MigrationStrategy<?>> strategies = new LinkedList<MigrationStrategy<?>>();
		
//		strategies.add(new ReconcileFeatureTypeMigrationStrategy(migratedModel, metamodel));
//		strategies.add(new ReconcileClassMigrationStrategy(migratedModel, metamodel));
		strategies.add(new ChangeReferenceToContainmentStrategy(migratedModel, metamodel));
		strategies.add(new ChangeContainmentToReferenceStrategy(migratedModel, metamodel));
		strategies.add(new ExtractClassMigrationStrategy(migratedModel, metamodel));
		strategies.add(new ExtractSubclassMigrationStrategy(migratedModel, metamodel));
		
		return strategies;
	}
}
