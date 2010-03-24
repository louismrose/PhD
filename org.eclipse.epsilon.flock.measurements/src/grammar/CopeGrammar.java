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


public class CopeGrammar implements Grammar {

	private static final CopeGrammar instance = new CopeGrammar();
	
	private CopeGrammar() {}
	
	public static CopeGrammar getInstance() {
		return instance;
	}
	
	private final PatternCounter assignmentMatcher = new PatternCounter("=", "\\.(un)?set", "\\.add", "\\.remove");
	
	private int numberOfAssignments;
	
	public int countSimpleModelOperationsIn(String text) {
		numberOfAssignments = assignmentMatcher.countMatchesIn(text);
		
		uncountDoubleAssignmentSymbols(text);
		uncountNotEqualSymbols(text);
		uncountAssignmentsToNewInstances(text);
		uncountAssignmentsToFunctions(text);

		return numberOfAssignments;
	}

	private void uncountDoubleAssignmentSymbols(String text) {
		uncount(2 * RegexUtil.getNumberOfMatchesIn(text, "=="));
	}
	
	private void uncountNotEqualSymbols(String text) {
		uncount(RegexUtil.getNumberOfMatchesIn(text, "!="));
	}
	
	private void uncountAssignmentsToNewInstances(String text) {
		uncount(RegexUtil.getNumberOfMatchesIn(text, "=" + RegexUtil.anything() + RegexUtil.escape(".newInstance()")));
	}
	
	private void uncountAssignmentsToFunctions(String text) {
		uncount(RegexUtil.getNumberOfMatchesIn(text, "= \\{"));
	}
	
	private void uncount(int numberOfAssignmentsToBeUncounted) {
		numberOfAssignments -= numberOfAssignmentsToBeUncounted;
	}

	public int countNewDeleteAndChangeTypeOperationsIn(String text) {
//		return new PatternCounter("\\.newInstance", "\\.delete", "\\.migrate").countMatchesIn(text);
		return new PatternCounter("\\.delete").countMatchesIn(text);
	}

	public Collection<String> getWords() {
		return Arrays.asList("set", "isSet", "unset", "get", "migrate", "delete",
		                     "{", "}", "->",
		                     "=", "<>", ">=", "<=", "<", ">", "==", "&&", "||",
		                     "+", "-", "*", "/",
		                     "equals", "and", "or", "not", "xor", "true", "false",
		                     "if", "else", "for", "in",
		                     "def", "newInstance",
		                     "return", "it",
		                     "allInstances",
		                     "get", "add", "remove", "addAll", "first", "last", "size",
		                     "findAll", "find", "collect", "contains", "every", "any");
	}
}
