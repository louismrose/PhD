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
package org.eclipse.epsilon.hutn.xmi.test.acceptance.valid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.ClassObjectSlot;
import org.eclipse.epsilon.hutn.model.hutn.ContainmentSlot;
import org.eclipse.epsilon.hutn.model.hutn.PackageObject;
import org.eclipse.epsilon.hutn.model.hutn.Slot;
import org.eclipse.epsilon.hutn.model.hutn.Spec;
import org.eclipse.epsilon.hutn.test.model.HutnTestWithFamiliesMetaModel;
import org.eclipse.epsilon.hutn.test.models.util.FileUtil;
import org.eclipse.epsilon.hutn.xmi.Xmi2Hutn;

public abstract class ValidAcceptanceTest extends HutnTestWithFamiliesMetaModel {
	
	protected static Spec spec;
	
	protected static void validAcceptanceTest(File model) throws URISyntaxException {
		spec = new Xmi2Hutn(model).getSpec();
	}
	
	protected static void validAcceptanceTest(Class<?> klass) throws URISyntaxException {
		validAcceptanceTest(FileUtil.getFile(klass.getSimpleName() + ".model", klass));
	}
	
	
	protected static void validAcceptanceTest(String xml) throws IOException {
		validAcceptanceTest("", xml);
	}
	
	protected static void validAcceptanceTest(String modelXmlAttributes, String xml) throws IOException {
		spec = new Xmi2Hutn(wrapXml(modelXmlAttributes, xml)).getSpec();
	}
	
	private static String wrapXml(String attributes, String contents) {
		final StringBuilder builder = new StringBuilder();
		
		builder.append("<?xml version=\"1.0\" encoding=\"ASCII\"?>");
		
		builder.append("<families:Model xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:families=\"families\" xmi:id=\"_I6yJURhKEd6d_-caKAfnUw\" ");
		builder.append(attributes);
		builder.append(">");
		
		builder.append(contents);
		builder.append("</families:Model>");
		
		return builder.toString();
	}
	
	
	protected static void slotTest(Slot<?> slot, Class<? extends Slot<?>> expectedType, String expectedFeature, Object... expectedValues) {
		assertTrue(expectedType.isInstance(slot));
		assertEquals(expectedFeature, slot.getFeature());
		assertEquals(expectedValues.length, slot.getValues().size());
		
		
		if (slot instanceof ClassObjectSlot<?>) {
			// compare types of class objects
			for (int index = 0; index < ((ClassObjectSlot<?>)slot).getClassObjects().size(); index++) {
				final ClassObject value     = ((ClassObjectSlot<?>)slot).getClassObjects().get(index);
				final Object expectedValue = expectedValues[index];
				
				assertEquals(expectedValue, value.getType());
			}
		
		
		} else {
			// compare values
			for (int index = 0; index < slot.getValues().size(); index++) {
				final Object value         = slot.getValues().get(index);
				final Object expectedValue = expectedValues[index]; 
	
					assertTrue(expectedValue.getClass().isInstance(value));
					assertEquals(expectedValue, value);
			}
		}
	}
	
	
	
	private static PackageObject getPackageObject() {
		return spec.getObjects().get(0);
	}
	
	protected static ClassObject getModel() {
		return getPackageObject().getClassObjects().get(0);
	}
	
	protected static ContainmentSlot getFirstSlotOfModel() {
		return (ContainmentSlot)getModel().getSlots().get(0);
	}
	
	protected static ClassObject getFamily() {
		return getFirstSlotOfModel().getValues().get(0);
	}
	
	protected static Slot<?> getFirstSlotOfFamily() {
		return getFamily().getSlots().get(0);
	}
}
