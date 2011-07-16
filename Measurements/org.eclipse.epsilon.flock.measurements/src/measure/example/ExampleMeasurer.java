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
package measure.example;


import measure.strategy.MigrationStrategyMeasure;
import measure.strategy.MigrationStrategyMeasureFactory;
import project.Example;
import project.MigrationStrategy;

public class ExampleMeasurer {

	private final MigrationStrategyMeasureFactory factory;
	
	public ExampleMeasurer(MigrationStrategyMeasureFactory factory) {
		this.factory = factory;
	}

	public MeasurementGroup count(Example example) throws Exception {
		final MigrationStrategyMeasure measure = factory.createMeasureFor(example);
		
		final MeasurementGroup result = new MeasurementGroup();
		
		for (MigrationStrategy migrationStrategy : example.getMigrationStrategies()) {
			result.add(migrationStrategy.name, measure.measure(migrationStrategy));
		}

		return result;
	}
}
