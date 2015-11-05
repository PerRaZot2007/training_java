package by.grodno.rmd.training.se043;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class FileConvert {

	private StringBuilder fileText = new StringBuilder();

	public void getUTF8File(String filePath) {
		try (InputStreamReader streamIn = new InputStreamReader(new FileInputStream(filePath), "UTF-8")) {
			int i;
			while ((i = streamIn.read()) != -1) {
				fileText.append((char) i);
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setUTF16File(String filePath) {
		try (OutputStreamWriter streamOut = new OutputStreamWriter(
				new FileOutputStream(filePath, true), "UTF-16")) {
			streamOut.write(fileText.toString(), 0, fileText.toString().length());

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showUTF8FileText(){
		System.out.println(fileText);
	}

}
