package com.klu.tms.signupcontroller;

import java.lang.ProcessBuilder.Redirect;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.klu.tms.signupbean.RegisterUserBean;
import com.klu.tms.signupentity.RegisterUser;

@ManagedBean(name = "register", eager = true)
@RequestScoped
public class RegisterUserData {
	private String fname;
	private String lname;
	private String email;
	private String phone;
	private String password;
	private String res_message;

	
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRes_message() {
		return res_message;
	}

	public void setRes_message(String res_message) {
		this.res_message = res_message;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@EJB(lookup = "java:global/EP_TMS/RegisterUserBeanImpl!com.klu.tms.signupbean.RegisterUserBean")
	private RegisterUserBean eb;

	public String insert() {
		try {
			RegisterUser e = new RegisterUser();
			e.setFname(fname);
			e.setLname(lname);
			e.setEmail(email);
			e.setPhone(phone);
			e.setPassword(password);
			System.out.println("password" + password + ".........................");
			res_message = eb.insertData(e);
		} catch (Exception e1) {
			res_message = e1.getMessage();
		}
		return "login";
	}

	

}