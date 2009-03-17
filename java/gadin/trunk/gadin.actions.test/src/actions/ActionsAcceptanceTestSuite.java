/**
 * *******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 * ******************************************************************************
 *
 * $Id: HutnAcceptanceTestSuite.java,v 1.3 2008/08/07 12:44:23 louis Exp $
 */
package actions;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import acceptance.ExtraWords;
import acceptance.MultiplePreconditionBlocks;
import acceptance.NegativeProposition;
import acceptance.Precondition;
import acceptance.TwoParameters;

@RunWith(Suite.class)
@SuiteClasses({TwoParameters.class, Precondition.class, ExtraWords.class,
               MultiplePreconditionBlocks.class, NegativeProposition.class})
public class ActionsAcceptanceTestSuite {

	public static Test suite() {
		return new JUnit4TestAdapter(ActionsAcceptanceTestSuite.class);
	}
}
