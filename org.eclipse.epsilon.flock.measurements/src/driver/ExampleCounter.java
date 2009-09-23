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
package driver;

import measure.MigrationStrategyMeasure;
import project.Example;

public class ExampleCounter {

	private final MigrationStrategyMeasure counter;
	
	public ExampleCounter(MigrationStrategyMeasure counter) {
		this.counter = counter;
	}
	
	public CounterResult count(Example example) throws Exception {
		final CounterResult result = new CounterResult();
		
		result.etlCount   = counter.measure(example.getEtlMigrationStrategy());
		result.flockCount = counter.measure(example.getFlockMigrationStrategy());
		result.copeCount  = counter.measure(example.getCopeMigrationStrategy());
		
		return result;
	}
	
	
	public static class CounterResult {
		public int etlCount, flockCount, copeCount;
	}
}
