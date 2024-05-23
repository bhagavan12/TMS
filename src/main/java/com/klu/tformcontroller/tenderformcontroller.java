package com.klu.tformcontroller;


import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Id;

import com.klu.adformentity.Adtenderform;
import com.klu.tenderformbean.tenderformbean;



@ManagedBean(name = "tenderformlist" , eager = true)
@RequestScoped
public class tenderformcontroller {
	private String title;
	private String category;
	private Date date;
	private String locationInput;
	private String estimatedCost;
	private String description;
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
	public String getEstimatedCost() {
		return estimatedCost;
	}
	public void setEstimatedCost(String estimatedCost) {
		this.estimatedCost = estimatedCost;
	}
	
  public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

private List<Adtenderform> list;
  
  public List<Adtenderform> getList() {
      try {
        list = aub.getTenderList();
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
      return list;
    }
    public void setList(List<Adtenderform> list) {
      this.list = list;
    }
 

  @EJB(lookup = "java:global/EP_TMS/tenderformbeanImpl!com.klu.tenderformbean.tenderformbean")
  private tenderformbean aub;
//  
//  public String insert() {
//    try {
//    	tenderformentity au = new tenderformentity();
//      au.setTitle(title);
//      au.setCategory(category);
//      au.setDate(date);
//      au.setLocationInput(locationInput);
//      au.setEstimatedCost(estimatedCost);
//      res_message = aub.getTenderList(au);
//    }catch (Exception e1) {
//      res_message = e1.getMessage();
//    }
//    return "home";
//  }
}