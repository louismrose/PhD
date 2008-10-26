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
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.hutn.HutnModule;
import org.eclipse.epsilon.hutn.IHutnModule;
import org.eclipse.epsilon.hutn.exceptions.HutnGenerationException;

public abstract class ModelConstructor {

	// Uninstantiable class
	private ModelConstructor() {}
	
	private static final IHutnModule hutnModule = new HutnModule(); 
	
	private static boolean parse(String hutn) {
		try {
			hutnModule.reset();
			
			if (hutnModule.parse(hutn)) {
				return true;	
			}
			
			for (ParseProblem problem : hutnModule.getParseProblems()) {
				System.err.println(problem);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	private static IModel constructModel(String hutn) {
		try {
			if (parse(hutn)) {
				return hutnModule.generateEmfModel();	
			}
		} catch (HutnGenerationException e) {
			e.printStackTrace();
		} 

		return null;
	}
	
	private static String addPreamble(String hutn, String nsUri, String configFile) {
		return "@Spec {"                                      +
                "    MetaModel \"MetaModel\" {"               +
                "        nsUri = \"" + nsUri + "\""           +
                "        configFile = \"" + configFile + "\"" +
                "    }"                                       +
                "}" + hutn;
	}
	
	public static EPackage constructMetaModel(String hutn) {
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
