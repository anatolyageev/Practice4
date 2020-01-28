package ua.nure.ageev.practice4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Utils {

	private Utils() {
		throw new IllegalStateException("Utility class");
	}

	public static String readTextFromFile(String pathFile, String encoding) {
		StringBuilder output = new StringBuilder();
		try (InputStreamReader br = new InputStreamReader(new FileInputStream(pathFile), encoding)) {
			int ch = br.read();
			while (ch != -1) {
				char tempChar = (char) ch;
				output.append(tempChar);
				ch = br.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output.toString();
	}

}
