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


public class Count implements Measurement {

	private final double count;
	
	public Count(double count) {
		this.count = count;
	}
	
	public Measurement add(Measurement addend) {
		if (!(addend instanceof Count))
			throw new IllegalArgumentException("Cannot add a Count and a " + addend.getClass().getSimpleName());
			
		return new Count(count + ((Count)addend).count);
	}
	
	public Measurement divideBy(int divisor) {
		return new Count(count / divisor);
	}
	
	public void printTo(PrintStream printer) {
		printer.print(count);
	}
	
	
	@Override
	public String toString() {
		return "Count of " + count;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Count))
			return false;
		
		return count == ((Count)obj).count;
	}
	
	@Override
	public int hashCode() {
		return new Double(count).hashCode();
	}
}
