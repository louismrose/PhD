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

import measure.example.ExampleMeasurer;
import measure.example.MeasurementGroup;
import measure.strategy.CreateDeleteAndChangeTypeModelOperationCounter;
import measure.strategy.MetamodelTerminologyCounterFactory;
import measure.strategy.MigrationStrategyMeasure;
import measure.strategy.MigrationStrategyMeasureFactory;
import measure.strategy.SimpleModelOperationsCounter;
import project.Example;
import project.ExamplesNavigator;

public class MeasurementPrinter {

	private static final ExamplesNavigator navigator = new ExamplesNavigator("../Co-Evo Examples");
	
	private final ExampleMeasurer counter;
	
	public MeasurementPrinter(MigrationStrategyMeasure measure) {
		this.counter = new ExampleMeasurer(measure);
	}

	public MeasurementPrinter(MigrationStrategyMeasureFactory measureFactory) {
		this.counter = new ExampleMeasurer(measureFactory);
	}

	public static MeasurementPrinter createSimpleModelOperationsCountPrinter() {
		return new MeasurementPrinter(new SimpleModelOperationsCounter());
	}
	
	public static MeasurementPrinter createCreateDeleteAndChangeTypeModelOperationCountPrinter() {
		return new MeasurementPrinter(new CreateDeleteAndChangeTypeModelOperationCounter());
	}
	
	public static MeasurementPrinter createMetamodelTerminologyCountPrinter() {
		return new MeasurementPrinter(new MetamodelTerminologyCounterFactory());
	}
	
	
	private MeasurementGroup total = new MeasurementGroup();
	
	public void printMeasurement() throws Exception {
		for (Example example : navigator.getExamples()) {
			printExample(example);
			countExample(example);
		}
		
		printTotals();
	}

	
	private void printExample(Example example) throws Exception {
		System.out.println(example);
		
		counter.count(example).printTo(System.out);

		System.out.println();
	}
	
	private void countExample(Example example) throws Exception {
		final MeasurementGroup result = counter.count(example);
		
		total = total.add(result);
	}
	
	private void printTotals() {
		System.out.println("Totals");
		total.printTo(System.out);
		System.out.println();
		
		System.out.println("Averages");
		total.divideAllBy(navigator.getExamples().size()).printTo(System.out);
	}
}
