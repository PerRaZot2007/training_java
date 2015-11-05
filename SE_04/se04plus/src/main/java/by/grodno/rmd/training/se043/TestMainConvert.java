package by.grodno.rmd.training.se043;


public class TestMainConvert {

	public static void main(String[] args) {
		FileConvert fC = new FileConvert();
		
		fC.getUTF8File("d:\\testUni.txt");
		
		fC.showUTF8FileText();
		
		fC.setUTF16File("d:\\testUni16.txt");
		
	}
	
}
