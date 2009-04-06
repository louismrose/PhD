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
package org.eclipse.epsilon.hutn.xmi.transform;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.epsilon.hutn.model.hutn.Slot;

public class AbstractAttributeValueTest {

	protected static Slot<?> slot;
	
	protected static void attributeValueTest(Object object, EAttribute feature) {
		slot = new AttributeValue2AttributeSlot(object, feature).transform();
	}
}
