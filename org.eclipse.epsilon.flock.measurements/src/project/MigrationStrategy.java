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

import java.io.IOException;

import measure.MigrationStrategyMeasure;

public class MigrationStrategy {

	public final Grammar grammar;
	public final String code;
	
	public MigrationStrategy(String code, Grammar grammar) throws IOException {
		this.code    = code;
		this.grammar = grammar;
	}
	
	@Override
	public String toString() {
		return code;
	}

	
	public void accept(MigrationStrategyMeasure visitor) {
		visitor.measure(this);
	}
}
