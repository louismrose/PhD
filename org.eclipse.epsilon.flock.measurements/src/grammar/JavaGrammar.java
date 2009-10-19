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

public class JavaGrammar implements Grammar {

	public int countNewDeleteAndChangeTypeOperationsIn(String text) {
		throw new UnsupportedOperationException("Java grammar does not yet support this operation");
	}

	public int countSimpleModelOperationsIn(String text) {
		throw new UnsupportedOperationException("Java grammar does not yet support this operation");
	}

	public Collection<String> getWords() {
		return Arrays.asList("public", "private", "protected",
		                     "abstract", "final",
		                     "class", "interface", "implements", "extends",
		                     "new", "null", "return",
		                     "||", "&&", "|", "&", "!", "==", "=", "false", "true");
	}

}
