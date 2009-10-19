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

import static org.junit.Assert.assertEquals;
import grammar.Grammar;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import project.MigrationStrategy;

public class GrammarWordCounterTests {

	private static final GrammarWordCounter COUNTER = new GrammarWordCounter();
	
	@Test
	public void emptyString() {
		assertEquals(0, COUNTER.measure(createMigrationStrategy("")));
	}

	@Test
	public void singleWordNotFromGrammar() {
		assertEquals(0, COUNTER.measure(createMigrationStrategy("foo")));
	}
		
	@Test
	public void singleWordFromGrammar() {
		assertEquals(1, COUNTER.measure(createMigrationStrategy("class")));
	}
	
	@Test
	public void mixedBlock() {
		assertEquals(3, COUNTER.measure(createMigrationStrategy("class Foo { bar = baz }")));
	}
	
	@Test
	public void matchesOnlyOneWordWhereTwoWordsCouldMatch() {
		assertEquals(1, COUNTER.measure(createMigrationStrategy("<=")));
	}
	
	
	private static MigrationStrategy createMigrationStrategy(String code) {
		return new MigrationStrategy(code, new TestGrammar());
	}
	
	private static class TestGrammar implements Grammar {

		public int countNewDeleteAndChangeTypeOperationsIn(String text) {
			return 0;
		}

		public int countSimpleModelOperationsIn(String text) {
			return 0;
		}
		
		public Collection<String> getWords() {
			return Arrays.asList("class", "{", "}", "<", "<=");
		}		
	}
}
