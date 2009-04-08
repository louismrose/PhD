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

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;

import org.eclipse.epsilon.hutn.model.hutn.Spec;
import org.eclipse.epsilon.hutn.unparser.HutnUnparser;
import org.eclipse.epsilon.hutn.xmi.parser.XmiParser;

public class Xmi2Hutn {

	private final Spec spec;
	private final HutnUnparser unparser;
	
	public Xmi2Hutn(String xmi) throws HutnXmiBridgeException {
		try {
			spec     = new XmiParser(xmi).parse();
			unparser = new HutnUnparser(spec);
		
		} catch (XMLStreamException e) {
			throw new HutnXmiBridgeException(e);
			
		} catch (FactoryConfigurationError e) {
			throw new HutnXmiBridgeException(e);
		} 
	}
	

	public Spec getSpec() {
		return spec;
	}
	
	public String getHutn() {
		return unparser.unparse();
	}
}
