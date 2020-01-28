package ua.nure.ageev.practice4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
	public static final String DOUBLE = "(\\d+\\.\\d*)|(\\.\\d+)";
	public static final String STRING = "\\p{L}{2,}";
	public static final String INT = "(?<![\\.\\d])\\d+(?![\\.\\d])";
	public static final String CHAR = "\\b\\p{L}{1}\\b";
	public static final String FILE_PATH = "part3.txt";
	public static final String ENCODING = "Cp1251";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String temp = sc.nextLine();
			if ("stop".equals(temp)) {
				break;
			} else {
				System.out.println(selector(temp));
			}
		}
		sc.close();
	}

	public static String selector(String str) {

		switch (str) {
		case "String":
			return selectorHelper(STRING);
		case "int":
			return selectorHelper(INT);
		case "double":
			return selectorHelper(DOUBLE);
		case "char":
			return selectorHelper(CHAR);
		default:
			return "Incorrect input";
		}
	}

	public static String selectorHelper(String regEx) {
		StringBuilder sb = new StringBuilder();
		Pattern patter = Pattern.compile(regEx);
		Matcher m = patter.matcher(Utils.readTextFromFile(FILE_PATH, ENCODING));
		while (m.find()) {
			sb.append(m.group() + " ");
		}
		if (sb.length() == 0) {
			sb.append("No such values");
		}
		return sb.toString();
	}
}
