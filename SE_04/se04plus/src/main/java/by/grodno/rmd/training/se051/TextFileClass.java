package by.grodno.rmd.training.se051;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.*;

public class TextFileClass {

	private File textFile;

	public void createFile(String filePath) {
		try {
			textFile = new File(filePath);
			if (!textFile.exists()) {
				FileUtils.write(textFile, "");
				System.out.println(filePath + " was created.");
			}
			else {
				System.err.println(filePath + " already exists.");
			}
		} catch (IOException e) {
			System.err.println("wrong name of file");
		}
	}

	/**
	 * @param filePath
	 * @param text
	 * @param reWrite
	 *            - if value is true, then file will be rewrited. If value is
	 *            false, then text will be added to end of file
	 */
	public void writeInFile(String filePath, String text, boolean reWrite) {
		try {
			textFile = new File(filePath);
			FileUtils.writeStringToFile(textFile, text, !reWrite);
		} catch (IOException e) {
			System.err.println("error");
		}
	}

	public void deleteTextFile(String filePath) {
		try {
			textFile = new File(filePath);
			if (FilenameUtils.getExtension(filePath).contentEquals("txt")) {
				FileUtils.forceDelete(textFile);
				System.out.println(filePath + " was deleted.");
			} else {
				System.err.println(filePath + " it't not a text file");
			}

		} catch (IOException e) {
			System.err.println("File not found");
		}
	}

}
