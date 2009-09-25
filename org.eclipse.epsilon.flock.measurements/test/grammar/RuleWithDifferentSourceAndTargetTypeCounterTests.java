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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RuleWithDifferentSourceAndTargetTypeCounterTests {

	@Test
	public void matchesRuleWithDifferentSourceAndTargetType() {
		final String rule = "rule Foo2Bar transform f : Foo to b : Bar {}";
		
		assertTrue(isARuleWithDifferentSourceAndTarget(rule));
	}
	
	@Test
	public void doesntMatchesRuleWithSameSourceAndTargetType() {
		final String rule = "rule Foo2Foo transform f1 : Foo to f2 : Foo {}";
		
		assertFalse(isARuleWithDifferentSourceAndTarget(rule));
	}
	
	@Test
	public void matchesRuleWithBody() {
		final String rule = "rule Foo2Bar transform f : Foo to b : Bar { b.name := f.name; }";
		
		assertTrue(isARuleWithDifferentSourceAndTarget(rule));
	}
	
	@Test
	public void matchesRuleWithFullyQualifiedTypes() {
		final String rule = "rule Foo2Bar transform f : Model!Foo to b : Model!Bar { b.name := f.name; }";
		
		assertTrue(isARuleWithDifferentSourceAndTarget(rule));
	}
	
	@Test
	public void doesntMatchesRuleWithDifferentModelsAndSameType() {
		final String rule = "rule Foo2Bar transform f : Source!Foo to b : Target!Foo { b.name := f.name; }";
		
		assertFalse(isARuleWithDifferentSourceAndTarget(rule));
	}
	
	@Test
	public void matchesRuleSplitOverSeveralLines() {
		final String rule = "rule Foo2Bar\n" + 
		                    "transform f : Foo\n" +
		                    "to b : Bar {\n" +
		                    "b.name := f.name;\n" +
		                    "}";
		
		assertTrue(isARuleWithDifferentSourceAndTarget(rule));
	}
	
	@Test
	public void matchesRuleSplitOverSeveralLinesAndWithIndentation() {
		final String rule = "rule Foo2Bar\n" + 
		                    "\ttransform f : Foo\n" +
		                    "\tto b : Bar {\n" +
		                    "\t\tb.name := f.name;\n" +
		                    "}";
		
		assertTrue(isARuleWithDifferentSourceAndTarget(rule));
	}
	
	@Test
	public void producesCorrectCountForSeveralRules() {
		final String transformation = "rule Foo2Bar transform f  : Foo to b  : Bar {}"   + 
                                      "rule Foo2Foo transform f1 : Foo to f2 : Foo {}" +
		                              "rule Bar2Baz transform r  : Bar to z  : Baz {}";
		
		assertEquals(2, new RuleWithDifferentSourceAndTargetTypeCounter(transformation).count());
	}
	
	
	public boolean isARuleWithDifferentSourceAndTarget(String rule) {
		return new RuleWithDifferentSourceAndTargetTypeCounter(rule).count() > 0;
	}
}
