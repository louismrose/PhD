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

import migration.migrator.strategy.MigrationStrategy;
import migration.migrator.strategy.concrete.ChangeContainmentToReferenceStrategy;
import migration.migrator.strategy.concrete.ChangeReferenceToContainmentStrategy;
import migration.migrator.strategy.concrete.ExtractClassMigrationStrategy;
import migration.migrator.strategy.concrete.ExtractSubclassMigrationStrategy;
import migration.migrator.strategy.concrete.InlineClassMigrationStrategy;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.hutn.model.hutn.Spec;

public class MigrationStrategyFactory {

	private final Spec migratedModel;
	private final EPackage metamodel;
	
	public MigrationStrategyFactory(Spec migratedModel, EPackage metamodel) {
		this.migratedModel = migratedModel;
		this.metamodel     = metamodel;
	}
	
	public List<MigrationStrategy<?>> getAllMigrationStrategies() {
		final List<MigrationStrategy<?>> strategies = new LinkedList<MigrationStrategy<?>>();
		
//		strategies.add(new ReconcileFeatureTypeMigrationStrategy(migratedModel, metamodel));
//		strategies.add(new ReconcileClassMigrationStrategy(migratedModel, metamodel));
		strategies.add(new ChangeReferenceToContainmentStrategy(migratedModel, metamodel));
		strategies.add(new ChangeContainmentToReferenceStrategy(migratedModel, metamodel));
		strategies.add(new ExtractClassMigrationStrategy(migratedModel, metamodel));
		strategies.add(new ExtractSubclassMigrationStrategy(migratedModel, metamodel));
		strategies.add(new InlineClassMigrationStrategy(migratedModel, metamodel));
		
		return strategies;
	}
}
