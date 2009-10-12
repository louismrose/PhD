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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

public class EnumToClassesExampleTests {

	private static final Example example = new Example(new File("../Co-Evo Examples/GADIN/Enum to Classes"));
	
	@Test
	public void flockFile() {
		final File expected = new File("../Co-Evo Examples/GADIN/Enum to Classes/mig_lang/Enum to Classes.mig");
		final File actual = example.getFlockFile();
		
		assertEquals(expected, actual);
		assertTrue(actual.exists());
	}
	
	@Test
	public void etlFile() {
		final File expected = new File("../Co-Evo Examples/GADIN/Enum to Classes/etl/Enum to Classes.etl");
		final File actual = example.getEtlFile();
		
		assertEquals(expected, actual);
		assertTrue(actual.exists());
	}
	
	@Test
	public void copeFile() {
		final File expected = new File("../Co-Evo Examples/GADIN/Enum to Classes/cope/Before.history");
		final File actual = example.getCopeFile();
		
		assertEquals(expected, actual);
		assertTrue(actual.exists());
	}
	
	@Test
	public void ecore2ecoreFile() {
		assertNull(example.getEcore2EcoreFile());
	}
}