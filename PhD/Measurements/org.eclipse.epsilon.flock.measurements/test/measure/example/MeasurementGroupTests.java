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
package measure.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import measurement.Count;

public class MeasurementGroupTests {

	@Test
	public void addTwoMeasurementGroups() {
		final MeasurementGroup augend = new MeasurementGroup();
		augend.add("Java", new Count(1));
		
		final MeasurementGroup addend = new MeasurementGroup();
		addend.add("Java", new Count(2));
		
		
		assertEquals(new Count(3), augend.add(addend).getMeasurementFor("Java"));
	}
	
	@Test
	public void addTwoUnevenMeasurementGroups() {
		final MeasurementGroup augend = new MeasurementGroup();
		augend.add("ETL", new Count(1));
		augend.add("Java", new Count(2));
		
		final MeasurementGroup addend = new MeasurementGroup();
		addend.add("Java", new Count(3));
		addend.add("Flock", new Count(4));
		
		assertEquals(new Count(1), augend.add(addend).getMeasurementFor("ETL"));		
		assertEquals(new Count(5), augend.add(addend).getMeasurementFor("Java"));
		assertEquals(new Count(4), augend.add(addend).getMeasurementFor("Flock"));
	}
}
