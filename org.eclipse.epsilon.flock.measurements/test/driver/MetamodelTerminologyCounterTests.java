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
package driver;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import grammar.EpsilonGrammar;

import measure.GrammarWordCounter;
import measure.MetamodelTerminologyCounter;
import measure.WordCounter;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.junit.Test;

import project.MetamodelTerminologyGatherer;
import project.MigrationStrategy;

public class MetamodelTerminologyCounterTests {

	private static String FLOCK = "migrate Person to Employee {" + '\n' + 
	                              "  if (original.age >= 18) {"  + '\n' +
	                              "    migrated.hours := 40;"    + '\n' +
	                              "  }"                          + '\n' +
	                              "}";
	
	
	private static Collection<String> MM_TERMS = new MetamodelTerminologyGatherer(buildMetamodels()).getTerms();
	
	
	@Test
	public void migrationStrategyHasSeventeenWords() {
		assertEquals(17, new WordCounter().measure(new MigrationStrategy(FLOCK, EpsilonGrammar.getInstance())));
	}

	@Test
	public void migrationStrategyHasElevenFlockWords() {
		assertEquals(11, new GrammarWordCounter().measure(new MigrationStrategy(FLOCK, EpsilonGrammar.getInstance())));
	}
	
	@Test
	public void migrationStrategyHasFourMetamodelSpecificWords() {
		assertEquals(4, new MetamodelTerminologyCounter(MM_TERMS).measure(new MigrationStrategy(FLOCK, EpsilonGrammar.getInstance())));
	}
	
	
	private static Collection<EPackage> buildMetamodels() {
		final EPackage originalMetamodel = createEPackage(createEClass("Person",   createEAttribute("age")));
		final EPackage migratedMetamodel = createEPackage(createEClass("Employee", createEAttribute("hours")));
		
		return Arrays.asList(originalMetamodel, migratedMetamodel);
	}
	
	private static EPackage createEPackage(EClassifier... classifiers) {
		final EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.getEClassifiers().addAll(Arrays.asList(classifiers));
		return ePackage;
	}
	
	private static EClass createEClass(String name, EStructuralFeature... features) {
		final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName(name);
		eClass.getEStructuralFeatures().addAll(Arrays.asList(features));
		return eClass;
	}

	private static EAttribute createEAttribute(String name) {
		final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
		attribute.setName(name);
		return attribute;
	}

	private static EReference createEReference(String name) {
		final EReference reference = EcoreFactory.eINSTANCE.createEReference();
		reference.setName(name);
		return reference;
	}
}
