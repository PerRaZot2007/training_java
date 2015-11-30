package com.rakickij.web.dataaccess.model;

import java.sql.Date;

public class CarDriver {
	private Long id;
	private String firstName;
	private String secondName;
	private Long tripCount;
	//private Long currentCash; перенести в новую таблицу (будут айдишки водителей и их счета) создать AutoBaseFund 
	private Date workStart;

	public Date getWorkStart() {
		return workStart;
	}

	public void setWorkStart(Date workStart) {
		this.workStart = workStart;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public Long getTripCount() {
		return tripCount;
	}

	public void setTripCount(Long tripCount) {
		this.tripCount = tripCount;
	}

	@Override
	public String toString() {
		return "CarDriver [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", tripCount="
				+ tripCount + ", workStart=" + workStart + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((secondName == null) ? 0 : secondName.hashCode());
		result = prime * result + ((tripCount == null) ? 0 : tripCount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarDriver other = (CarDriver) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (secondName == null) {
			if (other.secondName != null)
				return false;
		} else if (!secondName.equals(other.secondName))
			return false;
		if (tripCount == null) {
			if (other.tripCount != null)
				return false;
		} else if (!tripCount.equals(other.tripCount))
			return false;
		return true;
	}
	
	
}
