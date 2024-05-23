package com.klu.adtenderbean;

import javax.ejb.Stateless;
import javax.persistence.*;

import com.klu.adEntity.adtenderentity;
import com.klu.tms.signupentity.RegisterUser;
@Stateless
public class tenderBeanImpl implements tenderadbean {

	@Override
	public String insertData(adtenderentity e) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ep_tms");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
		emf.close();

		return "submitedsuccessfully";
	}

}