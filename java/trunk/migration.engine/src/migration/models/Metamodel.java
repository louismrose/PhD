/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id:$
 */
package migration.models;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.emc.emf.EmfUtil;

public class Metamodel {

	private final EPackage metamodel;

	public Metamodel(EPackage metamodel) {
		this.metamodel = metamodel;
	}
	
	public List<EClass> getAllEClasses() {
		return EmfUtil.getAllEClassesFromSameMetamodelAs(metamodel);
	}
	
	public EClass findEClassByName(String name) {
		for (EClass eClass : getAllEClasses()) {
			if (name.equals(eClass.getName())) {
				return eClass;
			}
		}
		
		return null;
	}
}
