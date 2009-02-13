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

import java.util.LinkedList;
import java.util.List;

import migration.migrator.strategy.EverySlotMigrationStrategy;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.ContainmentSlot;
import org.eclipse.epsilon.hutn.model.hutn.HutnFactory;
import org.eclipse.epsilon.hutn.model.hutn.ReferenceSlot;
import org.eclipse.epsilon.hutn.model.hutn.Spec;

public class ChangeReferenceToContainmentStrategy extends EverySlotMigrationStrategy<ReferenceSlot> {

	public ChangeReferenceToContainmentStrategy(Spec migratedModel, EPackage metamodel) {
		super(migratedModel, metamodel, ReferenceSlot.class);
	}

	private List<ClassObject> cloned = new LinkedList<ClassObject>(); 
	
	@Override
	protected void initialise () {
		cloned.clear();
	}
	
	@Override
	protected boolean isMigratable(ReferenceSlot slot) {
		return isContainmentReference(slot.getEStructuralFeature());
	}
	
	private boolean isContainmentReference(EStructuralFeature feature) {
		return feature instanceof EReference && ((EReference)feature).isContainment();
	}
	
	@Override
	protected void migrate(ReferenceSlot slot) {
		final ContainmentSlot migratedSlot = HutnFactory.eINSTANCE.createContainmentSlot();
		
		migratedSlot.setFeature(slot.getFeature());
		migratedSlot.setOwner(slot.getOwner());
		
		for (ClassObject classObject : slot.getClassObjects()) {
			migratedSlot.getClassObjects().add(clone(classObject));
			
			if (isOriginal(classObject)) {
				delete(classObject);
			}
		}
		
		delete(slot);
	}

	private ClassObject clone(ClassObject original) {
		final ClassObject clone = EmfUtil.clone(original);
		cloned.add(clone);
		return clone;
	}
	
	private boolean isOriginal(ClassObject classObject) {
		return !cloned.contains(classObject);
	}
}
