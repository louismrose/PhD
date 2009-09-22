package movefeature.resources;
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
import java.util.Map;
import java.util.Map.Entry;

import movefeature.Account;
import movefeature.MovefeaturePackage;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.BasicResourceHandler;
import org.eclipse.emf.ecore.xml.type.AnyType;


public class MovefeatureResourceHandler extends BasicResourceHandler {

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
									
			if (isAccount(owner)) {
				if (isInterestRate(entry.getEStructuralFeature())) {
					migrateInterestRate((Account)owner, Float.parseFloat(entry.getValue().toString()));
					iter.remove();	
				}
			} else {
				System.err.println("Not a job item: " + owner);
			}
		}
	}

	private boolean isAccount(EObject eObject) {
		return MovefeaturePackage.eINSTANCE.getAccount().isInstance(eObject);
	}
	
	private boolean isInterestRate(EStructuralFeature feature) {
		return "interestRate".equals(feature.getName());
	}

	private void migrateInterestRate(Account owner, float interestRate) {
		if (owner.getType().getInterestRate() != 0.0 && owner.getType().getInterestRate() != interestRate) {
			System.err.println("Conflicting interest rates for " + owner.getType().getName() + " AccountType");
		
		} else {
			owner.getType().setInterestRate(interestRate);
		}
	}
}
