package com.cs401.alpha.crossAI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Feedback_Analyzer {
	private static List<String> fbdata = new ArrayList<String>();
	private static List<String> positivewords = new ArrayList<String>();
	private static List<String> negativewords = new ArrayList<String>();

	public static void setfbdata(List<String> inclist) {
		fbdata = inclist;

	}

	public static void setpositivedata(List<String> incpositivedata) {
		positivewords = incpositivedata;

	}

	public static void setnegativedata(List<String> incnegativedata) {
		negativewords = incnegativedata;

	}

	// search line by line and separate words for positive or negative words in
	// feedback
	public static List<String> feedback() {
		List<String> feedbackResult = new ArrayList<String>();
		List<String> wordsinsentence = new ArrayList<String>();
		String aword;
		int feedscore = 0;

		int i = 0;

		// Testing received feedbackdata
		// System.out.println(fbdata);
		// System.out.println(fbdata.size());

		while (i < fbdata.size()) {
			int j = 0;

			wordsinsentence = split(fbdata.get(i));
			System.out.println("Analyzing now sentence: ");
			System.out.println(fbdata.get(i));

			// System.out.println(fbdata.size());

			while (j < wordsinsentence.size()) {

				aword = wordsinsentence.get(j);

				// Removing all punctuation and setting words to lower case
				aword = aword.replaceAll("\\p{IsPunctuation}", "");
				aword = aword.toLowerCase();

				System.out.println("Analyzing now word: " + aword);
				// checking for negative words
				if (negativewords.contains(aword)) {
					System.out.println("Negative word match: Score decreased");
					feedscore--;
				}

				// checking for positive words
				if (positivewords.contains(aword)) {
					System.out.println("Positive word match: Score increased");
					feedscore++;
				}

				/*
				 * switch(aword) {
				 * 
				 * case "nice": System.out.println("feedback increased =+1"); feedpoints =
				 * feedpoints + 1; break;
				 * 
				 * case "good": System.out.println("feedback increased +2"); feedpoints =
				 * feedpoints + 2; break;
				 * 
				 * case "amazing": System.out.println("feedback increased +5"); feedpoints =
				 * feedpoints + 5; break;
				 * 
				 * case "sucks": System.out.println("feedback decreased -2"); feedpoints =
				 * feedpoints - 2; break; default: break;
				 * 
				 * //conditions for negative words
				 * 
				 * //conditions for odd word combinations }
				 */

				j++;
			}

			// Analyze's Result:

			if (feedscore == 0) {
				feedbackResult.add("Neutral");
				System.out.println("User Feedback result: " + feedbackResult.get(i));
			}

			if (feedscore > 0) {
				feedbackResult.add("Positve");
				System.out.println("User Feedback result: " + feedbackResult.get(i));
			}

			if (feedscore < 0) {
				feedbackResult.add("Negative");
				System.out.println("User Feedback result: " + feedbackResult.get(i));
			}

			feedscore = 0;
			System.out.println("\n");
			i++;

		}

		return feedbackResult;
	}

	// methods here
	public static List<String> split(String str) {
		return Stream.of(str.split(" ")).map(elem -> new String(elem)).collect(Collectors.toList());
	}

	/**
	 * Open and read a file, and return the lines in the file as a list of Strings.
	 * (Demonstrates Java FileReader, BufferedReader, and Java5.)
	 */
	public static List<String> readFile(String filename) {
		List<String> records = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = reader.readLine()) != null) {
				records.add(line);
			}
			reader.close();
			return records;
		} catch (Exception e) {
			System.err.format("Exception occurred trying to read '%s'.", filename);
			e.printStackTrace();
			return null;
		}
	}

}
