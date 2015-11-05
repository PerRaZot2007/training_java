package by.grodno.rmd.training.se044;

import java.io.Serializable;
import java.util.ArrayList;

public class Film implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1319954922148266840L;
	private ArrayList<Acter> actersList = new ArrayList<Acter>();
	private String title;

	public Film(String title) {
		this.title = title;
	}
	
	public void addActer(Acter acterInFilm){
		actersList.add(acterInFilm);
	}
	
	public void removeActer(int acterId){
		try {
			actersList.remove(acterId);
		}
		catch (IndexOutOfBoundsException e) {
			System.err.println("Wrong-id");
		}
	}
	
	public void showAllActers(){
		if(!actersList.isEmpty()){
			for (Acter acter : actersList) {
				System.out.println(acter);
			}
		}
		else {
			System.out.println("No acters in film");
		}
	}
	
	public String getTitle(){
		return title;
	}
	
	@Override
	public String toString(){
		return title;
	}

}
