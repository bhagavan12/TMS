
package com.klu.adtenderbean;

import java.util.List;

import javax.ejb.Remote;

import com.klu.adEntity.adtenderentity;
//import com.klu.tms.signupentity.RegisterUser;

@Remote
public interface tenderadbean {
	public String insertData(adtenderentity e) throws Exception;

}
