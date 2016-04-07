package viraj.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIO {
	public static void readFromFile(String fileName) {
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("File Not found");
		}
	}

	public static void writeToFile(String fileName) {
		boolean overwriteFile = false;
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileOutputStream(fileName, overwriteFile));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

	}
}
