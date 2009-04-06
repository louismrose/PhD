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
package org.eclipse.epsilon.hutn.xmi.transform.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public abstract class EmfUtil {

	private EmfUtil() {}
	
	public static XMIResource loadResource(String xml) throws IOException {
		final InputStream xmlStream = new ByteArrayInputStream(xml.getBytes("UTF-8"));
		final XMIResource resource  = (XMIResource)createResourceSet().createResource(URI.createURI("foo.model"));
		
		resource.load(xmlStream,
		              Collections.singletonMap(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, true));
		
		return resource;
	}
	
	public static XMIResource loadResource(java.net.URI uri) {
		return loadResource(URI.createURI(uri.toString()));
	}
	
	public static XMIResource loadResource(URI uri) {
		return (XMIResource)createResourceSet().getResource(uri, true);
	}
	
	public static ResourceSet createResourceSet() {
		final ResourceSet resourceSet = new ResourceSetImpl();
		
		// Register the appropriate resource factory to handle all file extensions.
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
			(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		resourceSet.getLoadOptions().put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, true);
		
//		final XMLOptions xmlOptions = new XMLOptionsImpl();
//		xmlOptions.setProcessAnyXML(true);
//		resourceSet.getLoadOptions().put(XMLResource.OPTION_XML_OPTIONS, xmlOptions);
		
		
//		resourceSet.getLoadOptions().put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_RECORD);

		return resourceSet;
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
