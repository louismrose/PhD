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

import measure.CreateDeleteAndChangeTypeModelOperationCounter;
import measure.MigrationStrategyMeasure;
import measure.SimpleModelOperationsCounter;
import project.Example;
import project.ExamplesNavigator;
import driver.ExampleCounter.CounterResult;

public class MeasurementPrinter {

	private static final ExamplesNavigator navigator = new ExamplesNavigator("../Co-Evo Examples");
	
	private final ExampleCounter counter;
	
	public MeasurementPrinter(MigrationStrategyMeasure measure) {
		this.counter = new ExampleCounter(measure);
	}

	public static MeasurementPrinter createSimpleModelOperationsCountPrinter() {
		return new MeasurementPrinter(new SimpleModelOperationsCounter());
	}
	
	public static MeasurementPrinter createCreateDeleteAndChangeTypeModelOperationCountPrinter() {
		return new MeasurementPrinter(new CreateDeleteAndChangeTypeModelOperationCounter());
	}
	
	
	private float etlCount, copeCount, flockCount;
	
	public void printMeasurement() throws Exception {
		for (Example example : navigator.getExamples()) {
			printExample(example);
			countExample(example);
		}
		
		printTotals();
	}

	
	private void printExample(Example example) throws Exception {
		System.out.println(example);
		
		final CounterResult result = counter.count(example);
		
		System.out.print("ETL: "     + result.etlCount  + "  ");
		System.out.print("COPE: "    + result.copeCount + "  ");
		System.out.println("Flock: " + result.flockCount);
		System.out.println();
	}
	
	private void countExample(Example example) throws Exception {
		final CounterResult result = counter.count(example);
		
		etlCount   += result.etlCount;
		copeCount  += result.copeCount;
		flockCount += result.flockCount;
	}
	
	private void printTotals() {
		System.out.println("Totals");
		System.out.print("ETL: "     + etlCount  + "  ");
		System.out.print("COPE: "    + copeCount + "  ");
		System.out.println("Flock: " + flockCount);
		
		System.out.println("Averages");
		System.out.print("ETL: "     + (etlCount   / navigator.getExamples().size()) + "  ");
		System.out.print("COPE: "    + (copeCount  / navigator.getExamples().size()) + "  ");
		System.out.println("Flock: " + (flockCount / navigator.getExamples().size()));	
	}
}