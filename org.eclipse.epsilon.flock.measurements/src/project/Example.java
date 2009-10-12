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

import grammar.CopeGrammar;
import grammar.EpsilonGrammar;

import java.io.File;
import java.io.IOException;

import measure.MetamodelTerminologyCounter;

import reader.CopeModelFileReader;
import reader.FileReader;

public class Example {

	private final File   base;
	private final String category;
	private final String name;
	
	public Example(File example) {
		this.base     = example.getParentFile().getParentFile();
		this.category = example.getParentFile().getName();
		this.name     = example.getName();
	}


	File getFlockFile() {
		return getFileFromExample("mig_lang/" + name + ".mig");
	}
	
	public MigrationStrategy getFlockMigrationStrategy() throws IOException {
		return new MigrationStrategy(new FileReader(getFlockFile()).readMigrationStrategy(), EpsilonGrammar.getInstance());
	}

	
	File getEtlFile() {
		return getFileFromExample("etl/" + name + ".etl");
	}
	
	public MigrationStrategy getEtlMigrationStrategy() throws IOException {
		return new MigrationStrategy(new FileReader(getEtlFile()).readMigrationStrategy(), EpsilonGrammar.getInstance());
	}
	
	
	File getCopeFile() {
		return getFileFromExample("cope/Before.history");
	}
	
	public MigrationStrategy getCopeMigrationStrategy() throws Exception {
		return new MigrationStrategy(new CopeModelFileReader(getCopeFile()).readMigrationStrategy(), CopeGrammar.getInstance());
	}
	
	
	File getEcore2EcoreFile() {
		final File ecore2ecoreFile = getFileFromExample("ecore2ecore/resources/" + getJavaName() + "ResourceHandler.java");
		return ecore2ecoreFile.exists() ? ecore2ecoreFile : null;
	}

	public MigrationStrategy getEcore2EcoreMigrationStrategy() throws Exception {
		return new MigrationStrategy(new FileReader(getEcore2EcoreFile()).readMigrationStrategy(), EpsilonGrammar.getInstance());
	}

	public MetamodelTerminologyCounter getMetamodelTerminologyCounter() {
		return new MetamodelTerminologyCounter(new MetamodelTerminologyGatherer(getFileFromExample("Before.ecore")).getTerms());
	}
	
	private String getJavaName() {
		return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase().replaceAll(" ", "");
	}
	
	
	private File getFileFromExample(String path) {
		return new File(base, category + "/" + name + "/" + path);
	}
	

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Example))
			return false;
		
		final Example other = (Example)o;
		
		return base.equals(other.base) && category.equals(other.category) && name.equals(other.name);  
	}
	
	@Override
	public int hashCode() {
		return base.hashCode() + category.hashCode() + name.hashCode(); 
	}
	
	@Override
	public String toString() {
		return category + "::" + name;
	}
}
