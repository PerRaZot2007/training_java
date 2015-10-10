package by.grodno.rmd.training;

import static by.grodno.rmd.training.SubClass.equalsToNull;

/**
 * Class for NoteBook. Contains function to edit consistency of noteBook.
 * @author rakickijMD
 *
 */
public class NoteBook {
	
	
	private int k = 0;
	private boolean end;
	
	/**
	 * Function for showing all notes from array.
	 * @param strArray - array with notes.
	 */
	public void showAllNotes(Note[] strArray){
		for(int i=0;i<strArray.length;i++){
			System.out.println(strArray[i]);
		}
	}
	
 	/**
 	 * Function for adding new notes.
 	 * @param strArray - array with notes.
 	 * @param str - note, which will be added to array.
 	 * @return array of notes with new one.
 	 */
 	public Note[] addNote(Note[] strArray, String str) {
		
 		end = false;	//add new note in notebook
		while(!end){
			if(equalsToNull(strArray[k].toString())) {
				strArray[k].setNote(str);
				k = 0;
				end = true;				
			}
			else {
				k++;
			}
		}
		return strArray;
	}

	/**
	 * Function for removing notes from array by id.
	 * @param strArray - array of notes.
	 * @param id - number of note, which will be deleted from array.
	 * @return array without deleted note (note replaced by null).
	 */
	public Note[] deleteNote(Note[] strArray, int id){ 
		strArray[id].setNote(null);	//delete note from notebook by number
		return strArray;
	}
	
	/**
	 * Function for removing notes from array by literal value.
	 * @param strArray - array of notes.
	 * @param str - literal value of note, which will be deleted from array.
	 * @param repeat - flag of multiple remove. If value of flag is true, then all notes with equal value to "str" will be deleted.
	 * If value of flag is false, then first seen note with equal value to "str" will be deleted.
	 * @return array without deleted note(s) (note(s) replaced by null).
	 */
	public Note[] deleteNote(Note[] strArray, String str, boolean repeat){
		if(repeat) { //delete note(s) from notebook by string
			while(k < strArray.length) { 
				if(!equalsToNull(strArray[k].toString())) {
					if(strArray[k].toString().equals(str)) {
					strArray[k].setNote(null);
					}
					k++;
				}
				else {
					k++;
				}
			}
			k =0;
		}
		else {
			end = false;	
			while(!end){
				if(!equalsToNull(strArray[k].toString())) {
					if(strArray[k].toString().equals(str)) {
						strArray[k].setNote(null);
						k = 0;
						end = true;				
					}
					else {
						k++;
						if(k>=strArray.length){
							end = true;
							k=0;
						}
					}
				}
				else {
					k++;
					if(k>=strArray.length){
						end = true;
						k=0;
					}
				}
			}
		}
		return strArray;
	}
	
	/**
	 * Function for replacing notes from array by id.
	 * @param strArray -  array of notes.
	 * @param id - number of note, which will be replaced in array.
	 * @param newNote - new note.
	 * @return array with replaced note.
	 */
	public Note[] replaceNote(Note[] strArray, int id, String newNote) {
		strArray[id].setNote(newNote); //replace note by id
		return strArray;		
	}
	
	/**
	 * Function for replacing notes from array by literal value. 
	 * @param strArray - array of notes.
	 * @param currentNote - literal value of note, which will be replaced in array.
	 * @param newNote - new note.
	 * @param repeat - flag of multiple replace. If value of flag is true, then all notes with equal value to "current note" will be replaced
	 * on "newNote". If value of flag is false, then first seen note with equal value to "current note" will be replaced on
	 * "newNote"
	 * @return array with replaced note(s).
	 */
	public Note[] replaceNote(Note[] strArray, String currentNote, String newNote, boolean repeat){
		if(repeat) { 
			while(k < strArray.length) { 
				if(!equalsToNull(strArray[k].toString())){
					if(strArray[k].toString().equals(currentNote)) {
						strArray[k].setNote(newNote);
					}
					k++;
				}
				
				else {
					k++;
				}
			}
			k = 0;
		}
		else {
			end = false;	
			while(!end){
				if(!equalsToNull(strArray[k].toString())){
					if(strArray[k].toString().equals(currentNote)) {						
						strArray[k].setNote(newNote);
						k = 0;
						end = true;				
					}				
					else {
						k++;
						if(k>=strArray.length) {
							end = true;
							k=0;
						}
					}
				}
				else {
					k++;
					if(k>=strArray.length) {
						end = true;
						k=0;
					}
				}
			}
		}
		return strArray;
	}
	
	
}
