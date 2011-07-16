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
package suite;

import grammar.GrammarTestSuite;
import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;


import measure.example.MeasureExampleTestSuite;
import measure.strategy.MeasureStrategyTestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import driver.IntegrationTestSuite;

import project.ProjectTestSuite;
import reader.ReaderTestSuite;

@RunWith(Suite.class)
@SuiteClasses({GrammarTestSuite.class, ReaderTestSuite.class,
               ProjectTestSuite.class, MeasureExampleTestSuite.class, MeasureStrategyTestSuite.class,
               IntegrationTestSuite.class})
public class MeasurementsTestSuite {

	public static Test suite() {
		return new JUnit4TestAdapter(MeasurementsTestSuite.class);
	}
}
