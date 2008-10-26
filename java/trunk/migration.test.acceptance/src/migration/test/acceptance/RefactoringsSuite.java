/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id:$
 */
package migration.test.acceptance;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;


import migration.test.acceptance.refactorings.MergeReferences;
import migration.test.acceptance.refactorings.RenameClass;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({RenameClass.class,MergeReferences.class})
public class RefactoringsSuite {

	public static Test suite() {
		return new JUnit4TestAdapter(RefactoringsSuite.class);
	}
}
