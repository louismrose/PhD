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

import org.junit.Test;

public class EpsilonGrammarTests {

	@Test
	public void oneEpsilonAssignment() {
		assertEquals(1, countEpsilonStyleAssignmentsIn("a := b;"));
	}
	
	@Test
	public void oneEpsilonAssignmentToNewObject() {
		assertEquals(0, countEpsilonStyleAssignmentsIn("a := new bClass();"));
	}
	
	@Test
	public void noEpsilonAssignments() {
		assertEquals(0, countEpsilonStyleAssignmentsIn("a.inc();"));
	}
	
	@Test
	public void twoEpsilonAssignment() {
		assertEquals(2, countEpsilonStyleAssignmentsIn("a := b; c := d;"));
	}
	
	@Test
	public void severalLinesOfEpsilonAssignments() {
		final String text = "a := b;"  + System.getProperty("line.separator") + 
		                    "a.inc();" + System.getProperty("line.separator") +  
		                    "c := d;";
		
		assertEquals(2, countEpsilonStyleAssignmentsIn(text));
	}
	
	
	private static int countEpsilonStyleAssignmentsIn(String text) {
		return EpsilonGrammar.getInstance().countSimpleModelOperationsIn(text);
	}
}
