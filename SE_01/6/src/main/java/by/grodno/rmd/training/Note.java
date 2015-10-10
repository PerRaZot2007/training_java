package by.grodno.rmd.training;

/**
 * Class for note.
 * @author rakickijMD * 
 */
public class Note {
	private String note;
		
	/**
	 * Constructor
	 */
	public Note(){
		this.note = null;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return note;
	}

	/**
	 * Get current value of note
	 * @return value of note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * Set new value to note
	 * @param str - value
	 */
	public void setNote(String str) {
		this.note = str;
	}
		
}
