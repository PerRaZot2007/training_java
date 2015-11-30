package com.rakickij.web.dataaccess.model;

public class Car {
	private Long id;
	private String numberPlate;
	private String condition;
	private Long carModelId;

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Long getCarModelId() {
		return carModelId;
	}

	public void setCarModelId(Long carModelId) {
		this.carModelId = carModelId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carModelId == null) ? 0 : carModelId.hashCode());
		result = prime * result + ((condition == null) ? 0 : condition.hashCode());
		result = prime * result + ((numberPlate == null) ? 0 : numberPlate.hashCode());
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
		Car other = (Car) obj;
		if (carModelId == null) {
			if (other.carModelId != null)
				return false;
		} else if (!carModelId.equals(other.carModelId))
			return false;
		if (condition == null) {
			if (other.condition != null)
				return false;
		} else if (!condition.equals(other.condition))
			return false;
		if (numberPlate == null) {
			if (other.numberPlate != null)
				return false;
		} else if (!numberPlate.equals(other.numberPlate))
			return false;
		return true;
	}
}
