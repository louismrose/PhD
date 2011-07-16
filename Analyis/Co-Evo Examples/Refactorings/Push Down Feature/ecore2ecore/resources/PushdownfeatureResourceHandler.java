package pushdownfeature.resources;
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


import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.BasicResourceHandler;
import org.eclipse.emf.ecore.xml.type.AnyType;

import pushdownfeature.Employee;
import pushdownfeature.PushdownfeatureFactory;
import pushdownfeature.PushdownfeaturePackage;
import pushdownfeature.Salesperson;


public class PushdownfeatureResourceHandler extends BasicResourceHandler {

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
						
			if (isEmployee(owner)) {
				if (isQuota(entry.getEStructuralFeature())) {
					migrateEmployee((Employee)owner, Integer.parseInt(entry.getValue().toString()));
					iter.remove();	
				}
			} else {
				System.err.println("Not a job item: " + owner);
			}
		}
	}

	private boolean isEmployee(EObject eObject) {
		return PushdownfeaturePackage.eINSTANCE.getEmployee().isInstance(eObject);
	}
	
	private boolean isQuota(EStructuralFeature feature) {
		return "quota".equals(feature.getName());
	}
	
	private void migrateEmployee(Employee employee, int quota) {
		final Salesperson replacement = PushdownfeatureFactory.eINSTANCE.createSalesperson();
		replacement.setName(employee.getName());
		replacement.setQuota(quota);
		
		replace(((pushdownfeature.System)employee.eContainer()).getEmployees(), employee, replacement);
	}
	
	private static <T> void replace(List<T> list, T existing, T replacement) {
		final int index = list.indexOf(existing);
		list.remove(index);
		list.add(index, replacement);
	}
}
