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


public class Integer extends AbstractTypeTest {
	
	@Override
	protected java.lang.String getFeature() {
		return "numberOfChildren";
	}
	
	@Override
	protected Object getContent() {
		return 2;
	}
}
