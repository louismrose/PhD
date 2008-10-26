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
package migration;

import java.io.File;
import java.net.URI;

import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.hutn.HutnModule;
import org.eclipse.epsilon.hutn.IHutnModule;
import org.eclipse.epsilon.hutn.model.hutn.Spec;

public class HutnModuleFacade {

	private final IHutnModule hutnModule = new HutnModule();
	
	private boolean parse(Object hutn) {
		try {
			hutnModule.reset();
			
			if (hutn instanceof String) {
				hutnModule.parse((String)hutn);
			
			} else if (hutn instanceof URI) {
				hutnModule.parse((URI)hutn);
			
			} else if (hutn instanceof File){
				hutnModule.parse((File)hutn);
			
			} else {
				throw new IllegalStateException("Cannot parse objects of type " + hutn.getClass().getSimpleName() + ": " + hutn);
			}
			
			if (hutnModule.hasValidHutn()) {
				return true;
			}
			
			for (ParseProblem problem : hutnModule.getParseProblems()) {
				// FIXME: Do something better with parse problems
				System.err.println(problem);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Spec constructSpec(Object hutn) {
		if (parse(hutn)) {
			return hutnModule.getIntermediateModel();
		}
		
		return null;
	}
}
