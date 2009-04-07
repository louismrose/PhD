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

public class Integer extends AbstractSlotTest {

	@Override
	protected java.lang.String getXmi() {
		return "numberOfChildren=\"2\"";
	}

	@Override
	protected java.lang.String getExpectedFeatureName() {
		return "numberOfChildren";
	}
	
	@Override
	protected Object getExpectedContent() {
		return 2;
	}
}