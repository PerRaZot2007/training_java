package by.grodno.rmd.training.se051;

public class TestFS {
	public static void main(String[] args){
		FileSystemClass fs =  new FileSystemClass();
		TextFileClass txt =  new TextFileClass();
		
		
		fs.showFilesAndSubDir("d:\\FL123");

		fs.showFilesAndSubDir("d:\\FL");
		
		fs.showFiles("d:\\334556");
		
		fs.showFiles("c:\\");
		
		txt.deleteTextFile("c:\\123.txt");
		
		txt.writeInFile("c:\\1234.txt", "another one new text add again", true);
		
		txt.createFile("c:\\text.txt");
	}
}
