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



public class EpsilonGrammar implements Grammar {

	private static final EpsilonGrammar instance = new EpsilonGrammar();
	
	private EpsilonGrammar() {}
	
	public static EpsilonGrammar getInstance() {
		return instance;
	}
	
	
	private final PatternCounter grammar = new PatternCounter(":=", "\\.add");

	private int numberOfAssignments;
	
	public int countSimpleModelOperationsIn(String text) {
		numberOfAssignments = grammar.countMatchesIn(text);
		
		uncountAssignmentsToNewInstances(text);
		
		return numberOfAssignments;
	}
	
	private void uncountAssignmentsToNewInstances(String text) {
		uncount(RegexUtil.getNumberOfMatchesIn(text, "= new "));
	}
	
	private void uncount(int numberOfAssignmentsToBeUncounted) {
		numberOfAssignments -= numberOfAssignmentsToBeUncounted;
	}

	public int countNewDeleteAndChangeTypeOperationsIn(String text) {
		return new PatternCounter("new ", "delete", "migrate \\w* to \\w*").countMatchesIn(text) +
		       new RuleWithDifferentSourceAndTargetTypeCounter(text).count();
	}

	public Collection<String> getWords() {
		return Arrays.asList("migrate", "to", "original", "migrated", "delete", "equivalent()", "equivalents()",
		                     "{", "}",
		                     ":=", "<>", ">=", "<=", "<", ">",
		                     "and", "or", "not", "xor", "true", "false",
		                     "if", "else", "for", "in",
		                     "var", "new",
		                     "operation", "return", "self",
		                     "allInstances",
		                     "add", "selectOne", "select", "collect", "includes", "excludes");
	}
}
