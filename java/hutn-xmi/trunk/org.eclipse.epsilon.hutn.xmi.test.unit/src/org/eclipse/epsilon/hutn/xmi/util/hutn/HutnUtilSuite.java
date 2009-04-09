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
package org.eclipse.epsilon.hutn.xmi.util.hutn;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({DetermineTypeFromMetaFeature.class,
               DetermineSlotFromMetaFeature.class,
               AddValueToAttributeSlot.class, AddValueToReferenceSlot.class})
public class HutnUtilSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(HutnUtilSuite.class);
	}
}
