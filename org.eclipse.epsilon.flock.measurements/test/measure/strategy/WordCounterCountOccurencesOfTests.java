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

import java.util.Arrays;
import java.util.Collection;

import measure.strategy.WordCounter;

import org.junit.Test;

import grammar.EpsilonGrammar;
import project.MigrationStrategy;

public class WordCounterCountOccurencesOfTests {
	
	@Test
	public void oneOccurenceOfOneWord() {
		assertEquals(1, countOccurences(of("foo"), in("foo")));
	}
	
	@Test
	public void twoOccurencesOfOneWord() {
		assertEquals(2, countOccurences(of("foo"), in("foo foo")));
	}
	
	@Test
	public void oneOccurencesEachOfTwoWords() {
		assertEquals(2, countOccurences(of("foo", "bar"), in("bar foo")));
	}
	
	@Test
	public void noOccurencesOfAnyOfTwoWords() {
		assertEquals(0, countOccurences(of("foo", "bar"), in("baz baaz baaaz")));
	}
	
	@Test
	public void wordNotCountedWhenContainedAsPartOfLongerWord() {
		assertEquals(0, countOccurences(of("bar"), in("rhubarb")));
	}
	
	
	private static int countOccurences(Collection<String> words, MigrationStrategy strategy) {
		return new WordCounter(strategy).countOccurencesOf(words);
	}
	
	private static Collection<String> of(String... words) {
		return Arrays.asList(words);
	}
	
	private static MigrationStrategy in(String code) {
		return new MigrationStrategy("TestMigrationStrategy", code, EpsilonGrammar.getInstance());
	}
	
}
