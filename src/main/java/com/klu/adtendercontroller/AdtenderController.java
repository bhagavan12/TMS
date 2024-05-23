package com.klu.adtendercontroller;

import java.lang.ProcessBuilder.Redirect;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.klu.adEntity.adtenderentity;
import com.klu.adtenderbean.tenderadbean;
//import com.klu.tms.signupbean.RegisterUserBean;
//import com.klu.tms.signupentity.RegisterUser;

@ManagedBean(name = "tenderform", eager = true)
@RequestScoped
public class AdtenderController {
	private String title;
	private String category;
	private Date date;
	private String locationInput;
	private String description;
	private String estimatedCost;
	private String res_message;

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

	public String getRes_message() {
		return res_message;
	}

	public void setRes_message(String res_message) {
		this.res_message = res_message;
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

	

	@EJB(lookup = "java:global/EP_TMS/tenderBeanImpl!com.klu.adtenderbean.tenderadbean")
	private tenderadbean tb;

	public String insert() {
		try {
			adtenderentity e = new adtenderentity();
			e.setTitle(title);
			e.setCategory(category);
			e.setDate(date);
			e.setLocationInput(locationInput);
			e.setDescription(description);
			e.setEstimatedCost(estimatedCost);
//			System.out.println("password" + password + ".........................");
			res_message = tb.insertData(e);
		} catch (Exception e1) {
			res_message = e1.getMessage();
		}
		return "adtendercontroller";
	}

	

}