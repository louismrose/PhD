/*******************************************************************************
 * Copyright (c) 2009 The University of York.
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
package org.eclipse.epsilon.hutn.xmi.parser;

import java.io.IOException;
import java.io.StringReader;

import org.eclipse.epsilon.hutn.model.hutn.HutnFactory;
import org.eclipse.epsilon.hutn.model.hutn.Spec;
import org.eclipse.epsilon.hutn.xmi.parser.sax.ContentHandlerMultiplexer;
import org.eclipse.epsilon.hutn.xmi.parser.sax.DebugContentHandler;
import org.eclipse.epsilon.hutn.xmi.parser.sax.SpecGeneratingContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class XmiParser {

	private final String xmi;
	
	private XMLReader reader;
	private SpecGeneratingContentHandler handler;
	
	private static final boolean DEBUG = false;
	
	
	public XmiParser(String xmi) {
		this.xmi = xmi;
	}

	public Spec parse() throws SAXException, IOException {
		initialiseXmlReader();
		
		return doParse();
	}
	
	private void initialiseXmlReader() throws SAXException {
		reader  = XMLReaderFactory.createXMLReader();
		handler = new SpecGeneratingContentHandler();
		
		if (DEBUG) {
			reader.setContentHandler(new ContentHandlerMultiplexer(new DebugContentHandler(), handler));
		} else {
			reader.setContentHandler(handler);

		}
	}
	
	private Spec doParse() throws IOException {
		try {
			reader.parse(new InputSource(new StringReader(xmi)));
			return handler.getSpec();
			
		} catch (SAXException e) {
			return HutnFactory.eINSTANCE.createSpec();
		}
	}
}
