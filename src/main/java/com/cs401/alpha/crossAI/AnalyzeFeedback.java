package com.cs401.alpha.crossAI;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AnalyzeFeedback {

	int TotalPositiveCount = 0;
	int TotalNegativeCount = 0;
	int TotalNeutralCount = 0;

	public static void analyze(FeedbackRepository feedbackRepository) {
		System.out.println("inside analayze");
		List<Feedback> listfeedback = null;
		try {
			listfeedback = feedbackRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		int tempid = 0;
		String tempfeedback = null;
		String tempscore = null;
		boolean flag = true; // true: analyze feedback, false: it has been done already
		for (Feedback f : listfeedback) {

			tempid = f.getId();
			tempfeedback = f.getFeedback();
			tempscore = f.getScore();

			try {
				if (tempfeedback.equalsIgnoreCase("Feedbakc was empty, or no feedback was provided")
						&& tempscore.equalsIgnoreCase("0")) {
					flag = false; // this suggests that the feedback was already calculated.
				}

				else if (tempfeedback.equalsIgnoreCase("Feedbakc was empty, or no feedback was provided")) {
					continue;
				}
			} catch (Exception e) {
				System.out.println("feedback or score is empty");
				flag = false;
			}

			if (flag) {

				tempscore = calculate(tempfeedback);

				String myUrl = "jdbc:mysql://localhost:3306/alphadb";
				Connection conn = null;
				try {
					conn = DriverManager.getConnection(myUrl, "root", "root");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				String updatefeedbackquery = "update alphadb.feedback set score =" + "\"" + tempscore + "\""
						+ " where id =" + tempid;

				System.out.println(updatefeedbackquery);
				Statement st = null;

				try {
					st = conn.createStatement();
				} catch (SQLException e) {
					e.printStackTrace();
				}

				try {
					st.execute(updatefeedbackquery);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static String calculate(String tempfeedback) {
		System.out.println("inside calculate");

		List<String> positivedata = new ArrayList<String>();
		List<String> negativedata = new ArrayList<String>();

		int feedscore = 0;

		String filenameincpositive = "positivewords.txt";
		String filenameincnegative = "negativewords.txt";

		try {
			positivedata = readFile(filenameincpositive);
		} catch (Exception e) {
			System.out.println("file not found");
		}

		try {
			negativedata = readFile(filenameincnegative);
		} catch (Exception e) {
			System.out.println("file not found");
		}

		String[] ls = null;
		ls = tempfeedback.split(" ");

		for (int i = 0; i < ls.length; i++) {
			System.out.println(ls[i]);
			if (positivedata.contains(ls[i])) {
				System.out.println("Positive word match: Score increased");
				feedscore++;
			}

			if (negativedata.contains(ls[i])) {
				System.out.println("Negative word match: Score decreased");
				feedscore--;
			}
		}

		System.out.println("feedback score :" + feedscore);
		feedscore = 0;

		System.out.println("exiting  calculate");

		if (feedscore < 0)
			return "Negative";
		else
			return "Positive";
	}

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
