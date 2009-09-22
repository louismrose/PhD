package extractclass.resources;
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


import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.mapping.ecore2xml.Ecore2XMLPackage;
import org.eclipse.emf.mapping.ecore2xml.Ecore2XMLRegistry;
import org.eclipse.emf.mapping.ecore2xml.impl.Ecore2XMLRegistryImpl;
import org.eclipse.emf.mapping.ecore2xml.util.Ecore2XMLExtendedMetaData;

import extractclass.ExtractclassPackage;


public class ExtractclassFactoryImpl extends XMIResourceFactoryImpl {

	public static final String BEFORE_NS_URI       = "extractclass";
	public static final String AFTER_PLATFORM_URI  = "platform:/plugin/refactorings.extractclass/model/After.ecore";
	public static final String BEFORE_PLATFORM_URI = "platform:/plugin/refactorings.extractclass/model/Before_2_After.ecore2xml";

	private ExtendedMetaData extendedMetaData;
	
	
	public Resource createResource(URI uri) {
		final XMIResource resource = (XMIResource) super.createResource(uri);

		final Map<Object, Object> defaultLoadOptions = resource.getDefaultLoadOptions();
		defaultLoadOptions.put(XMLResource.OPTION_EXTENDED_META_DATA,     getExtendedMetaData());
		defaultLoadOptions.put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
		defaultLoadOptions.put(XMLResource.OPTION_RESOURCE_HANDLER,       new ExtractclassResourceHandler());
		
		return resource;
	}
	
	private ExtendedMetaData getExtendedMetaData() {
		if(extendedMetaData == null) {
			final ResourceSet resourceSet = new ResourceSetImpl();
			final EPackage.Registry ePackageRegistry = resourceSet.getPackageRegistry();
			
			ePackageRegistry.put(BEFORE_NS_URI,      ExtractclassPackage.eINSTANCE);
			ePackageRegistry.put(AFTER_PLATFORM_URI, ExtractclassPackage.eINSTANCE);
			
			Ecore2XMLRegistry ecore2xmlRegistry = new Ecore2XMLRegistryImpl(Ecore2XMLRegistry.INSTANCE);
			ecore2xmlRegistry.put(BEFORE_NS_URI,
					EcoreUtil.getObjectByType(
							resourceSet.getResource(URI.createURI(BEFORE_PLATFORM_URI), 
									true).getContents(),
									Ecore2XMLPackage.Literals.XML_MAP));
			
			extendedMetaData = new Ecore2XMLExtendedMetaData(ePackageRegistry, ecore2xmlRegistry);			
		}
		return extendedMetaData;
	}
}
