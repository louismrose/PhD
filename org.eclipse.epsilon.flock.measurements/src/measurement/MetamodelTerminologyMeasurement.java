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

public class MetamodelTerminologyMeasurement implements Measurement {

	private final double numberOfWords;
	private final double numberOfMetamodelSpecificWords;
	private final double numberOfLanguageSpecificWords;
	
	public MetamodelTerminologyMeasurement(double numberOfWords, double numberOfMetamodelSpecificWords, double numberOfLanguageSpecificWords) {
		this.numberOfWords                  = numberOfWords;
		this.numberOfMetamodelSpecificWords = numberOfMetamodelSpecificWords;
		this.numberOfLanguageSpecificWords  = numberOfLanguageSpecificWords;
	}
	
	public Measurement add(Measurement other) {
		if (!(other instanceof MetamodelTerminologyMeasurement))
			throw new IllegalArgumentException("Cannot add a MetamodelTerminologyMeasurement and a " + other.getClass().getSimpleName());
		
		final MetamodelTerminologyMeasurement addend = (MetamodelTerminologyMeasurement)other;
		
		return new MetamodelTerminologyMeasurement(numberOfWords                  + addend.numberOfWords,
		                                           numberOfMetamodelSpecificWords + addend.numberOfMetamodelSpecificWords,
		                                           numberOfLanguageSpecificWords  + addend.numberOfLanguageSpecificWords);
	}

	public Measurement divideBy(int divisor) {
		return new MetamodelTerminologyMeasurement(numberOfWords                  / divisor,
		                                           numberOfMetamodelSpecificWords / divisor,
		                                           numberOfLanguageSpecificWords  / divisor);
	}

	public void printTo(PrintStream printer) {
		printer.print(numberOfWords);
		printer.print(" words, ");
		
		printer.print(numberOfMetamodelSpecificWords);
		printer.print(" metamodel-specific, ");
		
		printer.print(numberOfLanguageSpecificWords);
		printer.println(" language-specific");
		
//		printer.printf("%.2f", numberOfMetamodelSpecificWords / numberOfWords * 100);
//		printer.print("% metamodel-specific, ");
		
//		printer.printf("%.2f", numberOfLanguageSpecificWords / numberOfWords * 100);
//		printer.println("% language-specific.");
	}

	
	@Override
	public String toString() {
		return numberOfWords + " words (" + numberOfMetamodelSpecificWords + " metamodel-specific, " + numberOfLanguageSpecificWords + " language-specific)";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof MetamodelTerminologyMeasurement))
			return false;
		
		final MetamodelTerminologyMeasurement other = (MetamodelTerminologyMeasurement)obj;
		
		return numberOfWords                  == other.numberOfWords &&
		       numberOfMetamodelSpecificWords == other.numberOfMetamodelSpecificWords &&
		       numberOfLanguageSpecificWords  == other.numberOfLanguageSpecificWords;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		
		result = 37 * result + new Double(numberOfWords).hashCode();
		result = 37 * result + new Double(numberOfMetamodelSpecificWords).hashCode();
		result = 37 * result + new Double(numberOfLanguageSpecificWords).hashCode();
		
		return result;
	}
}
