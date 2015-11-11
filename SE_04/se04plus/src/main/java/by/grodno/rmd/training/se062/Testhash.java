package by.grodno.rmd.training.se062;

public class Testhash {
	public static void main(String[] args) {
		HashMapProp hm = new HashMapProp("default_en.properties");
		
		System.out.println(hm.getEntry());
		
		System.out.println(hm.getKeys());
		
		System.out.println(hm.getValues());
	}
}
