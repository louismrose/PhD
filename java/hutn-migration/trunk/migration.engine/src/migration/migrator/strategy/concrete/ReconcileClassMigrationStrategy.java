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

import migration.migrator.strategy.EveryClassObjectMigrationStrategy;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.Spec;

public class ReconcileClassMigrationStrategy extends EveryClassObjectMigrationStrategy {

	public ReconcileClassMigrationStrategy(Spec migratedModel, EPackage metamodel) {
		super(migratedModel, metamodel);
	}
	
	@Override
	protected boolean isMigratable(ClassObject classObject) {
		final EClass eClass = classObject.getEClass();
		
		return eClass == null      ||
		       eClass.isAbstract() ||
		       !classObject.typeCompatibleWith(eClass);
	}
	
	@Override
	protected void migrate(ClassObject classObject) {	
		for (EClass eClass : metamodel.getAllEClasses()) {
			if (!eClass.isAbstract() && classObject.typeCompatibleWith(eClass)) {
				classObject.setType(eClass.getName());
			}
		}
	}
}