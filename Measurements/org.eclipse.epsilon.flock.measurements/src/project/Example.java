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

import grammar.AtlGrammar;
import grammar.CopeGrammar;
import grammar.EpsilonGrammar;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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

	public Collection<MigrationStrategy> getMigrationStrategies() throws Exception {
		return Arrays.asList(getAtlMigrationStrategy(), getFlockMigrationStrategy(), getEtlMigrationStrategy(), getCopeMigrationStrategy(), getEcore2EcoreMigrationStrategy());
	}
	

	File getFlockFile() throws FileNotFoundException {
		try {
			final File fileFromMigDir = getFileFromExample("mig_lang/", ".mig");
			return fileFromMigDir == null ? getFileFromExample("flock/", ".mig") : fileFromMigDir;
		
		} catch (FileNotFoundException e) {
			return getFileFromExample("flock/", ".mig");
		}
	}
	
	public MigrationStrategy getFlockMigrationStrategy() throws IOException {
		final String code = getFlockFile() != null && getFlockFile().exists() ?
		                    new FileReader(getFlockFile()).readMigrationStrategy() :
		                    "";
                
		return new MigrationStrategy("Flock", code, EpsilonGrammar.getInstance());
	}

	
	File getEtlFile() throws FileNotFoundException {
		return getFileFromExample("etl/", ".etl");
	}
	
	public MigrationStrategy getEtlMigrationStrategy() throws IOException {
		final String code = getEtlFile() != null && getEtlFile().exists() ?
		                    new FileReader(getEtlFile()).readMigrationStrategy() :
		                    "";
                
		return new MigrationStrategy("ETL", code, EpsilonGrammar.getInstance());
	}
	
	
	File getAtlFile() throws FileNotFoundException {
		return getFileFromExample("atl/", ".atl");
	}
	
	public MigrationStrategy getAtlMigrationStrategy() throws IOException {
		final String code = getAtlFile() != null && getAtlFile().exists() ?
		                    new FileReader(getAtlFile()).readMigrationStrategy() :
		                    "";
                
		return new MigrationStrategy("ATL", code, AtlGrammar.getInstance());
	}
	
	
	File getCopeFile() {
		return getFileFromExample("cope/Before.history");
	}
	
	public MigrationStrategy getCopeMigrationStrategy() throws Exception {
		final String code = getCopeFile() != null && getCopeFile().exists() ?
		                    new CopeModelFileReader(getCopeFile()).readMigrationStrategy() :
		                    "";
		
		return new MigrationStrategy("COPE", code, CopeGrammar.getInstance());
	}
	
	
	File getEcore2EcoreFile() {
		final File ecore2ecoreFile = getFileFromExample("ecore2ecore/resources/" + getJavaName() + "ResourceHandler.java");
		return ecore2ecoreFile.exists() ? ecore2ecoreFile : null;
	}
	
	public boolean hasEcore2EcoreMigrationStrategy() {
		return getEcore2EcoreFile() != null;
	}

	public MigrationStrategy getEcore2EcoreMigrationStrategy() throws Exception {
		return new MigrationStrategy("Ecore2Ecore", new FileReader(getEcore2EcoreFile()).readMigrationStrategy(), EpsilonGrammar.getInstance());
	}

	
	File getOriginalMetamodel() {
		return getFileFromExample("Before.ecore");
	}
	
	File getEvolvedMetamodel() {
		return getFileFromExample("After.ecore");
	}
	
	public Collection<String> getMetamodelTerminology() {
		final Set<String> metamodelTerminology = new HashSet<String>();
		
		metamodelTerminology.addAll(getMetamodelTerminologyFrom(getOriginalMetamodel()));
		metamodelTerminology.addAll(getMetamodelTerminologyFrom(getEvolvedMetamodel()));
		
		return metamodelTerminology;
	}

	
	private Collection<String> getMetamodelTerminologyFrom(File metamodel) {
		return new MetamodelTerminologyGatherer(metamodel).getTerms();
	}
	
	private String getJavaName() {
		return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase().replaceAll(" ", "");
	}
	
	
	private File getFileFromExample(String path) {
		return new File(base, category + "/" + name + "/" + path);
	}
	
	private File getFileFromExample(String containerPath, final String suffix) throws FileNotFoundException {
		final File dir = new File(base, category + "/" + name + "/" + containerPath);
		
		final File[] matchingFiles = dir.listFiles(new FileFilter() {
			
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(suffix);
			}
		});
		
		if (matchingFiles == null)
			return null;
		
		if (matchingFiles.length == 0)
			throw new FileNotFoundException("No file found in " + containerPath + " with extension " + suffix);
		
		return matchingFiles[0];
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
