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
package reader;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.emc.emf.EmfUtil;

import edu.tum.cs.cope.history.HistoryPackage;

public abstract class CopeHistoryModel {

	private CopeHistoryModel() {}

	public static void register() throws Exception {
		EmfUtil.initialiseResourceFactoryRegistry();
		EPackage.Registry.INSTANCE.put(HistoryPackage.eNS_URI, HistoryPackage.eINSTANCE);
	}
}
