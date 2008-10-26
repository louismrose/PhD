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
package migration.test.acceptance;

import migration.MigrationModule;
import migration.test.acceptance.util.ModelConstructor;

import org.eclipse.epsilon.hutn.model.hutn.HutnPackage;
import org.eclipse.epsilon.hutn.model.hutn.Spec;
import org.eclipse.epsilon.test.util.ModelWithEolAssertions;

public abstract class AcceptanceTest {

	protected static String metamodel;
	protected static String slotModel;

	protected static ModelWithEolAssertions migratedModel;

	public static void acceptanceTest() {
		final Spec migrated = new MigrationModule(slotModel).suggestMigration(ModelConstructor.constructMetaModel(metamodel));
		
		migratedModel = new ModelWithEolAssertions(migrated, HutnPackage.eINSTANCE);
	}

}
