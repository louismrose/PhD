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
package cont2ref.resources;

import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.BasicResourceHandler;

import cont2ref.Cont2refPackage;
import cont2ref.Port;
import cont2ref.Signature;

public class Cont2refResourceHandler extends BasicResourceHandler {

	@Override
	public void postLoad(XMLResource resource, InputStream inputStream, Map<?, ?> options) {
		for (Iterator<EObject> iter = resource.getAllContents(); iter.hasNext();) {
			final EObject eObject = iter.next();
						
			if (isSignature(eObject)) {
				System.err.println("Migrating signature: " + eObject);
				migratePorts((Signature)eObject);
			}
		}
	}

	private boolean isSignature(EObject eObject) {
		return Cont2refPackage.eINSTANCE.getSignature().isInstance(eObject);
	}

	private void migratePorts(Signature owner) {
		final Collection<Port> newPorts = new LinkedList<Port>();
		final cont2ref.System system = getSystem(owner);
		
		for (Port port : owner.getPorts()) {
			final Port newPort;
			
			if (containsPortNamed(port.getName(), system)) {
				newPort = getPortNamed(port.getName(), system);
				
			} else {
				newPort = port;
				system.getPorts().add(port);
			}
			
			newPorts.add(newPort);
		}
		
		owner.getPorts().clear();
		owner.getPorts().addAll(newPorts);
	}
	
	private cont2ref.System getSystem(Signature signature) {
		return (cont2ref.System)signature.eContainer();
	}
	
	private boolean containsPortNamed(String name, cont2ref.System system) {
		return getPortNamed(name, system) != null;
	}
	
	private Port getPortNamed(String name, cont2ref.System system) {
		for (Port port : system.getPorts()) {
			if (name.equals(port.getName()))
				return port;
		}
		
		return null;
	}
}
