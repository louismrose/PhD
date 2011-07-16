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

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import project.MigrationStrategy;

public class WordCounter {

	private final Collection<String> wordsInCode;
	
	public WordCounter(MigrationStrategy strategy) {
		this.wordsInCode = getWordsIn(strategy.code);
	}

	private static List<String> getWordsIn(String text) {
		if (text.trim().length() == 0)
			return Collections.emptyList();
		
		return Arrays.asList(text.trim().split(atLeastOneWhitespaceChar() + or() +
		                                      fullstop()                  + or() + 
		                                      "!"                         + or() + 
		                                      parenthesisChars()          + or() +
		                                      ","                         + or() +
		                                      "#"                         + or() +
		                                      ";"));
	}

	private static String atLeastOneWhitespaceChar() {
		return "\\s+";
	}
	
	private static String fullstop() {
		return "\\.";
	}

	private static String parenthesisChars() {
		return "\\(" + or() + "\\)";
	}

	private static String or() {
		return "|";
	}
	
	
	public int countWords() {
		return wordsInCode.size();
	}

	public int countOccurencesOf(Collection<String> words) {
		int occurences = 0;
		
		for (String wordInCode : wordsInCode) {
			if (words.contains(wordInCode)) {
				occurences++;
			}
		}
		
		return occurences;
	}
}
