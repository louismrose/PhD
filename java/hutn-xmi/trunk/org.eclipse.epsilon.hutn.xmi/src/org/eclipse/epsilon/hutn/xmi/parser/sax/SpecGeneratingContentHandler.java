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
package org.eclipse.epsilon.hutn.xmi.parser.sax;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.epsilon.hutn.model.hutn.Spec;
import org.eclipse.epsilon.hutn.xmi.parser.generator.SpecGenerator;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SpecGeneratingContentHandler extends DefaultHandler {

	private final SpecGenerator generator = new SpecGenerator();
	
	public Spec getSpec() {
		return generator.getSpec();
	}
	
	@Override
	public void startPrefixMapping(String prefix, String uri) {
		if ("xmi".equals(prefix) || "xsi".equals(prefix))
			return;
		
		generator.initialise(prefix);		
	}

	private boolean firstElement = true;
	
	@Override
    public void startElement (String uri, String name, String qName, Attributes atts) {   	
    	if (firstElement) {
	    	generator.pushTopLevelClassObject(name);
	    	firstElement = false;
    	
    	} else {
    		if (atts.getIndex("xsi:type") >= 0) {
    			generator.pushContainedClassObject(getLocalName(atts.getValue("xsi:type")), name);
			} else {
				// XMI doesn't include an xsi:type
				final String type = inferTypeFromMetaClassOfParent(name);
				generator.pushContainedClassObject(type, name);
			}
    	}
    }

    private String inferTypeFromMetaClassOfParent(String name) {
    	if (generator.getCurrentClassObject().hasEClass()) {
    		for (EReference reference : generator.getCurrentClassObject().getEClass().getEAllContainments()) {
    			if (name.equals(reference.getName())) {
    				return reference.getEType().getName();
    			}
    		}
    	}
    	
    	return "UnknownType";
	}

	@Override
    public void endElement (String uri, String name, String qName) {
    	generator.popCurrentClassObject();
    }
    
    
    
    private static String getLocalName(String qualifiedName) {
    	return qualifiedName.split(":")[1];
    }
    
}
