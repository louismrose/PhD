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

import migration.models.Metamodel;
import migration.models.SlotModel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.hutn.model.hutn.ModelElement;
import org.eclipse.epsilon.hutn.model.hutn.Spec;

public abstract class MigrationStrategy<T extends ModelElement> {

	protected final SlotModel migratedModel;
	protected final Metamodel metamodel;
	
	private final List<EObject> orphans = new LinkedList<EObject>();
	
	public MigrationStrategy(Spec migratedModel, EPackage metamodel) {
		this.migratedModel = new SlotModel(migratedModel);
		this.metamodel     = new Metamodel(metamodel);
	}
	
	private List<T> getMigratableModelElements() {
		final List<T> migratable = new LinkedList<T>();
		
		getMigratableModelElements(migratable);
		
		return migratable;
	}
	
	protected abstract void getMigratableModelElements(List<T> migratable);
	protected abstract boolean isMigratable(T element);
	protected abstract void migrate(T element) throws MigrationException;
	
	public boolean isApplicable() {
		return !getMigratableModelElements().isEmpty();
	}
	
	public void execute() throws MigrationException {
		System.out.println("Executing " + getClass().getSimpleName());
		initialise();
		migrate();
		deleteOrphans();
	}
	
	// To be overriden
	protected void initialise() {}
	
	private void migrate() throws MigrationException {
		for (T migratable: getMigratableModelElements()) {
			System.out.println("\tMigrating " + migratable);
			migrate(migratable);
		}
	}
	
	private void deleteOrphans() {
		for (EObject orphan : orphans) {
			EcoreUtil.delete(orphan);
		}
	}
	
	protected void delete(EObject object) {
		orphans.add(object);
	}
}
