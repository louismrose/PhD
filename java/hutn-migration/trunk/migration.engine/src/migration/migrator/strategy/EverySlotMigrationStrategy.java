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
import org.eclipse.epsilon.hutn.model.hutn.Slot;
import org.eclipse.epsilon.hutn.model.hutn.Spec;

public abstract class EverySlotMigrationStrategy<T extends Slot> extends MigrationStrategy<T> {
	
	/*
	 * (object instanceof T) is not valid Java, as T is erased at compile-time.
	 * Instead, subclasses pass the Class for T via the constructor 
	 */
	private final Class<T> classOfT;
	
	public EverySlotMigrationStrategy(Spec migratedModel, EPackage metamodel, Class<T> classOfT) {
		super(migratedModel, metamodel);
		this.classOfT = classOfT;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void getMigratableModelElements(List<T> migratable) {
		for (ClassObject classObject : migratedModel.getAllClassObjects()) {
			for (Slot slot : classObject.getSlots()) {
				if (instanceOfT(slot) && isMigratable((T)slot)) {
					migratable.add((T)slot);
				}
			}
		}
	}
	
	private boolean instanceOfT(Object o) {
		return classOfT.isInstance(o);
	}
}
