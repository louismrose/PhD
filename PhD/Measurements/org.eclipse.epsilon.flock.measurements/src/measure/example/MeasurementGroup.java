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
/**
 * 
 */
package measure.example;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import measurement.Measurement;
import measurement.NullMeasurement;

public class MeasurementGroup {
	
	private final Map<String, Measurement> measurements = new HashMap<String, Measurement>();

	public void add(String name, Measurement measurement) {
		measurements.put(name, measurement);
	}

	public MeasurementGroup add(MeasurementGroup addend) {
		final MeasurementGroup result = new MeasurementGroup();
		
		for (String measurementName : this.measurements.keySet()) {
			final Measurement augendMeasurement = this.getMeasurementFor(measurementName);
			final Measurement addendMeasurement = addend.getMeasurementFor(measurementName);
			
			result.add(measurementName, addendMeasurement.add(augendMeasurement));
		}
		
		for (String measurementName : addend.measurements.keySet()) {
			if (!result.measurements.containsKey(measurementName)) { 
				result.add(measurementName, addend.getMeasurementFor(measurementName));
			}
		}
		
		return result;
	}
	
	public MeasurementGroup divideAllBy(int divisor) {
		final MeasurementGroup result = new MeasurementGroup();
		
		for (String measurementName : this.measurements.keySet()) {
			result.add(measurementName, getMeasurementFor(measurementName).divideBy(divisor));
		}
		
		return result;
	}

	public void printTo(PrintStream printer) {
		for (Entry<String, Measurement> measurement : measurements.entrySet()) {
			printer.print(measurement.getKey());
			printer.print(": ");
			measurement.getValue().printTo(printer);
			printer.print("  ");
		}
		
		printer.println();
	}

	public Measurement getMeasurementFor(String name) {
		return measurements.containsKey(name) ? measurements.get(name) : new NullMeasurement();
	}
}