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

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.ContainmentSlot;
import org.eclipse.epsilon.hutn.model.hutn.HutnFactory;
import org.eclipse.epsilon.hutn.model.hutn.ReferenceSlot;
import org.eclipse.epsilon.hutn.model.hutn.Slot;
import org.eclipse.epsilon.hutn.model.hutn.Spec;
import org.eclipse.epsilon.hutn.util.EmfUtil;

public class ChangeReferenceToContainmentStrategy extends MigrationStrategy<ReferenceSlot> {

	public ChangeReferenceToContainmentStrategy(Spec migratedModel, EPackage metamodel) {
		super(migratedModel, metamodel);
	}

	private List<ClassObject> cloned = new LinkedList<ClassObject>(); 
	
	@Override
	protected void initialise () {
		cloned.clear();
	}
	
	protected List<ReferenceSlot> getMigratableModelElements() {
		final List<ReferenceSlot> migrateable = new LinkedList<ReferenceSlot>();
		
		for (ClassObject classObject : getClassObjects()) {
			for (Slot slot : classObject.getSlots()) {
				if (slot instanceof ReferenceSlot) {
					if (isContainmentReference(slot.getEStructuralFeature(getAllEClasses()))) {
						migrateable.add((ReferenceSlot)slot);
					}
				}
			}
		}
		
		return migrateable;
	}
	
	private boolean isContainmentReference(EStructuralFeature feature) {
		return feature instanceof EReference && ((EReference)feature).isContainment();
	}
	
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
