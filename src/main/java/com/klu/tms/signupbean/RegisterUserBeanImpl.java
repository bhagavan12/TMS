package com.klu.tms.signupbean;

import javax.ejb.Stateless;
import javax.persistence.*;

import com.klu.tms.signupentity.RegisterUser;
@Stateless
public class RegisterUserBeanImpl implements RegisterUserBean {

	@Override
	public String insertData(RegisterUser e) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ep_tms");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
		emf.close();

		return "signupsuccessfully";
	}

}