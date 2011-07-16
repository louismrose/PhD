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
package reader;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.After;
import org.junit.Test;

public class FileReaderTests {

	private static final File testFile = new File("test.txt");
	
	@Test
	public void readSingleLine() throws IOException {
		writeFile(testFile, "Test data.");
		
		assertEquals("Test data.", new FileReader(testFile).readMigrationStrategy());
	}
	
	@Test
	public void readSeveralLines() throws IOException {
		writeFile(testFile, "Test data.\n" + "Second line.");
		
		assertEquals("Test data." + System.getProperty("line.separator") + "Second line.", new FileReader(testFile).readMigrationStrategy());
	}
	
	@After
	public void deleteTestFile() {
		if (testFile.exists())
			testFile.delete();
	}
	
	
	private static void writeFile(File file, String contents) throws IOException {
		final FileWriter writer = new FileWriter(file);
		
		writer.write(contents);
		writer.close();
	}
}
