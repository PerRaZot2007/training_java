package by.grodno.rmd.training.se062;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import org.apache.commons.io.FileUtils;

public class HashMapProp {

	
	private HashMap<String, String> proprtiesMap = new HashMap<String, String>();
	private ArrayList<String> fileLines = new ArrayList<String>();
	
	public HashMapProp(String propPath) {
		try {
			fileLines = (ArrayList<String>) FileUtils.readLines(new File(propPath));
		} catch (IOException e) {
			System.err.println("null line.");
		}
		for(String s : fileLines) {
			proprtiesMap.put(s.split("=")[0], s.split("=")[1]);
		}
	}
	
	public String getEntry(){
		return proprtiesMap.entrySet().toString();
	}
	
	public Collection<String> getValues(){
		return proprtiesMap.values();
	}
	
	public Set<String> getKeys(){
		return proprtiesMap.keySet();
	}
}
