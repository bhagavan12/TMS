package com.klu.tenderformbean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.klu.adformentity.Adtenderform;
@Stateless
public class tenderformbeanImpl implements tenderformbean {
	public List<Adtenderform> getTenderList() throws Exception {
	    // TODO Auto-generated method stub
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ep_tms");
	      EntityManager em = emf.createEntityManager();
	      em.getTransaction().begin();
	      TypedQuery<Adtenderform> query = em.createQuery("SELECT e FROM Adtenderform e", Adtenderform.class);
	      List<Adtenderform> list = query.getResultList();
	      em.getTransaction().commit();
	      em.close();
	      emf.close();
	      
	      return list;
	  }
}
