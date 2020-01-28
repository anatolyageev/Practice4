package ua.nure.ageev.practice4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 implements Iterable<String> {
	public static final String REG_EX = "\\p{javaUpperCase}.*?[\\n\\r]*?.*?[\\n\\r]*?.*?\\.";
	public static final String ENCODING = "Cp1251";
	private String filePath;
	private String sourseString;
	private Pattern pattern;
	private Matcher matcher;

	public Part4(String filePath) {
		this.filePath = filePath;
		this.sourseString = Utils.readTextFromFile(filePath, ENCODING);
		this.pattern = Pattern.compile(REG_EX);
		this.matcher = pattern.matcher(sourseString);
	}

	public static void main(String[] args) {
		Part4 p4 = new Part4("part4.txt");
		for (String string : p4) {
			System.out.println(string);
		}
	}

	public String getFilePath() {
		return filePath;
	}

	public Matcher getMatcher() {
		return matcher;
	}

	@Override
	public Iterator<String> iterator() {
		return new Part4Iterator(getMatcher());
	}

	private static class Part4Iterator implements Iterator<String> {
		private Matcher matcherI;

		Part4Iterator(Matcher matcher) {
			this.matcherI = matcher;
		}

		@Override
		public boolean hasNext() {
			return matcherI.find();
		}

		@Override
		public String next() {
			try {
				return matcherI.group().replaceAll("[\\n\\r]", "");
			} catch (NoSuchElementException e) {
				throw new NoSuchElementException();
			}

		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("remove");
		}

	}

}
