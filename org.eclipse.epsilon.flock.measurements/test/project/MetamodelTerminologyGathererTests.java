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
package project;

import static org.junit.Assert.assertThat;
import static org.junit.internal.matchers.IsCollectionContaining.hasItems;

import java.util.Arrays;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.junit.Test;

public class MetamodelTerminologyGathererTests {

	@Test
	public void termsIncludeClassNames() {
		final EPackage metamodel = EcoreFactory.eINSTANCE.createEPackage();
		metamodel.getEClassifiers().add(createEClass("Person"));
		metamodel.getEClassifiers().add(createEClass("Family"));
		
		assertThat(new MetamodelTerminologyGatherer(metamodel).getTerms(), hasItems("Person", "Family"));
	}
	
	@Test
	public void termsIncludeFeatureNames() {
		final EPackage metamodel = EcoreFactory.eINSTANCE.createEPackage();
		metamodel.getEClassifiers().add(createEClass("Person", createEReference("friends")));
		metamodel.getEClassifiers().add(createEClass("Family", createEAttribute("name"), createEAttribute("address")));
		
		assertThat(new MetamodelTerminologyGatherer(metamodel).getTerms(), hasItems("friends", "name", "address"));
		
	}

	private EClass createEClass(String name, EStructuralFeature... features) {
		final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName(name);
		eClass.getEStructuralFeatures().addAll(Arrays.asList(features));
		return eClass;
	}

	private EAttribute createEAttribute(String name) {
		final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
		attribute.setName(name);
		return attribute;
	}

	private EReference createEReference(String name) {
		final EReference reference = EcoreFactory.eINSTANCE.createEReference();
		reference.setName(name);
		return reference;
	}
}
