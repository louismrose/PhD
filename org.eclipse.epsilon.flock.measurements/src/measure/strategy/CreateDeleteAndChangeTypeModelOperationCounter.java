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
package measure.strategy;

import measurement.Count;
import measurement.Measurement;
import project.MigrationStrategy;

public class CreateDeleteAndChangeTypeModelOperationCounter implements MigrationStrategyMeasure {

	public Measurement measure(MigrationStrategy strategy) {
		return new Count(strategy.grammar.countNewDeleteAndChangeTypeOperationsIn(strategy.code));		
	}
}
