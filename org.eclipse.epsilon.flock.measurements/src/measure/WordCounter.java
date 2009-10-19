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

import grammar.PatternCounter;
import project.MigrationStrategy;

public class WordCounter implements MigrationStrategyMeasure {

	private final String[] wordDelimiters             = new String[] {"\\s+", "\\."};
	private final PatternCounter wordDelimiterCounter = new PatternCounter(wordDelimiters);
	
	
	public int measure(MigrationStrategy strategy) {
		if (strategy.code.length() == 0)
			return 0;
		
		return wordDelimiterCounter.countMatchesIn(strategy.code.trim()) + 1;
	}

}
