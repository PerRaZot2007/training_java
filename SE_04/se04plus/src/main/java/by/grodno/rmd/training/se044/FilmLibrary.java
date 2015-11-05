package by.grodno.rmd.training.se044;


import java.io.Serializable;
import java.util.ArrayList;

public class FilmLibrary implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7940963565217418799L;
	private ArrayList<Film> filmList =  new ArrayList<Film>();
	
	public void addFilm(Film filmInLibrary) {
		filmList.add(filmInLibrary);
	}
	
	public void removeFilm(int filmId) {
		try {
			filmList.remove(filmId);
		}
		catch (IndexOutOfBoundsException e){
			System.out.println("Wrong-id");
		}
	}
	
	public void showAllFilms(){
		if(!filmList.isEmpty()) {
			for (Film film : filmList) {
				System.out.println(film);
			}
		}
		else {
			System.err.println("No films in library");
		}
	}
	
}
