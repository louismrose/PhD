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

import java.io.StringReader;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.eclipse.epsilon.hutn.model.hutn.Spec;
import org.eclipse.epsilon.hutn.xmi.parser.generator.SpecGenerator;
import org.eclipse.epsilon.hutn.xmi.util.HutnUtil;

public class XmiParser {

	private final String xmi;
	
	private XMLStreamReader xmlStreamReader;
	private final SpecGenerator generator = new SpecGenerator();
	
	public XmiParser(String xmi) {
		this.xmi = xmi;
	}

	public Spec parse() throws XMLStreamException, FactoryConfigurationError {
		xmlStreamReader = XMLInputFactory.newInstance().createXMLStreamReader(new StringReader(xmi));
		
		doParse();
			
		xmlStreamReader.close();
		
		
		return generator.getSpec();
	}
	
	private void doParse() throws XMLStreamException {
		while (xmlStreamReader.hasNext()) {
			final int token = xmlStreamReader.next();
			
			switch(token) {
				case XMLStreamReader.START_ELEMENT:
					processStartElement();
					break;
					
				case XMLStreamReader.END_ELEMENT:
					processEndElement();
					break;
					
				default:
					System.out.println(token);
			}
			
		}
	}

	private boolean firstElement = true;
	
	private void processStartElement() {
		final String tagName = xmlStreamReader.getLocalName();
		
		if (firstElement) {
			processNamespaces();
			generator.pushTopLevelClassObject(tagName);
		
			firstElement = false;
			
		} else {
			final String xsiType = xmlStreamReader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
			
			if (xsiType == null) {
				final String type = HutnUtil.determineTypeOfFeatureFromMetaClass(generator.getCurrentClassObject(), tagName, "UnknownType");
				generator.pushContainedClassObject(type, tagName);
				
			} else {
    			generator.pushContainedClassObject(getLocalName(xsiType), tagName);
			}
		}
		
		processAttributes();
	}
	
	private void processEndElement() {
		generator.popCurrentClassObject();
	}
	
	private void processNamespaces() {
		for (int index = 0; index < xmlStreamReader.getNamespaceCount(); index++) {
			if ("xmi".equals(xmlStreamReader.getNamespacePrefix(index)) ||
				"xsi".equals(xmlStreamReader.getNamespacePrefix(index))) {
					continue;
			}
			
			generator.initialise(xmlStreamReader.getNamespaceURI(index));
		}
	}
	
	private void processAttributes() {
		for (int index = 0; index < xmlStreamReader.getAttributeCount(); index++) {
			if ("xmi".equals(xmlStreamReader.getAttributePrefix(index)) ||
				"xsi".equals(xmlStreamReader.getAttributePrefix(index))) {
					continue;
			}
			
			generator.addSlot(xmlStreamReader.getAttributeLocalName(index), xmlStreamReader.getAttributeValue(index));
		}
	}
	
	
	private static String getLocalName(String qualifiedName) {
    	return qualifiedName.split(":")[1];
    }
}
