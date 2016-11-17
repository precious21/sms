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

import com.momentumTech.rms.springmvc.domain.RmsGuestDomain;
import com.momentumTech.rms.springmvc.domain.RmsVisitDomain;
import com.momentumTech.rms.springmvc.domain.RmsVisitMenuPlaneDomain;

@Repository("visitMenuPlaneDao")
public class RmsVisitMenuPlaneDaoImp  implements RmsVisitMenuPlaneDao{
	 
	@Autowired
	private SessionFactory sessionFactory;
	
	public String save(RmsVisitMenuPlaneDomain visitMenuPlaneDomain) {
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    String guestId = "";
		    try {
		      tx = session.beginTransaction();
		      guestId = (String) session.save(visitMenuPlaneDomain);
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
	
	 public boolean update(RmsVisitMenuPlaneDomain visitMenuPlaneDomain) {
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    boolean result = false;
		    try {
		      tx = session.beginTransaction();
		      session.update(visitMenuPlaneDomain);
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

	 public boolean delete(RmsVisitMenuPlaneDomain visitMenuPlaneDomain) {
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    boolean result = false;
		    try {
		      tx = session.beginTransaction();
		      session.delete(visitMenuPlaneDomain);
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
	 
	 public RmsVisitMenuPlaneDomain getVisitMenuPlaneById(String visitMenuPlaneId) {
		 Session session = sessionFactory.openSession();
		 Transaction tx = null;
		 RmsVisitMenuPlaneDomain resultObj = null;
		 try {
			 tx = session.beginTransaction();
			 resultObj = (RmsVisitMenuPlaneDomain) session.get(RmsVisitMenuPlaneDomain.class, visitMenuPlaneId);
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
	 
	 public List<RmsVisitMenuPlaneDomain> getVisitMenuPlaneList() {
		 Session session = sessionFactory.openSession();
		 Transaction tx = null;
		 List<RmsVisitMenuPlaneDomain> resultObj = new ArrayList<RmsVisitMenuPlaneDomain>();
		 try {
			 tx = session.beginTransaction();
			 resultObj = session.createCriteria(RmsVisitMenuPlaneDomain.class).list();
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
	 
	 public List<RmsVisitMenuPlaneDomain> getVisitMenuPlaneListByQuery(String query) {
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    List<RmsVisitMenuPlaneDomain> resultObj = new ArrayList<RmsVisitMenuPlaneDomain>();
		    try {
		      tx = session.beginTransaction();
		      resultObj = session.createQuery(query).list();
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
	 
	 public RmsVisitMenuPlaneDomain getVisitMenuPlaneDomainByQuery(String query) {
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    RmsVisitMenuPlaneDomain resultObj = new RmsVisitMenuPlaneDomain();
		    try {
		      tx = session.beginTransaction();
		      resultObj = (RmsVisitMenuPlaneDomain) session.createQuery(query).setFirstResult(0).setMaxResults(1).uniqueResult();
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
