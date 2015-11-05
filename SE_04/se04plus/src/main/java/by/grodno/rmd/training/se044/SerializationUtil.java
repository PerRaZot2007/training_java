package by.grodno.rmd.training.se044;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationUtil {

	private static final String serializePath = "datafile.out";

	public static void serializeFilmLibrary(FilmLibrary fL) {
		try (ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(serializePath))) {
			objectOutput.writeObject(fL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static FilmLibrary deserializeFilmLibrary() throws ClassNotFoundException, IOException {
		ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(serializePath));
		FilmLibrary fl = (FilmLibrary) objectIn.readObject();
		objectIn.close();
		return fl;
	}
}
