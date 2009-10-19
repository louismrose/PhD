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
import grammar.EpsilonGrammar;

import java.util.Arrays;
import java.util.Collection;

import measure.strategy.MetamodelTerminologyCounter;
import measurement.MetamodelTerminologyMeasurement;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
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
	
	private static final MigrationStrategy strategy = new MigrationStrategy("Flock", FLOCK, EpsilonGrammar.getInstance());
	
	
	private static final MetamodelTerminologyMeasurement measurement = new MetamodelTerminologyCounter(MM_TERMS).measure(strategy);
	
	
	@Test
	public void migrationStrategyHasCorrectMeasurement() {
		assertEquals(measurement, new MetamodelTerminologyMeasurement(17, 4, 11));
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
}
