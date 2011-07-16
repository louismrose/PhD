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

public class CopeNewDeleteAndChangeTypeGrammarTests {

	@Test
	public void newModelElement() {
		assertEquals(1, countCopeCreateDeleteAndChangeTypeModelOperationsIn("a = clazz.newInstance()"));
	}
	
	@Test
	public void newModelElementWithoutAssignment() {
		assertEquals(1, countCopeCreateDeleteAndChangeTypeModelOperationsIn("Bar.newInstance()"));
	}
	
	@Test
	public void deleteModelElement() {
		assertEquals(1, countCopeCreateDeleteAndChangeTypeModelOperationsIn("element.delete()"));
	}
	
	@Test
	public void flockToPart() {
		assertEquals(1, countCopeCreateDeleteAndChangeTypeModelOperationsIn("foo.migrate(bar)"));
	}
	
	@Test
	public void assignment() {
		assertEquals(0, countCopeCreateDeleteAndChangeTypeModelOperationsIn("a = b;"));
	}
	
	@Test
	public void combined() {
		assertEquals(3, countCopeCreateDeleteAndChangeTypeModelOperationsIn("foo.migrate(bar)"        +
		                                                                    "baz = Foo.newInstance()" +
		                                                                    "baaz.delete()"));
	}
	
	private static int countCopeCreateDeleteAndChangeTypeModelOperationsIn(String text) {
		return CopeGrammar.getInstance().countNewDeleteAndChangeTypeOperationsIn(text);
	}
}
