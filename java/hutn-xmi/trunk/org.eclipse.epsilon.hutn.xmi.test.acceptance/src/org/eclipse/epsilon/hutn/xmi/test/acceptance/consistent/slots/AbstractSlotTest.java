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
package org.eclipse.epsilon.hutn.xmi.test.acceptance.consistent.slots;

import static org.eclipse.epsilon.hutn.xmi.test.util.HutnTestUtil.slotTest;

import java.io.IOException;

import org.eclipse.epsilon.hutn.model.hutn.AttributeSlot;
import org.eclipse.epsilon.hutn.xmi.test.acceptance.HutnXmiBridgeAcceptanceTest;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractSlotTest extends HutnXmiBridgeAcceptanceTest {
	
	@Before
	public void setup() throws IOException {
		validAcceptanceTest(getXmi(), "");
	}
	
	@Test
	public void testSlot() {
		slotTest(getFirstSlotOfFamily(), AttributeSlot.class, getExpectedFeatureName(), getExpectedContent());
	}
	
	protected abstract java.lang.String getXmi();
	protected abstract java.lang.String getExpectedFeatureName();
	protected abstract Object getExpectedContent();
}
