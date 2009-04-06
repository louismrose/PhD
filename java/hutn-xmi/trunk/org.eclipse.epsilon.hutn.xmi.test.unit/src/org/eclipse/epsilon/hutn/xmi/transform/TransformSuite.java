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

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.eclipse.epsilon.hutn.xmi.coerce.TransformCoerceSuite;
import org.eclipse.epsilon.hutn.xmi.transform.eObject.TransformEObjectSuite;
import org.eclipse.epsilon.hutn.xmi.transform.resource.TransformResourceSuite;
import org.eclipse.epsilon.hutn.xmi.transform.value.attribute.TransformAttributeValueSuite;
import org.eclipse.epsilon.hutn.xmi.transform.value.reference.TransformReferenceValueSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TransformResourceSuite.class, TransformEObjectSuite.class,
               TransformAttributeValueSuite.class, TransformReferenceValueSuite.class,
               TransformCoerceSuite.class})
public class TransformSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(TransformSuite.class);
	}
}
