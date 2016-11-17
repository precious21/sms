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
import com.momentumTech.rms.springmvc.domain.RmsFoodTypeDomain;
import com.momentumTech.rms.springmvc.domain.RmsGuestDomain;
import com.momentumTech.rms.springmvc.domain.RmsVisitDomain;
import com.momentumTech.rms.springmvc.domain.RmsVisitMenuPlaneDomain;

@Repository("foodTypeDao")
public class RmsFoodTypeDaoImp  implements RmsFoodTypeDao{
	 
	@Autowired
	private SessionFactory sessionFactory;
	
	public String save(RmsFoodTypeDomain foodTypeDomain) {
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    String guestId = "";
		    try {
		      tx = session.beginTransaction();
		      guestId = (String) session.save(foodTypeDomain);
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
	
	 public boolean update(RmsFoodTypeDomain foodTypeDomain) {
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    boolean result = false;
		    try {
		      tx = session.beginTransaction();
		      session.update(foodTypeDomain);
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

	 public boolean delete(RmsFoodTypeDomain foodTypeDomain) {
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    boolean result = false;
		    try {
		      tx = session.beginTransaction();
		      session.delete(foodTypeDomain);
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
	 
	 public RmsFoodTypeDomain getFoodTypeById(String foodTypeId) {
		 Session session = sessionFactory.openSession();
		 Transaction tx = null;
		 RmsFoodTypeDomain resultObj = null;
		 try {
			 tx = session.beginTransaction();
			 resultObj = (RmsFoodTypeDomain) session.get(RmsFoodTypeDomain.class, foodTypeId);
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
	 
	 public List<RmsFoodTypeDomain> getFoodTypeList() {
		 Session session = sessionFactory.openSession();
		 Transaction tx = null;
		 List<RmsFoodTypeDomain> resultObj = new ArrayList<RmsFoodTypeDomain>();
		 try {
			 tx = session.beginTransaction();
			 resultObj = session.createCriteria(RmsFoodTypeDomain.class).list();
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
	 
	
	 public RmsFoodTypeDomain getFoodTypeDomainByQuery(String query) {
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    RmsFoodTypeDomain resultObj = new RmsFoodTypeDomain();
		    try {
		      tx = session.beginTransaction();
		      resultObj = (RmsFoodTypeDomain) session.createQuery(query).setFirstResult(0).setMaxResults(1).uniqueResult();
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
