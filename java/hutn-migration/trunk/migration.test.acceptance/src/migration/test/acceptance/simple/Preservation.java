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
package migration.test.acceptance.simple;

import migration.test.acceptance.AcceptanceTest;
import migration.test.dependencies.PortsMetamodel;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.junit.BeforeClass;
import org.junit.Test;

public class Preservation extends AcceptanceTest {
	
	@BeforeClass
	public static void registerPortsMetamodel() throws Exception {
		EmfUtil.register(PortsMetamodel.getMetaModelUri(), EPackage.Registry.INSTANCE);
	}
	
	@BeforeClass
	public static void setup() {
		metamodel = "Metamodel {"                          +
		            "  EPackage \"Metamodel\" {"           +
		            "    eClassifiers: EClass \"Port\" {}" +
		            "  }"                                  +
		            "}";
		
		slotModel = "@Spec {" +
		            "  metamodel \"ports\" {"       +
		            "    nsUri: \"ports\""          +
		            "  }"                           +
		            "}"                             +
		            ""                              +
		            "ports {"                       +
		            "  Signature \"s\" {}"          +
		            "}";
		
		acceptanceTest();
		
		migratedModel.setVariable("spec", "Spec.all.first");
	}

	@Test
	public void migratedModelHasSameNumberOfNsUris() {
		migratedModel.assertEquals(1, "spec.nsUris.size");
	}
	
	@Test
	public void migratedModelHasSameNsUriValue() {
		migratedModel.assertEquals("ports", "spec.nsUris.first.value");
	}
	
	@Test
	public void migratedModelHasSameNumberOfPackages() {
		migratedModel.assertEquals(1, "spec.objects.size");
	}
	
	@Test
	public void migratedModelHasSamePackageObjectName() {
		migratedModel.assertEquals("ports", "spec.objects.first.type");
	}
}