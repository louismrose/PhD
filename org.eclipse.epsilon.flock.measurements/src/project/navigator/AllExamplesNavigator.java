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

import project.Example;

public class AllExamplesNavigator extends ExamplesNavigator {

	public AllExamplesNavigator(String basePath) {
		super(basePath);
	}

	public AllExamplesNavigator(File base) {
		super(base);
	}

	protected boolean include(Example example) {
		return true;
	}
}
