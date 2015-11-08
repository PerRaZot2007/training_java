package by.grodno.rmd.training.se051;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;

public class FileSystemClass {

	private List<File> filesList;
	private File file;

	public void showFilesAndSubDir(String catalogPath) {
		try {
			file = new File(catalogPath);
			File[] files = file.listFiles();
			for (File f : files) {
				if (f.isDirectory()) {
					System.out.println("subDirectory: " + file.getCanonicalPath());
				}
			}
			for (File file : files) {
				if (file.isFile()) {
					System.out.println("file: " + file.getCanonicalPath());
				}
			}
		} catch (NullPointerException e) {
			System.err.println("Directory not found");
		} catch (IOException e) {
			System.err.println("Error");
		}
	}

	public void showFiles(String catalogPath) {
		try {
			file = new File(catalogPath);
			filesList = (List<File>) FileUtils.listFiles(file, FileFilterUtils.fileFileFilter(), null);
			for (File f : filesList) {
				System.out.println("file " + f);
			}
			filesList.clear();
		} catch (IllegalArgumentException e) {
			System.err.println("Directory not found");
		}
	}

	public void deleteFileOrDirectory(String path) {
		try {
			file = new File(path);
			FileUtils.forceDelete(file);
			System.out.println(path + " was deleted.");

		} catch (IOException e) {
			System.err.println("File not found");
		}
	}
}
