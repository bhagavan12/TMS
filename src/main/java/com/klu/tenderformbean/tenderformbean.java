package com.klu.tenderformbean;

import java.util.List;

import javax.ejb.Remote;

import com.klu.adformentity.Adtenderform;
@Remote
public interface tenderformbean {
	public List<Adtenderform> getTenderList() throws Exception;
}
