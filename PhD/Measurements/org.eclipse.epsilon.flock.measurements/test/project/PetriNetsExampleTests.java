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
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

public class PetriNetsExampleTests {

	private static final Example example = new Example(new File("../Co-Evo Examples/Literature/PetriNets"));
	
	@Test
	public void flockFile() throws FileNotFoundException {
		final File expected = new File("../Co-Evo Examples/Literature/PetriNets/mig_lang/PetriNets.mig");
		final File actual = example.getFlockFile();
		
		assertEquals(expected, actual);
		assertTrue(actual.exists());
	}
	
	@Test
	public void etlFile() throws FileNotFoundException {
		final File expected = new File("../Co-Evo Examples/Literature/PetriNets/etl/PetriNets.etl");
		final File actual = example.getEtlFile();
		
		assertEquals(expected, actual);
		assertTrue(actual.exists());
	}
	
	@Test
	public void copeFile() {
		final File expected = new File("../Co-Evo Examples/Literature/PetriNets/cope/Before.history");
		final File actual = example.getCopeFile();
		
		assertEquals(expected, actual);
		assertTrue(actual.exists());
	}
	
	@Test
	public void ecore2ecoreFile() {
		final File expected = new File("../Co-Evo Examples/Literature/PetriNets/ecore2ecore/resources/PetrinetsResourceHandler.java");
		final File actual = example.getEcore2EcoreFile();
		
		assertEquals(expected, actual);
		assertTrue(actual.exists());
	}
}