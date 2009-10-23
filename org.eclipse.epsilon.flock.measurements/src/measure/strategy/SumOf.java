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
package measure.strategy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import project.MigrationStrategy;
import measurement.Count;
import measurement.Measurement;

public class SumOf implements MigrationStrategyMeasure {

	public final List<MigrationStrategyMeasure> measures = new LinkedList<MigrationStrategyMeasure>();
	
	public SumOf(MigrationStrategyMeasure... measures) {
		this.measures.addAll(Arrays.asList(measures));
	}
	
	public Measurement measure(MigrationStrategy strategy) {
		Count runningTotal = new Count(0);
		
		for (MigrationStrategyMeasure measure : measures) {
			runningTotal = (Count)runningTotal.add(measure.measure(strategy));
		}
		
		return runningTotal;
	}

}
