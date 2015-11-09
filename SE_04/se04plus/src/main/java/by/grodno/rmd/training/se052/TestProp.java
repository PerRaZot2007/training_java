package by.grodno.rmd.training.se052;

public class TestProp {

	public static void main(String[] args) {
		PropClass pC = new PropClass("d:\\defa23ult.properties");		
		
		String s = pC.getValue("defautKey5");
		System.out.println(s);

		pC.addElement("newkey1", "newValue1");
		System.out.println(pC.getKeys());
		System.out.println(pC.getValues());
		
		pC.saveToFile();
		
		s = pC.getValue("wrongKey");
	}

}
