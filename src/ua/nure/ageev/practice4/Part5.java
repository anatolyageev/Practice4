package ua.nure.ageev.practice4;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part5 {
	public static final String REG_EX = "(\\w+) (\\w{2,})";
	public static final String ENCODING = "Cp1251";
	public static final String BASE_NAME = "resources";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Pattern pattern = Pattern.compile(REG_EX);
		Matcher matcher;
		while (true) {
			String t = sc.nextLine();
			if ("stop".equals(t)) {
				break;
			} else {
				try {
					matcher = pattern.matcher(t);
					matcher.find();
					System.out.println(getWordByKey(matcher.group(1), matcher.group(2)));
				} catch (IllegalStateException e) {
					System.out.println("No such values");
				}
			}
		}
		sc.close();
	}

	public static String getWordByKey(String key, String leng) {
		ResourceBundle resBundle = ResourceBundle.getBundle(BASE_NAME, new Locale(leng));
		return resBundle.getString(key);
	}

}
