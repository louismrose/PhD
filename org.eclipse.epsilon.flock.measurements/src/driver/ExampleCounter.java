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
import measure.MigrationStrategyMeasureFactory;
import project.Example;

public class ExampleCounter {

	private final MigrationStrategyMeasureFactory factory;
	
	public ExampleCounter(MigrationStrategyMeasure counter) {
		this(new ConstantMigrationStrategyMeasureFactory(counter));
	}
	
	public ExampleCounter(MigrationStrategyMeasureFactory factory) {
		this.factory = factory;
	}

	public CounterResult count(Example example) throws Exception {
		final MigrationStrategyMeasure counter = factory.createCounterFor(example);
		
		final CounterResult result = new CounterResult();
		
		result.etlCount         = counter.measure(example.getEtlMigrationStrategy());
		result.flockCount       = counter.measure(example.getFlockMigrationStrategy());
		result.copeCount        = counter.measure(example.getCopeMigrationStrategy());
		
		try {
			result.ecoreCount = counter.measure(example.getEcore2EcoreMigrationStrategy());
		} catch (UnsupportedOperationException ex) {
			System.err.println("Caught: " + ex.getLocalizedMessage());
			result.ecoreCount = 0;
		}
		
		return result;
	}
	
	
	public static class CounterResult {
		public int etlCount, flockCount, copeCount, ecoreCount;
	}
	
	
	private static class ConstantMigrationStrategyMeasureFactory implements MigrationStrategyMeasureFactory {

		private final MigrationStrategyMeasure measure;
		
		public ConstantMigrationStrategyMeasureFactory(MigrationStrategyMeasure measure) {
			this.measure = measure;
		}
		
		public MigrationStrategyMeasure createCounterFor(Example example) {
			return measure;
		}
	}
}
