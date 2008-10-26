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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.HutnFactory;
import org.eclipse.epsilon.hutn.model.hutn.ModelElement;
import org.eclipse.epsilon.hutn.model.hutn.Spec;

public abstract class MigrationStrategy<T extends ModelElement> {

	private final Spec migratedModel;
	private final EPackage metamodel;
	
	private final List<EObject> orphans = new LinkedList<EObject>();
	
	public MigrationStrategy(Spec migratedModel, EPackage metamodel) {
		this.migratedModel = migratedModel;
		this.metamodel     = metamodel;
	}
	
	protected abstract List<T> getMigratableModelElements();
	protected abstract void migrate(T element);
	
	public boolean isApplicable() {
		return !getMigratableModelElements().isEmpty();
	}
	
	public void execute() {
		migrate();
		deleteOrphans();
	}
	
	private void migrate() {
		for (T migratable: getMigratableModelElements()) {
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
	
	
	// TODO: Refactor to method on Spec / Model Element??
	protected List<ClassObject> getClassObjects() {
		return EmfUtil.getAllModelElementsOfType(migratedModel, HutnFactory.eINSTANCE.createClassObject());
	}
	
	protected List<EClass> getAllEClasses() {
		return EmfUtil.getAllEClassesFromSameMetamodelAs(metamodel);
	}
	
	protected EClass findEClassByName(String name) {
		for (EClass eClass : getAllEClasses()) {
			if (name.equals(eClass.getName())) {
				return eClass;
			}
		}
		
		return null;
	}
}
