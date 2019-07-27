package com.cs401.alpha.crossAI;

import java.io.*;
import java.util.*;
public class driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// PATH WILL NEED TO BE CHANGED DEPENDING OF THE COMPUTER RUNNING THE PROGRAM
		// <---------------

		String filenameincdata = "C:\\Users\\raoni\\eclipse-workspace\\Feedback_Analyzer\\src\\feedback.txt";
		String filenameincnegative = "C:\\Users\\raoni\\eclipse-workspace\\Feedback_Analyzer\\src\\negativewords.txt";
		String filenameincpositive = "C:\\Users\\raoni\\eclipse-workspace\\Feedback_Analyzer\\src\\positivewords.txt";
		List<String> feedback = new ArrayList<String>();
		List<String> positivedata = new ArrayList<String>();
		List<String> negativedata = new ArrayList<String>();
		List<String> analyzesResult = new ArrayList<String>();

		// the input will be coming in from a source table

		// method readFile opens a source file with a bank of words
		feedback = readFile(filenameincdata); // it will be populated with income data from feedback
		positivedata = readFile(filenameincpositive);
		negativedata = readFile(filenameincnegative);

		// preparing variables to receive data from table

		List<Integer> userID = new ArrayList<Integer>();
		List<String> datetime = new ArrayList<String>();

		// Setting data into Feedback_Analyzer class
		Feedback_Analyzer.setfbdata(feedback);
		Feedback_Analyzer.setpositivedata(positivedata);
		Feedback_Analyzer.setnegativedata(negativedata);

		// Analyze's Result:
		analyzesResult = Feedback_Analyzer.feedback();
		System.out.println("Feedback score: " + analyzesResult);

	}

	// methods here
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
