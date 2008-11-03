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


import migration.test.acceptance.refactorings.fowler.ChangeContainmentToReference;
import migration.test.acceptance.refactorings.fowler.ChangeReferenceToContainment;
import migration.test.acceptance.refactorings.fowler.ExtractClass;
import migration.test.acceptance.refactorings.fowler.ExtractSubclass;
import migration.test.acceptance.refactorings.fowler.InlineClass;
import migration.test.acceptance.refactorings.fowler.MoveFeature;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ChangeReferenceToContainment.class, ChangeContainmentToReference.class,
               ExtractClass.class, ExtractSubclass.class, InlineClass.class,
               MoveFeature.class})
public class FowlerRefactoringsSuite {

	public static Test suite() {
		return new JUnit4TestAdapter(FowlerRefactoringsSuite.class);
	}
}
