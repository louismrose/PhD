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
import grammar.CopeGrammar;

import org.junit.Test;

public class CopeGrammarTests {
	
	@Test
	public void copeAssignmentSymbol() {
		assertEquals(1, countCopeAssignmentsIn("a = b"));
	}
	
	@Test
	public void copeDoubleAssignmentSymbol() {
		assertEquals(0, countCopeAssignmentsIn("a == b"));
	}
	
	@Test
	public void copeNotEqualSymbol() {
		assertEquals(0, countCopeAssignmentsIn("a != b"));
	}
	
	@Test
	public void copeAssignmentSymbolWithNewInstance() {
		assertEquals(0, countCopeAssignmentsIn("a = bClass.newInstance()"));
	}
	
	@Test
	public void copeAssignmentSymbolWithFunction() {
		assertEquals(0, countCopeAssignmentsIn("isReading = { cp -> return Channel.allInstances.any { it.reader == cp}}"));
	}
	
	@Test
	public void copeUnsetCall() {
		assertEquals(1, countCopeAssignmentsIn("a.unset('b');"));
	}
	
	@Test
	public void copeUnsetAndAssignment() {
		assertEquals(2, countCopeAssignmentsIn("a = b; c.unset('d');"));
	}
	
	@Test
	public void copeSetInVariableName() {
		assertEquals(0, countCopeAssignmentsIn("faultset"));
	}
	

	private static int countCopeAssignmentsIn(String text) {
		return CopeGrammar.getInstance().countSimpleModelOperationsIn(text);
	}
}
