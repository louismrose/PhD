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
 * $Id:$
 */
package migration.models;

import java.util.List;

import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.Spec;

public class SlotModel {

	private final Spec model;

	public SlotModel(Spec model) {
		this.model = model;
	}
	
	public List<ClassObject> getAllClassObjects() {
		return EmfUtil.getAllModelElementsOfType(model, ClassObject.class);
	}
	
	public void giveIdentifierTo(ClassObject classObject) {
		String candidate;
		int suffix = 1;
		
		do {
			candidate = classObject.getType().toLowerCase() + suffix;
			suffix++;
		} while (isExistingIdentifier(candidate));
		
		classObject.setIdentifier(candidate);
	}
	
	public boolean isExistingIdentifier(String identifier) {
		for (ClassObject classObject : getAllClassObjects()) {
			if (identifier.equals(classObject.getIdentifier())) {
				return true;
			}
		}
		
		return false;
	}
}