package com.klu.tms.loginbean;

import java.io.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.faces.application.FacesMessage;

@ManagedBean(name = "login", eager = true)
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;
	private String email;
	private String password;
	private String message;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String validateUsernamePassword() {
		boolean valid = LoginDAO.validate(email, password);
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("email", email);
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("You have logged in successfully",
					"You have successfully registered and logged in"));
			return "home";

		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null,
					new FacesMessage("Incorrect Username and Passowrd", "Please enter correct username and Password"));
			return "login";
		}

	}

//	public String logout() {
//		HttpSession session = SessionUtils.getSession();
//		session.invalidate();
//
//		// Set cache-control headers to prevent caching on logout page
//		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
//				.getResponse();
//		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
//		response.setHeader("Pragma", "no-cache");
//		response.setHeader("Expires", "0");
//
//		try {
//			FacesContext.getCurrentInstance().getExternalContext().redirect("logout.jsf");
//		} catch (IOException e) {
//			// Handle the exception if necessary
//		}
//
//		return null; // Return null to prevent further navigation
//	}
	public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "login?faces-redirect=true";
    }
	public String redirectToLogin() {
        return "login?faces-redirect=true";
    }
}