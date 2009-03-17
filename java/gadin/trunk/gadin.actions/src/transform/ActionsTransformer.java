/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package transform;

import actions.ActionsException;

import org.eclipse.epsilon.antlr.postprocessor.model.antlrAst.Ast;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.etl.IEtlModule;
import org.eclipse.epsilon.hutn.exceptions.HutnMetaModelRegistrationException;
import org.eclipse.epsilon.hutn.util.EmcUtil;
import org.eclipse.epsilon.hutn.util.EpsilonUtil;

import actions.ActionsFactory;
import actions.ActionsPackage;
import actions.Document;
import actionsAntlrAst.ActionsAntlrAstPackage;

public class ActionsTransformer {
	
	private static void registerMetaModels() throws HutnMetaModelRegistrationException {
		EmcUtil.register(ActionsPackage.eNS_URI,         ActionsPackage.eINSTANCE);
		EmcUtil.register(ActionsAntlrAstPackage.eNS_URI, ActionsAntlrAstPackage.eINSTANCE);
	}
	
	public Document createDocument(Ast ast) throws ActionsException {
		try {
			final IModel astModel = new InMemoryEmfModel("ActionsAntlrAst", ast.eResource(), ActionsAntlrAstPackage.eINSTANCE);
			
			final Document document = ActionsFactory.eINSTANCE.createDocument();
			final EmfModel actionsModel = new InMemoryEmfModel("Actions", EmfUtil.createResourceFor(document), ActionsPackage.eINSTANCE);
			actionsModel.setMetamodelFileBased(false);
			actionsModel.setMetamodelUri(ActionsPackage.eNS_URI);
			
			registerMetaModels();
			
			final IEtlModule transformer = EpsilonUtil.initialiseEtlModule(astModel, actionsModel);
			
			transformer.parse(ActionsTransformer.class.getResource("AntlrAst2Actions.etl").toURI());
			transformer.execute();
			
			return document;
			
		} catch (Exception e) {
			throw new ActionsException(e);
		}
	}
}
