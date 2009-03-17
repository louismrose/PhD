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

public class PortsMetamodel {

	private PortsMetamodel() {}
	
	public static File getMetaModelFile() {
		return FileUtil.getFile("Ports.ecore", PortsMetamodel.class);
	}
	
	public static URI getMetaModelUri() {
		return URI.createFileURI(getMetaModelFile().getAbsolutePath());
	}
}
