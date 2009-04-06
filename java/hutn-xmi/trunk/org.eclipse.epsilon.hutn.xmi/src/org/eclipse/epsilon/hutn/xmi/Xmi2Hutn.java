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
package org.eclipse.epsilon.hutn.xmi;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.epsilon.hutn.model.hutn.Spec;
import org.eclipse.epsilon.hutn.unparser.HutnUnparser;
import org.eclipse.epsilon.hutn.xmi.parser.XmiParser;
import org.eclipse.epsilon.hutn.xmi.util.EmfUtil;

public class Xmi2Hutn {

	private final Spec spec;
	private final HutnUnparser unparser;
	
	// Used by tests
	public Xmi2Hutn(String xml) throws IOException {
		this(EmfUtil.loadResource(xml));
	}
	
	public Xmi2Hutn(File model) throws URISyntaxException {
		this(new URI("file://" + model.getAbsolutePath()));
	}
	
	public Xmi2Hutn(URI modelUri) {
		this(EmfUtil.loadResource(modelUri));
	}
	
	private Xmi2Hutn(XMIResource resource) {
		spec     = new XmiParser(resource).parse();
		unparser = new HutnUnparser(spec);
	}

	public Spec getSpec() {
		return spec;
	}
	
	public String getHutn() {
		return unparser.unparse();
	}
}
