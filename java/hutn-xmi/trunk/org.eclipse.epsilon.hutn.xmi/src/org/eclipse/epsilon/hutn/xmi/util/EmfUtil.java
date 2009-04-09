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
package org.eclipse.epsilon.hutn.xmi.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

public abstract class EmfUtil {

	private EmfUtil() {}
	
	public static Object createFromString(EDataType type, String value) {
		return type.getEPackage().getEFactoryInstance().createFromString((EDataType)type, value);
	}
	
	public static boolean isContainmentReference(EStructuralFeature feature) {
		return feature != null && feature instanceof EReference && ((EReference)feature).isContainment();
	}
	
		
	/* Copied from EMC EmfUtil */
	private final static URI DEFAULT_URI = URI.createFileURI("foo.ecore");
	
	public static Resource createResource() {
		return createResource(DEFAULT_URI);
	}
	
	public static Resource createResource(URI uri) {
		return createResource(null, uri);
	}
	
	public static Resource createResource(EObject rootObject) {
		return createResource(rootObject, DEFAULT_URI);
	}
	
	public static Resource createResource(EObject rootObject, URI uri) {
		final ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new EcoreResourceFactoryImpl());

		final Resource resource = resourceSet.createResource(uri);
		
		if (rootObject != null) {
			resource.getContents().add(rootObject);
		}
		
		return resource;
	}
}
