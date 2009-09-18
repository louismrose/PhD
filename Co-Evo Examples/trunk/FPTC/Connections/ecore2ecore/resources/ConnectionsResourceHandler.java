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
package connections.resources;

import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.BasicResourceHandler;
import org.eclipse.emf.ecore.xml.type.AnyType;

import connections.Block;
import connections.Connection;
import connections.ConnectionsFactory;
import connections.ConnectionsPackage;

public class ConnectionsResourceHandler extends BasicResourceHandler {

	@Override
	public void postLoad(XMLResource resource, InputStream inputStream, Map<?, ?> options) {
		final Map<EObject, AnyType> extMap = resource.getEObjectToExtensionMap();
		
		for(Entry<EObject, AnyType> entry : extMap.entrySet()) {
			handleUnknownData(entry.getKey(), entry.getValue());
		}
	}

	private void handleUnknownData(EObject eObj, AnyType unknownData) {
		handleUnknownFeatures(eObj, unknownData.getMixed());
		handleUnknownFeatures(eObj, unknownData.getAnyAttribute());
	}
	
	private void handleUnknownFeatures(EObject owner, FeatureMap featureMap) {
		for (Iterator<FeatureMap.Entry> iter = featureMap.iterator(); iter.hasNext();) {
			final FeatureMap.Entry entry = iter.next();
			
			if (isBlock(owner)) {
				if (isSuccessors(entry.getEStructuralFeature()) && isCollectionOfBlocks(entry.getValue(), owner.eResource())) {
					migrateSuccessors((Block)owner, toCollectionOfBlocks(entry.getValue(), owner.eResource()));
					iter.remove();
				
				} else if (isInsetText(entry.getEStructuralFeature())  ||
				           isOutsetText(entry.getEStructuralFeature()) ||
				           isPredecessors(entry.getEStructuralFeature())) {
					
					iter.remove();
				}
			} else {
				System.err.println("Not a block: " + owner);
			}
		}
	}

	private boolean isBlock(EObject eObject) {
		return ConnectionsPackage.eINSTANCE.getBlock().isInstance(eObject);
	}
	
	private boolean isSuccessors(EStructuralFeature feature) {
		return "successors".equals(feature.getName());
	}
	
	private boolean isPredecessors(EStructuralFeature feature) {
		return "predecessors".equals(feature.getName());
	}
	
	private boolean isInsetText(EStructuralFeature feature) {
		return "inSetText".equals(feature.getName());
	}
	
	private boolean isOutsetText(EStructuralFeature feature) {
		return "outSetText".equals(feature.getName());
	}
//	
//	private boolean isDst(EStructuralFeature feature) {
//		return "dst".equals(feature.getName());
//	}
//	
	private boolean isCollectionOfBlocks(Object value, Resource resource) {
		final String[] uriFragments = ((String)value).split(" ");
		
		for (String uriFragment : uriFragments) {
			final EObject eObject = resource.getEObject(uriFragment);
			
			if (eObject == null || !ConnectionsPackage.eINSTANCE.getBlock().isInstance(eObject))
				return false;
		}
		
		return true;
	}
	
	private Collection<Block> toCollectionOfBlocks(Object value, Resource resource) {
		final String[] uriFragments = ((String)value).split(" ");
		
		final Collection<Block> blocks = new LinkedList<Block>();
		
		for (String uriFragment : uriFragments) {
			blocks.add((Block)resource.getEObject(uriFragment));
		}
		
		return blocks;
	}
	
	private void migrateSuccessors(Block owner, Collection<Block> successors) {
		for (Block successor : successors) {
			final Connection connection = ConnectionsFactory.eINSTANCE.createConnection();
			connection.setSource(owner);
			connection.setTarget(successor);
			getSystem(owner).getConnections().add(connection);
		}
	}

	private connections.System getSystem(Block owner) {
		for (Iterator<EObject> iterator = owner.eResource().getAllContents(); iterator.hasNext();) {
			final EObject modelElement = iterator.next();
			
			if (modelElement instanceof connections.System) {
				if (((connections.System)modelElement).getBlocks().contains(owner)) {
					return (connections.System)modelElement;
				}
			}	
		}
		
		return null;
	}
}
