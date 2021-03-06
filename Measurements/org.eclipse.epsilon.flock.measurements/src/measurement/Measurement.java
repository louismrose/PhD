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
/**
 * 
 */
package measurement;

import java.io.PrintStream;

public interface Measurement {

	public Measurement add(Measurement addend);

	public Measurement divideBy(int divisor);

	public void printTo(PrintStream printer);
	
	@Override
	public String toString();
	
	@Override
	public boolean equals(Object obj);
	
	@Override
	public int hashCode();

}