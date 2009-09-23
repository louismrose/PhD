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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader implements IMigrationStrategyReader {

	public static final String NEW_LINE = System.getProperty("line.separator");
	
	
	private final BufferedReader reader;
	
	public FileReader(File file) throws FileNotFoundException {
		reader = new BufferedReader(new java.io.FileReader(file));
	}
	
	public String readMigrationStrategy() throws IOException {
		final StringBuilder contents = new StringBuilder();
		
		while (linesLeft()) {
			contents.append(readLine());
			
			if (linesLeft())
				contents.append(NEW_LINE);
	
		}
		
		return contents.toString();
	}
	
	
	private String readLine() throws IOException {
		return reader.readLine();
	}
	
	private boolean linesLeft() throws IOException {
		return reader.ready();
	}

}
