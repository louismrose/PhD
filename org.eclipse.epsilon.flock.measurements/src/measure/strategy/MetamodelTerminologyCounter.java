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
import java.util.Collection;
import java.util.LinkedList;

import measurement.MetamodelTerminologyMeasurement;

import project.MigrationStrategy;

public class MetamodelTerminologyCounter implements MigrationStrategyMeasure {

	private final Collection<String> metamodelTerms  = new LinkedList<String>();
	
	
	public MetamodelTerminologyCounter(Collection<String> metamodelTerms) {
		this.metamodelTerms.addAll(metamodelTerms);
	}
	
	public MetamodelTerminologyCounter(String... metamodelTerms) {
		this(Arrays.asList(metamodelTerms));
	}

	public MetamodelTerminologyMeasurement measure(MigrationStrategy strategy) {
		final WordCounter counter = new WordCounter(strategy);
		
		return new MetamodelTerminologyMeasurement(counter.countWords(),
		                                           counter.countOccurencesOf(metamodelTerms),
		                                           counter.countOccurencesOf(strategy.grammar.getWords()));
	}

}
