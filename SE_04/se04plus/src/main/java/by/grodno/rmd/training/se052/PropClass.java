package by.grodno.rmd.training.se052;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class PropClass {
	private Properties prop = new Properties();
	private final String defaultPath = "default_en.properties";
	private String propertiesPath;

	public PropClass(String propertiesPath) {

		try (BufferedReader propIn = new BufferedReader(new FileReader(propertiesPath))) {
			prop.load(propIn);
			this.propertiesPath = propertiesPath;
		} catch (FileNotFoundException e) {
			System.err.println("Properties file not found. Default properties loaded.");
			getDefaultProperties();
		} catch (IOException e) {
			System.err.println("Error.");
		}
	}
	
	public void addElement(String key, String value){
		prop.put(key, value);
	}

	public Set<String> getKeys() {
		return prop.stringPropertyNames();
	}

	public Collection<Object> getValues() {
		return prop.values();
	}

	public String getValue(String key) {
		if (!prop.containsKey(key)) {
			throw new IllegalArgumentException("Properties file not contains key = " + key);
		}
		return prop.getProperty(key);
	}

	public void saveToFile(){
		try(BufferedWriter propOut = new BufferedWriter(new FileWriter(propertiesPath))){
			prop.store(propOut, "");
		} catch (IOException e) {
			System.err.println("Error.");
		}
	}
	
	private void getDefaultProperties() {
		try (BufferedReader propIn = new BufferedReader(new FileReader(defaultPath))) {
			prop.load(propIn);
			propertiesPath = defaultPath;
		} catch (IOException e) {
			System.err.println("Error.");
		}
	}
	
	
}
