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

import org.eclipse.epsilon.hutn.model.hutn.Slot;
import org.eclipse.epsilon.hutn.model.hutn.Spec;
import org.eclipse.epsilon.hutn.xmi.parser.generator.SpecGenerator;
import org.eclipse.epsilon.hutn.xmi.util.HutnUtil;
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
				final String type = HutnUtil.determineTypeOfFeatureFromMetaClass(generator.getCurrentClassObject(), name, "UnknownType");
				generator.pushContainedClassObject(type, name);
			}
    	}
    	
    	processAttributes(atts);
    }

    private void processAttributes(Attributes atts) {
		for (int index = 0; index < atts.getLength(); index++) {
			
			if (atts.getQName(index).startsWith("xmi") ||
				atts.getQName(index).startsWith("xsi")) {
			  	  continue;
			}
			
			Slot<?> slot = null;
			
			
			if (generator.getCurrentClassObject().hasEClass()) {
				slot = HutnUtil.determineSlotFromTypeOfMetaFeature(generator.getCurrentClassObject(), atts.getLocalName(index), atts.getValue(index));
				
			} else {
				// TODO: use coerce?
			}
			
			if (slot != null) {
				generator.getCurrentClassObject().getSlots().add(slot);
			}
		}
	}



	@Override
    public void endElement (String uri, String name, String qName) {
    	generator.popCurrentClassObject();
    }
    
    
    
    private static String getLocalName(String qualifiedName) {
    	return qualifiedName.split(":")[1];
    }
    
}
