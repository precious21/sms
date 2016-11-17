package com.momentumTech.rms.springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.momentumTech.rms.springmvc.domain.RmsFoodConsumptionDomain;
import com.momentumTech.rms.springmvc.domain.RmsGuestDomain;
import com.momentumTech.rms.springmvc.domain.RmsVisitDomain;
import com.momentumTech.rms.springmvc.domain.RmsVisitMenuPlaneDomain;

@Repository("foodConsumptionDao")
public class RmsFoodConsumptionDaoImp  implements RmsFoodConsumptionDao{
	 
	@Autowired
	private SessionFactory sessionFactory;
	
	public String save(RmsFoodConsumptionDomain foodConsumptionDomain) {
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    String guestId = "";
		    try {
		      tx = session.beginTransaction();
		      guestId = (String) session.save(foodConsumptionDomain);
		      tx.commit();
		    } catch (HibernateException e) {
		      if (tx != null) {
		    	  e.printStackTrace();
		        tx.rollback();
		      }
		    } finally {
		      session.close();
		    }
		    return guestId;
     }
	
	 public boolean update(RmsFoodConsumptionDomain foodConsumptionDomain) {
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    boolean result = false;
		    try {
		      tx = session.beginTransaction();
		      session.update(foodConsumptionDomain);
		      tx.commit();
		      result = true;
		    } catch (HibernateException e) {
		      if (tx != null) {
		        tx.rollback();
		      }
		    } finally {
		      session.close();
		    }
		    return result;
	}

	 public boolean delete(RmsFoodConsumptionDomain foodConsumptionDomain) {
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    boolean result = false;
		    try {
		      tx = session.beginTransaction();
		      session.delete(foodConsumptionDomain);
		      tx.commit();
		      result = true;
		    } catch (HibernateException e) {
		      if (tx != null) {
		        tx.rollback();
		      }
		    } finally {
		      session.close();
		    }
		    return result;
	 }
	 
	 public RmsFoodConsumptionDomain getFoodConsumptionById(String foodConsumptionId) {
		 Session session = sessionFactory.openSession();
		 Transaction tx = null;
		 RmsFoodConsumptionDomain resultObj = null;
		 try {
			 tx = session.beginTransaction();
			 resultObj = (RmsFoodConsumptionDomain) session.get(RmsFoodConsumptionDomain.class, foodConsumptionId);
			 tx.commit();
		 } catch (HibernateException e) {
			 if (tx != null) {
				 tx.rollback();
			 }
		 } finally {
			 session.close();
		 }
		 return resultObj;
	 }
	 
	 public List<RmsFoodConsumptionDomain> getFoodConsumptionList() {
		 Session session = sessionFactory.openSession();
		 Transaction tx = null;
		 List<RmsFoodConsumptionDomain> resultObj = new ArrayList<RmsFoodConsumptionDomain>();
		 try {
			 tx = session.beginTransaction();
			 resultObj = session.createCriteria(RmsFoodConsumptionDomain.class).list();
			 tx.commit();
		 } catch (HibernateException e) {
			 if (tx != null) {
				 tx.rollback();
			 }
		 } finally {
			 session.close();
		 }
		 return resultObj;
	 }
	 
	
	 public RmsFoodConsumptionDomain getFoodConsumptionDomainByQuery(String query) {
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    RmsFoodConsumptionDomain resultObj = new RmsFoodConsumptionDomain();
		    try {
		      tx = session.beginTransaction();
		      resultObj = (RmsFoodConsumptionDomain) session.createQuery(query).setFirstResult(0).setMaxResults(1).uniqueResult();
		      tx.commit();
		    } catch (HibernateException e) {
		    	e.printStackTrace();
		      if (tx != null) {
		        tx.rollback();
		      }
		    } finally {
		      session.close();
		    }
		    return resultObj;
	}
	 
}
