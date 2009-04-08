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
package org.eclipse.epsilon.hutn.xmi.test.integration.consistent.packageObjects;

import org.eclipse.epsilon.hutn.xmi.HutnXmiBridgeException;
import org.eclipse.epsilon.hutn.xmi.test.integration.HutnXmiBridgeIntegrationTest;
import org.junit.Test;

public class EmptyModel extends HutnXmiBridgeIntegrationTest {
	
	@Test(expected=HutnXmiBridgeException.class)
	public void emptyFileCausesException() throws HutnXmiBridgeException {
		integrationTestWithExceptions("<?xml version=\"1.0\" encoding=\"ASCII\"?>\n");
	}
}
