package ua.nure.ageev.practice4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Scanner;

public class Part2 {
	public static final String FILE_PATH = "part2.txt";
	public static final String FILE_PATH_DIST = "part2_sorted.txt";
	public static final String ENCODING = "Cp1251";
	public static final int DIGIT_SUM = 10;
	public static final int MAX_NUM_RAND = 50;

	public static void main(String[] args) {
		genarateNumbersToFile(DIGIT_SUM);
		System.out.println();
		readeNumbersFromFile(DIGIT_SUM);
		System.out.println();
	}

	public static void genarateNumbersToFile(int size) {
		SecureRandom random = new SecureRandom();
		try (PrintWriter bw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(FILE_PATH), ENCODING))) {
			System.out.print("input ==> ");
			for (int i = 0; i < size; i++) {
				int temp = random.nextInt(MAX_NUM_RAND);
				bw.write(String.valueOf(temp) + " ");
				System.out.print(temp + " ");
			}
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			System.out.println(e);
		}
	}

	public static void readeNumbersFromFile(int size) {
		int[] arr = new int[size];
		try (Scanner sc = new Scanner(new InputStreamReader(new FileInputStream(FILE_PATH), ENCODING));
				PrintWriter bw = new PrintWriter(
						new OutputStreamWriter(new FileOutputStream(FILE_PATH_DIST), ENCODING))) {
			int i = 0;
			while (sc.hasNextInt()) {
				arr[i] = sc.nextInt();
				i++;
			}
			insertionSort(arr);
			System.out.print("output  ==> ");
			for (int j = 0; j < arr.length; j++) {
				bw.print(arr[j] + " ");
				System.out.print(arr[j] + " ");
			}
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			System.out.println(e);
		}
	}

	public static void insertionSort(int[] a) {
		int in;
		int out;
		int nElems = a.length;
		for (out = 1; out < nElems; out++) {
			int temp = a[out];
			in = out;
			while (in > 0 && a[in - 1] >= temp) {
				a[in] = a[in - 1];
				--in;
			}
			a[in] = temp;
		}
	}

}
