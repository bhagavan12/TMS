
package com.klu.tms.signupbean;

import javax.ejb.Remote;

import com.klu.tms.signupentity.RegisterUser;

@Remote
public interface RegisterUserBean {
	public String insertData(RegisterUser e) throws Exception;
}
