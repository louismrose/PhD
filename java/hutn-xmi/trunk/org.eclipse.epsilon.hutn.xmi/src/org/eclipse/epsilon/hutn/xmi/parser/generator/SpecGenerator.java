/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.hutn.xmi.parser.generator;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.ContainmentSlot;
import org.eclipse.epsilon.hutn.model.hutn.HutnFactory;
import org.eclipse.epsilon.hutn.model.hutn.NsUri;
import org.eclipse.epsilon.hutn.model.hutn.PackageObject;
import org.eclipse.epsilon.hutn.model.hutn.Spec;
import org.eclipse.epsilon.hutn.xmi.util.Stack;

public class SpecGenerator {

	private final Spec spec = HutnFactory.eINSTANCE.createSpec();
	private final Stack<ClassObject> stack = new Stack<ClassObject>();

	public Spec getSpec() {
		return spec;
	}

	public void initialise() {
		createPackageObject();
	}
	
	public void initialise(String nsUri) {
		final NsUri nsUriObject = HutnFactory.eINSTANCE.createNsUri();
		nsUriObject.setValue(nsUri);
		spec.getNsUris().add(nsUriObject);

		final PackageObject po = createPackageObject();
		
		if (EPackage.Registry.INSTANCE.getEPackage(nsUri) != null)		
			po.getMetamodel().add(EPackage.Registry.INSTANCE.getEPackage(nsUri));
	}

	public void pushTopLevelClassObject(String type) {
		if (getCurrentClassObject() != null)
			throw new IllegalStateException("Cannot create a top-level class object when getCurrentObject is non-null");
		
		final PackageObject pkg = spec.getObjects().get(0);
		pkg.getClassObjects().add(createClassObject(type));
	}

	public void pushContainedClassObject(String type, String containingFeature) {
		if (getCurrentClassObject() == null)
			throw new IllegalStateException("Cannot create a contained class object when getCurrentObject is null");
		
		final ContainmentSlot containingSlot = findOrCreateContainmentSlotInParent(containingFeature);
		containingSlot.getClassObjects().add(createClassObject(type));
	}
	
	public ClassObject getCurrentClassObject() {
		return stack.peek();
	}

	public void popCurrentClassObject() {
		stack.pop();
	}


	private PackageObject createPackageObject() {
		final PackageObject po = HutnFactory.eINSTANCE.createPackageObject();
		spec.getObjects().add(po);
		return po;
	}
	
	private ClassObject createClassObject(String type) {
		final ClassObject co = HutnFactory.eINSTANCE.createClassObject();
		co.setType(type);

		stack.push(co);

		return co;
	}

	private ContainmentSlot findOrCreateContainmentSlotInParent(String feature) {
		return findOrCreateContainmentSlot(stack.peek(), feature);
	}

	private ContainmentSlot findOrCreateContainmentSlot(ClassObject owner, String feature) {
		ContainmentSlot slot = (ContainmentSlot)owner.findSlot(feature);

		if (slot == null) {
			slot = HutnFactory.eINSTANCE.createContainmentSlot();
			slot.setFeature(feature);
			owner.getSlots().add(slot);

		}

		return slot;
	}
}
