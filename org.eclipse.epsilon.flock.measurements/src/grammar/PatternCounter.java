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
package grammar;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class PatternCounter {

	private final Collection<Pattern> keywords;
	
	public PatternCounter(Pattern... keywords) {
		this.keywords = Arrays.asList(keywords);
	}

	public PatternCounter(String... keywords) {
		this.keywords = compilePatterns(keywords);
	}

	private static Collection<Pattern> compilePatterns(String... keywords) {
		final Collection<Pattern> patterns = new LinkedList<Pattern>();
		
		for (String keyword : keywords) {
			patterns.add(Pattern.compile(keyword));
		}
		
		return patterns;
	}
	
	
	public int countMatchesIn(String text) {
		int matches = 0;
		
		for (Pattern keyword : keywords) {
			matches += RegexUtil.getNumberOfMatchesIn(text, keyword);
		}

		return matches;
	}
}
