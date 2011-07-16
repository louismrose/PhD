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
package project;

import grammar.Grammar;

public class MigrationStrategy {

	public final String name;
	public final Grammar grammar;
	public final String code;
	
	public MigrationStrategy(String name, String code, Grammar grammar) {
		this.name    = name;
		this.code    = code;
		this.grammar = grammar;
	}
	
	@Override
	public String toString() {
		return code;
	}
}
