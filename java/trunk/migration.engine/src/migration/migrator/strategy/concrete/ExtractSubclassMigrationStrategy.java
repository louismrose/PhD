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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.Spec;

import migration.migrator.strategy.EveryClassObjectMigrationStrategy;
import migration.migrator.strategy.MigrationException;

public class ExtractSubclassMigrationStrategy extends EveryClassObjectMigrationStrategy {

	public ExtractSubclassMigrationStrategy(Spec migratedModel, EPackage metamodel) {
		super(migratedModel, metamodel);
	}

	@Override
	protected boolean isMigratable(ClassObject element) {
		return element.hasEClass() &&
		       !element.typeCompatibleWith(element.getEClass()) &&
		       hasTypeCompatibleSubclass(element);
	}

	@Override
	protected void migrate(ClassObject element) throws MigrationException {
		element.setType(getTypeCompatibleSubclass(element).getName());
	}

	

	private boolean hasTypeCompatibleSubclass(ClassObject element) {
		return getTypeCompatibleSubclass(element) != null;
	}
	
	private EClass getTypeCompatibleSubclass(ClassObject element) {
		for (EClass subclass : metamodel.getEAllSubTypes(element.getEClass())) {
			if (element.typeCompatibleWith(subclass)) {
				return subclass;
			}
		}
		
		return null;
	}
}
