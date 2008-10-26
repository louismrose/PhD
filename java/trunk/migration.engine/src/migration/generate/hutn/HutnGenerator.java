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
package migration.generate.hutn;

import org.eclipse.epsilon.egl.EglModule;
import org.eclipse.epsilon.egl.IEglModule;
import org.eclipse.epsilon.egl.beautify.JavaBeautifier;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.hutn.model.hutn.HutnPackage;
import org.eclipse.epsilon.hutn.model.hutn.Spec;

public class HutnGenerator {

	private final IModel source;
	
	public HutnGenerator(Spec spec) {
		source = new InMemoryEmfModel("Intermediate", spec.eResource(), HutnPackage.eINSTANCE);
	}
	
	public String generate() {
		try {
			final IEglModule generator = new EglModule();
			generator.getContext().getModelRepository().addModel(source);
			generator.parse(HutnGenerator.class.getResource("Intermediate2Hutn.egl").toURI());
			
			return new JavaBeautifier().beautify(generator.execute()).trim();
	
		} catch (Exception e) {
			// TODO: Something better than printing an error
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		return "";
	}
}
