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

@Repository("guestDao")
public class RmsGuestDaoImp  implements RmsGuestDao{
	 
	@Autowired
	private SessionFactory sessionFactory;
	
	public String save(RmsGuestDomain guestDomain) {
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    String guestId = "";
		    try {
		      tx = session.beginTransaction();
		      guestId = (String) session.save(guestDomain);
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
	
	 public boolean update(RmsGuestDomain userDomain) {
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    boolean result = false;
		    try {
		      tx = session.beginTransaction();
		      session.update(userDomain);
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

	 public boolean delete(RmsGuestDomain userDomain) {
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    boolean result = false;
		    try {
		      tx = session.beginTransaction();
		      session.delete(userDomain);
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
	 
	 public RmsGuestDomain getGuestById(String guestId) {
		 Session session = sessionFactory.openSession();
		 Transaction tx = null;
		 RmsGuestDomain resultObj = null;
		 try {
			 tx = session.beginTransaction();
			 resultObj = (RmsGuestDomain) session.get(RmsGuestDomain.class, guestId);
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
	 
	 public List<RmsGuestDomain> getGuestList() {
		 Session session = sessionFactory.openSession();
		 Transaction tx = null;
		 List<RmsGuestDomain> resultObj = new ArrayList<RmsGuestDomain>();
		 try {
			 tx = session.beginTransaction();
			 resultObj = session.createCriteria(RmsGuestDomain.class).list();
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
	 
	 public String saveVisit(RmsVisitDomain visitDomain) {
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    String visitId = "";
		    try {
		      tx = session.beginTransaction();
		      visitId = (String) session.save(visitDomain);
		      tx.commit();
		    } catch (HibernateException e) {
		      if (tx != null) {
		        tx.rollback();
		      }
		    } finally {
		      session.close();
		    }
		    return visitId;
  }
	 
	 public String saveVisitMenuPlane(RmsVisitMenuPlaneDomain visitMenuDomain) {
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    String visitMenuPlaneId = "";
		    try {
		      tx = session.beginTransaction();
		      visitMenuPlaneId = (String) session.save(visitMenuDomain);
		      tx.commit();
		    } catch (HibernateException e) {
		      if (tx != null) {
		        tx.rollback();
		      }
		    } finally {
		      session.close();
		    }
		    return visitMenuPlaneId;
	 }
	
	 public RmsGuestDomain getGuestDomainByQuery(String query) {
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    RmsGuestDomain resultObj = new RmsGuestDomain();
		    try {
		      tx = session.beginTransaction();
		      resultObj = (RmsGuestDomain) session.createQuery(query).setFirstResult(0).setMaxResults(1).uniqueResult();
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
