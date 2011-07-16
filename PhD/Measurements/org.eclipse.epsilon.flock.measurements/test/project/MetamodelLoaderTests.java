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

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.junit.Test;

public class MetamodelLoaderTests {

	private final Collection<EPackage> packages = new MetamodelLoader(new File("test/project/Sample.ecore")).load();
	
	
	@Test
	public void onePackageIsLoaded() {	
		assertEquals(1, packages.size());
	}
	
	@Test
	public void oneClassIsLoaded() {	
		assertEquals(1, getFirstPackage().getEClassifiers().size());
	}
	
	@Test
	public void classHasCorrectName() {	
		assertEquals("Foo", getFirstClass().getName());
	}
	
	@Test
	public void oneFeatureIsLoaded() {	
		assertEquals(1, getFirstClass().getEStructuralFeatures().size());
	}
	
	@Test
	public void featureHasCorrectName() {	
		assertEquals("bar", getFirstFeature().getName());
	}
	
	
	private EPackage getFirstPackage() {
		return packages.iterator().next();
	}
	
	private EClass getFirstClass() {
		return (EClass)getFirstPackage().getEClassifiers().get(0);
	}
	
	private EStructuralFeature getFirstFeature() {
		return getFirstClass().getEStructuralFeatures().get(0);
	}
}
