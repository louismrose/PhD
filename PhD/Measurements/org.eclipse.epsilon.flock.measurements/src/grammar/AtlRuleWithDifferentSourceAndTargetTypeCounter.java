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

public class AtlRuleWithDifferentSourceAndTargetTypeCounter {

	private static final String WS = "\\s+";
	private static final String WORD = "\\w*";
	private static final String OPTIONAL_MODEL_PREFIX = "(?:" + WORD + "!" + ")?"; // matches ModelName! and doesn't capture the text

	private static final String LEFT_PARENTHESIS               = "\\(";
	private static final String ANYTHING_BUT_RIGHT_PARENTHESIS = "[^\\)]";
	private static final String RIGHT_PARENTHESIS              = "\\)";
	private static final String PARENTHESISED_EXPRESSION       = LEFT_PARENTHESIS + ANYTHING_BUT_RIGHT_PARENTHESIS + "*" + RIGHT_PARENTHESIS;
	
	private static final String PARENTHESISED_EXPRESSION_WITH_NESTED = LEFT_PARENTHESIS + "(" + ANYTHING_BUT_RIGHT_PARENTHESIS + "|" + PARENTHESISED_EXPRESSION + ")*" + RIGHT_PARENTHESIS;
	
	private static final String OPTIONAL_GUARD = "(" + PARENTHESISED_EXPRESSION_WITH_NESTED + WS +")?";

	
	private static final String rulePattern = "rule" + WS + WORD + WS + "\\{" + WS +
	                                          "from" + WS + WORD + WS + ":" + WS + OPTIONAL_MODEL_PREFIX + WORD + WS + OPTIONAL_GUARD +
	                                          "to"    + WS + WORD + WS + ":" + WS + OPTIONAL_MODEL_PREFIX + WORD;

	private static final String ruleWithSameSourceAndTargetTypePattern = "rule" + WS + WORD + WS + "\\{" + WS +
	                                                                     "from" + WS + WORD + WS + ":" + WS + OPTIONAL_MODEL_PREFIX + "(" + WORD + ")" + WS + OPTIONAL_GUARD +
	                                                                     "to"   + WS + WORD + WS + ":" + WS + OPTIONAL_MODEL_PREFIX + "\\1";
	
	private final String transformation;
	
	public AtlRuleWithDifferentSourceAndTargetTypeCounter(String transformation) {
		this.transformation = transformation;
	}
	
	public int count() {
		return countMatchesInTransformation(rulePattern) - countMatchesInTransformation(ruleWithSameSourceAndTargetTypePattern);
	}
	
	private int countMatchesInTransformation(String regex) {
		return new PatternCounter(regex).countMatchesIn(transformation);
	}
}
