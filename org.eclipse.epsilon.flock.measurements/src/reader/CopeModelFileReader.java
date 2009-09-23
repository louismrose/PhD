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
package reader;

import java.io.File;

import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfModelFactory;
import org.eclipse.epsilon.emc.emf.EmfModelFactory.AccessMode;
import org.eclipse.epsilon.eol.EolEvaluator;

import edu.tum.cs.cope.history.HistoryPackage;

public class CopeModelFileReader implements IMigrationStrategyReader {

	private final EmfModel model;
	
	public CopeModelFileReader(File file) throws Exception {
		CopeHistoryModel.register();
		
		model = EmfModelFactory.getInstance().loadEmfModel("history", file, HistoryPackage.eINSTANCE, AccessMode.READ_ONLY);
	}

	public String readMigrationStrategy() {
		return getMigratePartFromCopeMigrationStrategy(getMigrationStrategyFromModel());
	}

	private String getMigrationStrategyFromModel() {
		return new EolEvaluator(model).evaluate("MigrationChange.all.first.migration").toString();
	}

	private String getMigratePartFromCopeMigrationStrategy(String migrationStrategy) {
		final StringBuilder migratePart = new StringBuilder();
		
		boolean inMigratePart = false;
		
		for (String line : getLines(migrationStrategy)) {
			if (line.isEmpty()) {
				inMigratePart = true;
			}
			
			if (inMigratePart) {
				migratePart.append(line);
				migratePart.append(FileReader.NEW_LINE);
			}
		}
		
		return migratePart.toString();
	}

	private static String[] getLines(String s) {
		return s.split("\r\n|\r|\n");
	}	
}
