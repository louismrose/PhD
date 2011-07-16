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

public class AtlRuleWithDifferentSourceAndTargetTypeCounterTests {
	
	@Test
	public void matchesRuleWithDifferentSourceAndTargetType() {
		final String rule = "rule Foo2Bar { from f : Foo to b : Bar }";
		
		assertTrue(isARuleWithDifferentSourceAndTarget(rule));
	}
	
	@Test
	public void doesntMatchesRuleWithSameSourceAndTargetType() {
		final String rule = "rule Foo2Foo { from f1 : Foo to f2 : Foo }";
		
		assertFalse(isARuleWithDifferentSourceAndTarget(rule));
	}
	
	@Test
	public void matchesRuleWithBody() {
		final String rule = "rule Foo2Bar { from f : Foo to b : Bar ( name < f.name ) }";
		
		assertTrue(isARuleWithDifferentSourceAndTarget(rule));
	}
	
	@Test
	public void matchesRuleWithGuard() {
		final String rule = "rule Foo2Bar { from f : Foo ( name = 'John Smith' ) to b : Bar }";
		
		assertTrue(isARuleWithDifferentSourceAndTarget(rule));
	}
	
	@Test
	public void matchesRuleWithGuardContainingEmptyBrackets() {
		final String rule = "rule Foo2Bar { from f : Foo ( name = thisModule.calcuateName() ) to b : Bar }";
		
		assertTrue(isARuleWithDifferentSourceAndTarget(rule));
	}
	
	@Test
	public void matchesRuleWithGuardContainingNonEmptyBrackets() {
		final String rule = "rule Foo2Bar { from f : Foo ( name = thisModule.calcuateName(f) ) to b : Bar }";
		
		assertTrue(isARuleWithDifferentSourceAndTarget(rule));
	}
	
	@Test
	public void matchesRuleWithFullyQualifiedTypes() {
		final String rule = "rule Foo2Bar { from f : Model!Foo to b : Model!Bar }";
		
		assertTrue(isARuleWithDifferentSourceAndTarget(rule));
	}
	
	@Test
	public void doesntMatchesRuleWithDifferentModelsAndSameType() {
		final String rule = "rule Foo2Bar { from f : Source!Foo to b : Target!Foo }";
		
		assertFalse(isARuleWithDifferentSourceAndTarget(rule));
	}	
	
	@Test
	public void matchesRuleSplitOverSeveralLinesWithIndentation() {
		final String rule = "rule Foo2Bar {\n" + 
		                    "  from\n" +
		                    "    f : Foo\n" +
		                    "  to b : Bar (\n" +
		                    "    name <- f.name\n" +
		                    "  )\n" +
		                    "}";
		
		assertTrue(isARuleWithDifferentSourceAndTarget(rule));
	}
	
	@Test
	public void producesCorrectCountForSeveralRules() {
		final String transformation = "rule Foo2Bar { from f  : Foo to b  : Bar }" +
                                      "rule Foo2Foo { from f1 : Foo to f2 : Foo }" +
		                              "rule Bar2Baz { from r  : Bar to z  : Baz }";
		
		assertEquals(2, new AtlRuleWithDifferentSourceAndTargetTypeCounter(transformation).count());
	}
	
	
	public boolean isARuleWithDifferentSourceAndTarget(String rule) {
		return new AtlRuleWithDifferentSourceAndTargetTypeCounter(rule).count() > 0;
	}
}
