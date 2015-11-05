package by.grodno.rmd.training.se044;

import java.io.IOException;

import static by.grodno.rmd.training.se044.SerializationUtil.serializeFilmLibrary;
import static by.grodno.rmd.training.se044.SerializationUtil.deserializeFilmLibrary;

public class TestMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Film f1 =  new Film("Default city");
		Film f2 =  new Film("Default city2");
		
		Acter a1 = new Acter("No", "Name");
		f1.addActer(a1);
		f2.addActer(a1);
		FilmLibrary fL = new FilmLibrary();
		fL.addFilm(f1);
		
		serializeFilmLibrary(fL);
		
		FilmLibrary fl1 = deserializeFilmLibrary();
		
		fL.addFilm(f2);		
		
		System.out.println("Desirialized FilmLibrary");
		fl1.showAllFilms();
		
		System.out.println("Notserialized FilmLibrary with new one");
		fL.showAllFilms();
		
		System.out.println("Desirialized FilmLibrary");
		serializeFilmLibrary(fL);
		fl1 = deserializeFilmLibrary();
		fl1.showAllFilms();
	}

}
