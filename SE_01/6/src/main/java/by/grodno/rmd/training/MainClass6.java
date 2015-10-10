package by.grodno.rmd.training;

/**
 * test class for classes Note.class and NoteBook.class
 * @author rakickijMD
 */
public class MainClass6 {

	public static void main(String[] args) {
		
		NoteBook nB = new NoteBook();		
		
		Note[] str = new Note[5];
		for(int i = 0; i<str.length;i++)
		{
			str[i] = new Note();
		}
		
		str[0].setNote("first in");
		str[1].setNote("second in");
		str[2].setNote("third in");
		str[3].setNote("third in");
		
		
		nB.deleteNote(str, 1);
		nB.replaceNote(str, 0, "replaced first");
		nB.replaceNote(str, "third in", "replaced second", false);
		nB.deleteNote(str, "third in", false);
		nB.addNote(str, "new one Note");
		nB.showAllNotes(str);		
	}

}
