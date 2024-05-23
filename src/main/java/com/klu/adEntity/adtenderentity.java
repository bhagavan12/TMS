package com.klu.adEntity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "adtenderform")
public class adtenderentity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String title;
	private String category;
	private Date date;
	private String locationInput;
	private String description;
	private String estimatedCost;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

	public String getLocationInput() {
		return locationInput;
	}

	public void setLocationInput(String locationInput) {
		this.locationInput = locationInput;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEstimatedCost() {
		return estimatedCost;
	}

	public void setEstimatedCost(String estimatedCost) {
		this.estimatedCost = estimatedCost;
	}


}