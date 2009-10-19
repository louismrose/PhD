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
package measurement;

import java.io.PrintStream;


public class NullMeasurement implements Measurement {

	public Measurement add(Measurement addend) {
		return addend;
	}

	public void printTo(PrintStream printer) {
		// do nothing
	}
	
	public Measurement divideBy(int divisor) {
		return this;
	}

	
	@Override
	public String toString() {
		return "NullMeasurement";
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof NullMeasurement;
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
}
