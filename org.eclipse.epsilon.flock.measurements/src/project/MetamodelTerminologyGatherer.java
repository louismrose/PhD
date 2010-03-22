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

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;

public class MetamodelTerminologyGatherer {

	private final List<EPackage> packages = new LinkedList<EPackage>();
	private final List<String>   terms    = new LinkedList<String>();
	
	public MetamodelTerminologyGatherer(File metamodel) {
		this(new MetamodelLoader(metamodel).load());
	}

	public MetamodelTerminologyGatherer(EPackage... metamodel) {
		this(Arrays.asList(metamodel));
	}
	
	public MetamodelTerminologyGatherer(Collection<EPackage> metamodel) {
		packages.addAll(metamodel);
	}

	public Collection<String> getTerms() {
		for (final EPackage pkg : packages) {
			for (final EClassifier classifier : pkg.getEClassifiers()) {
				terms.add(classifier.getName());
				
				if (classifier instanceof EClass) {
					for (final EStructuralFeature feature : ((EClass)classifier).getEStructuralFeatures()) {
						terms.add(feature.getName());
					}
				} else if (classifier instanceof EEnum) {
					for (final EEnumLiteral literal : ((EEnum)classifier).getELiterals()) {
						terms.add(literal.getName());
					}
				}
			}
		}
		
		return Collections.unmodifiableCollection(terms);
	}

}
