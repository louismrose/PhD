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

import java.util.regex.Pattern;

import grammar.Grammar;
import grammar.PatternCounter;
import grammar.RegexUtil;
import project.MigrationStrategy;

public class GrammarWordCounter {

	public int measure(MigrationStrategy strategy) {
		return new PatternCounter(buildPattern(strategy.grammar)).countMatchesIn(strategy.code);
	}

	private Pattern buildPattern(Grammar grammar) {
		final StringBuilder anyWordOfGrammarRegex = new StringBuilder();
		
		for (String word : grammar.getWords()) {
			anyWordOfGrammarRegex.append(RegexUtil.escape(word));
			anyWordOfGrammarRegex.append("|");
		}
		
		if (anyWordOfGrammarRegex.length() > 0)
			anyWordOfGrammarRegex.deleteCharAt(anyWordOfGrammarRegex.length() - 1);
		
		return Pattern.compile(anyWordOfGrammarRegex.toString());
	}

}
