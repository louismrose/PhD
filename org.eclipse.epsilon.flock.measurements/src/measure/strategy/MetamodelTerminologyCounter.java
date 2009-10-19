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

import java.util.Collection;

import measurement.MetamodelTerminologyMeasurement;

import grammar.PatternCounter;
import project.MigrationStrategy;

public class MetamodelTerminologyCounter implements MigrationStrategyMeasure {

	private final WordCounter        wordCounter        = new WordCounter();
	private final GrammarWordCounter grammarWordCounter = new GrammarWordCounter();
	
	private final PatternCounter     metamodelTerminologyCounter;
	
	
	public MetamodelTerminologyCounter(Collection<String> metamodelTerms) {
		this(metamodelTerms.toArray(new String[] {}));
	}
	
	public MetamodelTerminologyCounter(String... metamodelTerms) {
		metamodelTerminologyCounter = new PatternCounter(metamodelTerms);
	}

	public MetamodelTerminologyMeasurement measure(MigrationStrategy strategy) {
		return new MetamodelTerminologyMeasurement(wordCounter.measure(strategy),
		                                           metamodelTerminologyCounter.countMatchesIn(strategy.code),
		                                           grammarWordCounter.measure(strategy));
	}

}
