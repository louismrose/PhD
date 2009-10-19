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

import static org.junit.Assert.assertEquals;

import measure.strategy.WordCounter;

import org.junit.Test;

import grammar.EpsilonGrammar;
import project.MigrationStrategy;

public class WordCounterTests {

	private static final WordCounter COUNTER = new WordCounter();
	
	@Test
	public void emptyString() {
		assertEquals(0, COUNTER.measure(createMigrationStrategy("")));
	}

	@Test
	public void singleWord() {
		assertEquals(1, COUNTER.measure(createMigrationStrategy("foo")));
	}

	@Test
	public void wordStartingWithASpace() {
		assertEquals(1, COUNTER.measure(createMigrationStrategy(" foo")));
	}
	
	@Test
	public void wordStartingWithATab() {
		assertEquals(1, COUNTER.measure(createMigrationStrategy("\tfoo")));
	}
	
	@Test
	public void twoWordsSeparatedBySpaces() {
		assertEquals(2, COUNTER.measure(createMigrationStrategy("foo bar")));
	}
	
	@Test
	public void twoWordsSeparatedByTwoSpaces() {
		assertEquals(2, COUNTER.measure(createMigrationStrategy("foo  bar")));
	}
	
	@Test
	public void twoWordsSeparatedByADot() {
		assertEquals(2, COUNTER.measure(createMigrationStrategy("foo.bar")));
	}
	
	@Test
	public void twoWordsSeparatedByANewline() {
		assertEquals(2, COUNTER.measure(createMigrationStrategy("foo\nbar")));
	}
	
	
	private static MigrationStrategy createMigrationStrategy(String code) {
		return new MigrationStrategy("TestMigrationStrategy", code, EpsilonGrammar.getInstance());
	}
}
