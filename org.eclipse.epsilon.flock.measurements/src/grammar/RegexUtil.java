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
package grammar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class RegexUtil {

	private RegexUtil() {}

	public static String escape(String regex) {
		return regex.replaceAll("\\(", "\\\\(").replaceAll("\\)", "\\\\)").replaceAll("\\.", "\\\\.");
	}
	
	public static String anything() {
		return ".*";
	}
	
	public static int getNumberOfMatchesIn(String text, String regex) {
		return getNumberOfMatchesIn(text, Pattern.compile(regex));
	}
	
	public static int getNumberOfMatchesIn(String text, Pattern regex) {		
		int matches = 0;
		
		final Matcher matcher = regex.matcher(text);
		
		while (matcher.find()) {
			matches++;
		}
				
		return matches;
	}
}
