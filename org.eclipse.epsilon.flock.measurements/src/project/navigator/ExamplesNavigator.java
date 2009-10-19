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
package project.navigator;

import java.io.File;
import java.util.Collection;
import java.util.LinkedList;

import project.Example;

public abstract class ExamplesNavigator {

	private final File base;
	
	public ExamplesNavigator(File base) {
		if (base == null)
			throw new IllegalArgumentException("base cannot be null");
		
		this.base = base;
	}
	
	public ExamplesNavigator(String basePath) {
		this(new File(basePath));
	}

	public Collection<Example> getExamples() {
		final Collection<Example> examples = new LinkedList<Example>();
		
		for (File category : subdirectoriesOf(base)) {
			for (File example : subdirectoriesOf(category)) {
				if (include(new Example(example)))
					examples.add(new Example(example));
			}
		}
		
		return examples;
	}
	
	protected abstract boolean include(Example example);
	
	
	private static Iterable<File> subdirectoriesOf(File directory) {
		final Collection<File> subdirectories = new LinkedList<File>();
		
		if (directory.list() == null)
			return subdirectories;
		
		for (String subdirectoryName : directory.list()) {
			if (!isHiddenFile(subdirectoryName)) {
				subdirectories.add(new File(directory, subdirectoryName));
			}
		}
		
		return subdirectories;
	}

	private static boolean isHiddenFile(String filename) {
		return filename.startsWith(".");
	}
}
