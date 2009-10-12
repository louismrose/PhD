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
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.emc.emf.EmfUtil;

public class MetamodelLoader {

	private final File metamodel;
	
	public MetamodelLoader(File metamodel) {
		this.metamodel = metamodel;
	}

	public Collection<EPackage> load() {
		try {
			return EmfUtil.register(URI.createFileURI(metamodel.getAbsolutePath()), EPackage.Registry.INSTANCE);
		
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

}
