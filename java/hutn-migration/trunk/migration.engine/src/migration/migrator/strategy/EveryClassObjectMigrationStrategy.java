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

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.Spec;

public abstract class EveryClassObjectMigrationStrategy extends MigrationStrategy<ClassObject> {

	public EveryClassObjectMigrationStrategy(Spec migratedModel, EPackage metamodel) {
		super(migratedModel, metamodel);
	}

	@Override
	protected void getMigratableModelElements(List<ClassObject> migratable) {
		for (ClassObject classObject : migratedModel.getAllClassObjects()) {
			if (isMigratable(classObject)) {
				migratable.add(classObject);
			}
		}
	}
}
