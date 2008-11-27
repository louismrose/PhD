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

import java.util.Collections;
import java.util.List;

import migration.test.dependencies.EcoreHutnConfigModel;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.test.fixtures.hutn.AbstractEObjectConstructor;

public class EPackageConstructor extends AbstractEObjectConstructor<EPackage> {

	@Override
	protected List<String> getConfigFiles() {
		return Collections.singletonList(EcoreHutnConfigModel.getModelFile().getAbsolutePath());
	}
	
	@Override
	protected List<String> getNsUris() {
		return Collections.singletonList("http://www.eclipse.org/emf/2002/Ecore");
	}

	@Override
	protected Class<EPackage> getRootElementType() {
		return EPackage.class;
	}	
}
