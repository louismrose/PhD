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
import project.navigator.AllExamplesNavigator;
import project.navigator.Ecore2EcoreExamplesNavigator;
import project.navigator.ExamplesNavigator;

public class MeasurementPrinter {

	private static final String BASE_PATH                    = "../Co-Evo Examples";
	private static final ExamplesNavigator DEFAULT_NAVIGATOR = new AllExamplesNavigator(BASE_PATH);
	
	private final ExampleMeasurer counter;
	private final ExamplesNavigator navigator;
	
	private MeasurementPrinter(MigrationStrategyMeasure measure, ExamplesNavigator navigator) {
		this(new ConstantMigrationStrategyMeasureFactory(measure), navigator);
	}

	private MeasurementPrinter(MigrationStrategyMeasureFactory measureFactory, ExamplesNavigator navigator) {
		this.counter   = new ExampleMeasurer(measureFactory);
		this.navigator = navigator;
	}

	public static MeasurementPrinter createSimpleModelOperationsCountPrinter() {
		return new MeasurementPrinter(new SimpleModelOperationsCounter(), DEFAULT_NAVIGATOR);
	}
	
	public static MeasurementPrinter createCreateDeleteAndChangeTypeModelOperationCountPrinter() {
		return new MeasurementPrinter(new CreateDeleteAndChangeTypeModelOperationCounter(), DEFAULT_NAVIGATOR);
	}
	
	public static MeasurementPrinter createMetamodelTerminologyCountPrinter() {
		return new MeasurementPrinter(new MetamodelTerminologyCounterFactory(), new Ecore2EcoreExamplesNavigator(BASE_PATH));
	}
	
	private static class ConstantMigrationStrategyMeasureFactory implements MigrationStrategyMeasureFactory {

		private final MigrationStrategyMeasure measure;
		
		public ConstantMigrationStrategyMeasureFactory(MigrationStrategyMeasure measure) {
			this.measure = measure;
		}
		
		public MigrationStrategyMeasure createMeasureFor(Example example) {
			return measure;
		}
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
