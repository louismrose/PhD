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
package org.eclipse.epsilon.hutn.xmi.test.acceptance.valid.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URISyntaxException;

import org.eclipse.epsilon.hutn.model.hutn.AttributeSlot;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.PackageObject;
import org.eclipse.epsilon.hutn.model.hutn.Slot;
import org.eclipse.epsilon.hutn.test.models.util.FileUtil;
import org.eclipse.epsilon.hutn.xmi.test.acceptance.valid.ValidAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;

public abstract class AbstractTypeTest extends ValidAcceptanceTest {
	
	private static PackageObject pkg;
	private static ClassObject family;
	
	@BeforeClass
	public static void setup() throws URISyntaxException {
		validAcceptanceTest(FileUtil.getFile("Types.model", AbstractTypeTest.class));
		
		pkg    = spec.getObjects().get(0);
		family = pkg.getClassObjects().get(0);
	}
	
	@Test
	public void slotIsCorrectType() {
		assertTrue(getSlot() instanceof AttributeSlot);
	}

	@Test
	public void slotHasCorrectNumberOfValues() {
		assertEquals(1, getSlot().getValues().size());
	}
	
	@Test
	public void slotHasCorrectContent() {
		assertEquals(getContent(), getSlot().getValues().get(0));
	}
	
	private Slot<?> getSlot() {
		return family.findSlot(getFeature());
	}
	
	protected abstract java.lang.String getFeature();
	protected abstract Object getContent();
}
