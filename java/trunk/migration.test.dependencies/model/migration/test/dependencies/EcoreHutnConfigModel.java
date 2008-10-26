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
package migration.test.dependencies;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.commons.util.FileUtil;

public class EcoreHutnConfigModel {

	private EcoreHutnConfigModel() {}
	
	public static File getModelFile() {
		return FileUtil.getFile("EcoreHutnConfig.model", EcoreHutnConfigModel.class);
	}
	
	public static URI getModelUri() {
		return URI.createFileURI(getModelFile().getAbsolutePath());
	}
}
