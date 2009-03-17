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

import migration.migrator.strategy.MigrationException;
import migration.migrator.strategy.MigrationStrategy;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.hutn.model.hutn.Spec;

public class Migrator {
	
	private final Spec slotModel;
	
	public Migrator(Spec slotModel) {
		this.slotModel = slotModel;
	}
	
	public Spec suggestMigration(EPackage metamodel) {
		Spec migratedModel = EmfUtil.clone(slotModel);
		
		for (MigrationStrategy<?> strategy : new MigrationStrategyFactory(migratedModel, metamodel).getAllMigrationStrategies()) {
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
}
