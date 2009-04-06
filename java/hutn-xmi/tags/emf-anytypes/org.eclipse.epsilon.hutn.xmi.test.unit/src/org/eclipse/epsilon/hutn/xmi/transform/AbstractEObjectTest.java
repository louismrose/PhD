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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.xmi.transform.EObject2ClassObject;
import org.eclipse.epsilon.hutn.xmi.transform.util.ClassObjectCache;
import org.eclipse.epsilon.hutn.xmi.transform.util.EmfUtil;

public abstract class AbstractEObjectTest {

	protected static ClassObject classObject;
	
	protected static void eObjectTest(EObject object) {
		classObject = new EObject2ClassObject(object, new ClassObjectCache()).transform();
		EmfUtil.createResource(classObject);
	}
}
