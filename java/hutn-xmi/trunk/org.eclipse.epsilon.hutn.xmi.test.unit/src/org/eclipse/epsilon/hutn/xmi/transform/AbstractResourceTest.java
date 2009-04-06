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
 * $Id$
 */
package org.eclipse.epsilon.hutn.xmi.transform;

import java.util.Arrays;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.epsilon.hutn.model.hutn.Spec;
import org.eclipse.epsilon.hutn.xmi.transform.util.EmfUtil;

public abstract class AbstractResourceTest {

	protected static Spec spec;
	
	protected static void resourceTest(EObject... resourceContents) {
		final XMIResource resource = createResource();
		resource.getContents().addAll(Arrays.asList(resourceContents));
		spec = new Resource2Spec(resource).transform();
	}
	
	private static XMIResource createResource() {
		return (XMIResource)EmfUtil.createResourceSet().createResource(URI.createURI("foo"));
	}
}
