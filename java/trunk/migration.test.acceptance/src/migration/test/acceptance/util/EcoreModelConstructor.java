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
package migration.test.acceptance.util;

import migration.test.dependencies.EcoreHutnConfigModel;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.test.fixtures.hutn.AbstractModelConstructor;

public class EcoreModelConstructor extends AbstractModelConstructor {

	@Override
	public EPackage construct(String hutn) {
		final IModel model = constructModel(addPreamble(hutn, "http://www.eclipse.org/emf/2002/Ecore",
				EcoreHutnConfigModel.getModelFile().getAbsolutePath()));

		try {
			for (Object o : model.getAllOfKind("EPackage")) {
				if (o instanceof EPackage) {
					return (EPackage)o;
				}
			}
		} catch (EolModelElementTypeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}	
}
