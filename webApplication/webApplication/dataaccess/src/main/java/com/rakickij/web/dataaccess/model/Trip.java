package com.rakickij.web.dataaccess.model;

import java.sql.Date;

public class Trip {
	private Long id;
	private Long driverId;
	private Long carId;
	private Date departureDate;
	private Date arrivalDate;
	private Long departureCityId;
	private Long arrivalCityId;

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public Long getDepartureCityId() {
		return departureCityId;
	}

	public void setDepartureCityId(Long departureCityId) {
		this.departureCityId = departureCityId;
	}

	public Long getArrivalCityId() {
		return arrivalCityId;
	}

	public void setArrivalCityId(Long arrivalCityId) {
		this.arrivalCityId = arrivalCityId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivalCityId == null) ? 0 : arrivalCityId.hashCode());
		result = prime * result + ((arrivalDate == null) ? 0 : arrivalDate.hashCode());
		result = prime * result + ((carId == null) ? 0 : carId.hashCode());
		result = prime * result + ((departureCityId == null) ? 0 : departureCityId.hashCode());
		result = prime * result + ((departureDate == null) ? 0 : departureDate.hashCode());
		result = prime * result + ((driverId == null) ? 0 : driverId.hashCode());
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
		Trip other = (Trip) obj;
		if (arrivalCityId == null) {
			if (other.arrivalCityId != null)
				return false;
		} else if (!arrivalCityId.equals(other.arrivalCityId))
			return false;
		if (arrivalDate == null) {
			if (other.arrivalDate != null)
				return false;
		} else if (!arrivalDate.equals(other.arrivalDate))
			return false;
		if (carId == null) {
			if (other.carId != null)
				return false;
		} else if (!carId.equals(other.carId))
			return false;
		if (departureCityId == null) {
			if (other.departureCityId != null)
				return false;
		} else if (!departureCityId.equals(other.departureCityId))
			return false;
		if (departureDate == null) {
			if (other.departureDate != null)
				return false;
		} else if (!departureDate.equals(other.departureDate))
			return false;
		if (driverId == null) {
			if (other.driverId != null)
				return false;
		} else if (!driverId.equals(other.driverId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Trip [id=" + id + ", driverId=" + driverId + ", carId=" + carId + ", departureDate=" + departureDate
				+ ", arrivalDate=" + arrivalDate + ", departureCityId=" + departureCityId + ", arrivalCityId="
				+ arrivalCityId + "]";
	}
	
}
