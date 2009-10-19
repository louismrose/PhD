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
package measure;

import java.util.Collection;

import grammar.PatternCounter;
import project.MigrationStrategy;

public class MetamodelTerminologyCounter implements MigrationStrategyMeasure {

	private final PatternCounter counter;
	
	public MetamodelTerminologyCounter(Collection<String> metamodelTerms) {
		this(metamodelTerms.toArray(new String[] {}));
	}
	
	public MetamodelTerminologyCounter(String... metamodelTerms) {
		counter = new PatternCounter(metamodelTerms);
	}

	public int measure(MigrationStrategy strategy) {
		return counter.countMatchesIn(strategy.code);
	}

}
