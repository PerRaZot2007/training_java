package by.grodno.rmd.training.se044;

import java.io.Serializable;

public class Acter implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6239335809317165429L;
	private String firstName;
	private String surName;
	
	public Acter(String firstName, String surName){
		this.firstName = firstName;
		this.surName = surName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String newFirstName) {
		firstName = newFirstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String newSurName) {
		surName = newSurName;
	}
}
