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
package generate;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.epsilon.egl.EglModule;
import org.eclipse.epsilon.egl.IEglModule;
import org.eclipse.epsilon.egl.beautify.JavaBeautifier;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.models.IModel;

import actions.ActionsException;
import actions.ActionsPackage;
import actions.Document;

public class ActionsGenerator {

	private final IModel actions;
	
	public ActionsGenerator(Document document) {
		actions = new InMemoryEmfModel("Actions", document.eResource(), ActionsPackage.eINSTANCE);
	}
	
	public String generate() throws ActionsException {
		try {
			final IEglModule generator = new EglModule();
			generator.getContext().getModelRepository().addModel(actions);
			generator.parse(ActionsGenerator.class.getResource("GenerateGadinCode.egl").toURI());
			
			return new JavaBeautifier().beautify(generator.execute());
		
		} catch (EglRuntimeException e) {
			throw new ActionsException(e);
			
		} catch (IOException e) {
			throw new ActionsException(e);
			
		} catch (URISyntaxException e) {
			throw new ActionsException(e);
			
		}
	}
}
