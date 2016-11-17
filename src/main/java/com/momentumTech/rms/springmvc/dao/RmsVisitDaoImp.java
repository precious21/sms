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

@Repository("visitDao")
public class RmsVisitDaoImp  implements RmsVisitDao{
	 
	@Autowired
	private SessionFactory sessionFactory;
	
	public String save(RmsVisitDomain visitDomain) {
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    String guestId = "";
		    try {
		      tx = session.beginTransaction();
		      guestId = (String) session.save(visitDomain);
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
	
	 public boolean update(RmsVisitDomain visitDomain) {
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    boolean result = false;
		    try {
		      tx = session.beginTransaction();
		      session.update(visitDomain);
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

	 public boolean delete(RmsVisitDomain visitDomain) {
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    boolean result = false;
		    try {
		      tx = session.beginTransaction();
		      session.delete(visitDomain);
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
	 
	 public RmsVisitDomain getVisitById(String visitId) {
		 Session session = sessionFactory.openSession();
		 Transaction tx = null;
		 RmsVisitDomain resultObj = null;
		 try {
			 tx = session.beginTransaction();
			 resultObj = (RmsVisitDomain) session.get(RmsVisitDomain.class, visitId);
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
	 
	 public List<RmsVisitDomain> getVisitList() {
		 Session session = sessionFactory.openSession();
		 Transaction tx = null;
		 List<RmsVisitDomain> resultObj = new ArrayList<RmsVisitDomain>();
		 try {
			 tx = session.beginTransaction();
			 resultObj = session.createCriteria(RmsVisitDomain.class).list();
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
	 
	 public List<RmsVisitDomain> getVisitListByQuery(String query) {
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    List<RmsVisitDomain> resultObj = new ArrayList<RmsVisitDomain>();
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
	 
	 public RmsVisitDomain getVisitDomainByQuery(String query) {
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    RmsVisitDomain resultObj = new RmsVisitDomain();
		    try {
		      tx = session.beginTransaction();
		      resultObj = (RmsVisitDomain) session.createQuery(query).setFirstResult(0).setMaxResults(1).uniqueResult();
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
