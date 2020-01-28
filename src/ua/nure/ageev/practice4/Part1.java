package ua.nure.ageev.practice4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
	public static final String REG_EX = "\\b\\p{L}{4,}\\b";
	public static final String FILE_NAME = "part1.txt";
	public static final String ENCODING = "Cp1251";

	public static void main(String[] args) {
		File file = new File(FILE_NAME);
		System.out.println(converter(readFile(file)));
	}

	public static String converter(String input) {
		StringBuffer sb = new StringBuffer();
		Pattern pattern = Pattern.compile(REG_EX);
		Matcher m = pattern.matcher(input);
		while (m.find()) {
			m.appendReplacement(sb, converterHelper(m.group()));
		}
		m.appendTail(sb);
		return sb.toString();
	}

	public static String converterHelper(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (Character.isUpperCase(str.charAt(i))) {
				sb.append(Character.toLowerCase(str.charAt(i)));
			} else {
				sb.append(Character.toUpperCase(str.charAt(i)));
			}
		}
		return sb.toString();
	}

	public static String readFile(File file) {
		StringBuilder result = new StringBuilder();
		try (InputStreamReader br = new InputStreamReader(new FileInputStream(file), ENCODING)) {
			int ch = br.read();
			while (ch != -1) {
				char tempChar = (char) ch;
				result.append(tempChar);
				ch = br.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result.toString();
	}
}
