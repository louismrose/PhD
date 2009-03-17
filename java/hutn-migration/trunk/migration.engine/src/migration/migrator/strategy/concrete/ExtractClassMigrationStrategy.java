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

import java.util.Collections;
import java.util.List;

import migration.migrator.strategy.EverySlotMigrationStrategy;
import migration.migrator.strategy.MigrationException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.hutn.model.hutn.AssociativeSlot;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.HutnFactory;
import org.eclipse.epsilon.hutn.model.hutn.Slot;
import org.eclipse.epsilon.hutn.model.hutn.Spec;

public class ExtractClassMigrationStrategy extends EverySlotMigrationStrategy<Slot> {

	public ExtractClassMigrationStrategy(Spec migratedModel, EPackage metamodel) {
		super(migratedModel, metamodel, Slot.class);
	}

	@Override
	protected boolean isMigratable(Slot slot) {
		return !slot.hasEStructuralFeature() && hasExtractedClass(slot);
	}
	
	private boolean hasExtractedClass(Slot slot) {
		return findReferenceToExtractedClass(slot) != null;
	}
	
	private EReference findReferenceToExtractedClass(Slot slot) {
		for (EReference reference : getReferencesDefinedInMetamodelFor(slot.getOwner())) {
			if (reference.getEType() instanceof EClass) {
				if (classSupports((EClass)reference.getEType(), slot)) {
					return reference;
				}
			}
		}
		
		return null;
	}
	
	private boolean classSupports(EClass eClass, Slot slot) {
		for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
			if (slot.compatibleWith(feature)) {
				return true;
			}
		}
		
		return false;
	}

	private List<EReference> getReferencesDefinedInMetamodelFor(ClassObject classObject) {
		final EClass eClass = classObject.getEClass();
		
		if (eClass == null)
			return Collections.emptyList();
		
		return eClass.getEAllReferences();
	}
	

	@Override
	protected void migrate(Slot slot) throws MigrationException {
		final EReference      reference       = findReferenceToExtractedClass(slot);
		final AssociativeSlot associativeSlot = findOrCreateAssociativeSlotForExtractedClass(reference, slot.getOwner());
		final ClassObject     newHome         = findOrCreateClassObjectIn(associativeSlot, reference.getEType().getName(), slot.getFeature());
		
		associativeSlot.addClassObject(newHome);
		
		newHome.getSlots().add(slot);
		
	}

	private AssociativeSlot findOrCreateAssociativeSlotForExtractedClass(EReference reference, ClassObject owner) {
		final Slot existingSlot = owner.findSlot(reference.getName());
		
		if (existingSlot instanceof AssociativeSlot)
			return (AssociativeSlot)existingSlot;
		
		else if (existingSlot == null) {
			return createAssociativeSlot(reference, owner);
		}
		
		throw new IllegalArgumentException("Cannot store objects of type " + owner.getType() + " in " + existingSlot);
	}

	private AssociativeSlot createAssociativeSlot(EReference reference, ClassObject owner) {
		final AssociativeSlot newSlot;
		
		if (reference.isContainment()) {
			newSlot = HutnFactory.eINSTANCE.createContainmentSlot();
		} else {
			newSlot = HutnFactory.eINSTANCE.createReferenceSlot();
		}
		
		newSlot.setFeature(reference.getName());
		newSlot.setOwner(owner);
		
		return newSlot;
	}
	
	private ClassObject findOrCreateClassObjectIn(AssociativeSlot slot, String type, String featureForWhichThereIsNoSlot) {
		for (ClassObject classObject : slot.getClassObjects()) {
			if (classObject.findSlot(slot.getFeature()) == null) {
				return classObject;
			}
		}
		
		return createClassObject(type);
	}
	
	private ClassObject createClassObject(String type) {
		final ClassObject result = HutnFactory.eINSTANCE.createClassObject();
		result.setType(type);
		migratedModel.giveIdentifierTo(result);
		return result;
	}

}
