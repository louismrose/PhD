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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.epsilon.hutn.model.hutn.HutnFactory;
import org.eclipse.epsilon.hutn.model.hutn.NsUri;
import org.eclipse.epsilon.hutn.model.hutn.PackageObject;
import org.eclipse.epsilon.hutn.model.hutn.Spec;
import org.eclipse.epsilon.hutn.xmi.transform.util.ClassObjectCache;
import org.eclipse.epsilon.hutn.xmi.transform.util.EmfUtil;

public class Resource2Spec {

	private final XMIResource resource;
	private final ClassObjectCache cache;
	
	private Spec spec;
	private PackageObject pkg;
	
	public Resource2Spec(XMIResource resource) {
		this.resource = resource;
		this.cache    = new ClassObjectCache();
	}
	
	public Spec transform() {
		spec = HutnFactory.eINSTANCE.createSpec();
		EmfUtil.createResource(spec);
		
		if (!resource.getContents().isEmpty()) {
			intialiseSpec();
			initialisePackageObject();
			
			transformResourceContents();
		}
		
		return spec;
	}
	
	private void intialiseSpec() {
		for (String nsUriValue : allNsUris()) {
			final NsUri nsUri = HutnFactory.eINSTANCE.createNsUri();
			nsUri.setValue(nsUriValue);
			spec.getNsUris().add(nsUri);
		}
	}
	
	private List<String> allNsUris() {
		final List<String> nsUris = new LinkedList<String>();
		for (EObject o : resource.getContents()) {
			if (!nsUris.contains(getNsUriFor(o))) {
				nsUris.add(getNsUriFor(o));
			}
		}
		return nsUris;
	}
	
	private static String getNsUriFor(EObject o) {
		return o.eClass().getEPackage().getNsURI();
	}
	
	
	private void initialisePackageObject() {
		pkg = HutnFactory.eINSTANCE.createPackageObject();
		pkg.setType(resource.getContents().get(0).eClass().getEPackage().getName());
		spec.getObjects().add(pkg);
	}
	
	private void transformResourceContents() {
		for(EObject o : resource.getContents()) {
			pkg.getClassObjects().add(new EObject2ClassObject(o, cache).transform());
		}
	}
}
