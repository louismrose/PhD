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

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExamplesNavigatorTest {

	private static final File BASE = createDirectory("test-examples");
	
	@Before
	public void setup() {
		if (!BASE.exists())
			BASE.mkdir();
	}
	
	@Test
	public void oneExample() {
		final File category = createDirectory(BASE, "GADIN");
		final File example  = createDirectory(category, "Convert Enum to Classes");
		
		assertEquals(Collections.singleton(new Example(example)), new ExamplesNavigator(BASE).getExamples());
	}
	
	@Test
	public void twoExamplesInSameCategory() {
		final File category = createDirectory(BASE, "GADIN");
		final File example1 = createDirectory(category, "Convert Enum to Classes");
		final File example2 = createDirectory(category, "Partition Containment");
		
		assertEquals(Arrays.asList(new Example(example1), new Example(example2)),
		             new ExamplesNavigator(BASE).getExamples());
	}
	
	@Test
	public void twoCategories() {
		final File category = createDirectory(BASE, "GADIN");
		final File example1 = createDirectory(category, "Convert Enum to Classes");
		final File example2 = createDirectory(category, "Partition Containment");
		
		final File category2 = createDirectory(BASE, "ProcessOriented");
		final File example3 = createDirectory(category2, "Split Connection Point");
		
		assertEquals(Arrays.asList(
		             	new Example(example1),
		             	new Example(example2),
		             	new Example(example3)
		             ),
		             new ExamplesNavigator(BASE).getExamples());
	}
	
	
	private static <T> void assertEquals(Iterable<T> expected, Iterable<T> actual) {
		final Iterator<T> expectedIterator = expected.iterator();
		final Iterator<T> actualIterator   = actual.iterator();
		
		while (expectedIterator.hasNext() || actualIterator.hasNext()) {
			org.junit.Assert.assertEquals(expectedIterator.next(), actualIterator.next());
		}
	}
	
	
	@After
	public void deleteDirectory() {
		if (BASE.exists())
			delete(BASE);
	}

	private static File createDirectory(File parent, String name) {
		final File directory = new File(parent, name);
		directory.mkdir();
		return directory;
	}
	
	private static File createDirectory(String path) {
		final File directory = new File(path);
		directory.mkdir();
		return directory;
	}
	
	private static void delete(File file) {
		if (!file.exists())
			return;
		
		if (file.isDirectory())
			deleteDirectory(file);
		else
			file.delete();
	}

	private static void deleteDirectory(File directory) {
		if (!directory.exists())
			return;
		
		if (directory.list().length > 0) {
			for (String child : directory.list()) {
				delete(new File(directory, child));
			}
		}
		
		directory.delete();
	}
}
