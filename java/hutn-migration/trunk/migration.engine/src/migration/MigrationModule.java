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
package migration;

import java.io.File;
import java.net.URI;

import migration.generate.hutn.HutnGenerator;
import migration.migrator.Migrator;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.hutn.model.hutn.PackageObject;
import org.eclipse.epsilon.hutn.model.hutn.Spec;

public class MigrationModule {

	private final Spec slotModel;

	
	public MigrationModule(URI hutn) {
		this((Object)hutn);
	}
	
	public MigrationModule(String hutn) {
		this((Object)hutn);
	}
	
	public MigrationModule(File hutn) {
		this((Object)hutn);
	}
	
	private MigrationModule(Object hutn) {
		this.slotModel = new HutnModuleFacade().constructSpec(hutn);
	}
	
	
	public Spec suggestMigration() {
		if (slotModel.getNsUris().isEmpty()) {
			throw new IllegalStateException("The HUTN to be migrated does not specify a metamodel. Use suggestMigration/1 instead.");
		}
		
		return suggestMigration(EPackage.Registry.INSTANCE.getEPackage(slotModel.getNsUris().get(0).getValue()));
	}
	
	public Spec suggestMigration(EPackage metamodel) {
		initialseSlotModelWith(metamodel);
		return new Migrator(slotModel).suggestMigration(metamodel);
	}
	
	// TODO: Refactor to method on Spec?
	public String toHutn(Spec spec) {
		return new HutnGenerator(spec).generate();
	}
	
	private void initialseSlotModelWith(EPackage metamodel) {
		if (!slotModel.getObjects().isEmpty()) {
			for (PackageObject packageObject : slotModel.getObjects()) {
				if (packageObject.getMetamodel().isEmpty()) {
					packageObject.getMetamodel().add(metamodel);
				}
			}
		}
	}
}