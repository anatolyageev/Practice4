package ua.nure.ageev.practice4;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

	public static final String LATIN = "\\w+";
	public static final String KIRILIC = "[À-ÿ¸¨ºª²³¯¿]+";
	public static final String FILE_PATH = "part6.txt";
	public static final String ENCODING = "Cp1251";

	public static void main(String[] args) {
		Scanner sc6 = new Scanner(System.in);
		while (sc6.hasNext()) {
			String temp = sc6.nextLine();
			if ("stop".equalsIgnoreCase(temp)) {
				break;
			} else {
				System.out.print(temp + ": ");
				System.out.println(selector6(temp.toLowerCase(Locale.getDefault())));
			}
		}
		sc6.close();
	}

	public static String selector6(String str) {
		switch (str) {
		case "cyrl":
			return selector6Helper(KIRILIC);
		case "latn":
			return selector6Helper(LATIN);
		default:
			return "Incorrect input";
		}
	}

	public static String selector6Helper(String regEx) {
		StringBuilder sb = new StringBuilder();
		Pattern patter = Pattern.compile(regEx);
		Matcher m = patter.matcher(Utils.readTextFromFile(FILE_PATH, ENCODING));
		while (m.find()) {
			sb.append(m.group() + " ");
		}
		return sb.toString();
	}

}
