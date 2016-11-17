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

import com.momentumTech.rms.springmvc.domain.RmsUserDomain;

@Repository("userDao")
public class RmsUserDaoImp  implements RmsUserDao{
	 
	@Autowired
	private SessionFactory sessionFactory;
	
	public String save(RmsUserDomain userModel) {
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    String userId = "";
		    try {
		      tx = session.beginTransaction();
		      userId = (String) session.save(userModel);
		      tx.commit();
		    } catch (HibernateException e) {
		      if (tx != null) {
		        tx.rollback();
		      }
		    } finally {
		      session.close();
		    }
		    return userId;
     }
	
	 public boolean update(RmsUserDomain userDomain) {
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

	 public boolean delete(RmsUserDomain userDomain) {
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
	 
	 public RmsUserDomain getUserById(String userId) {
		 Session session = sessionFactory.openSession();
		 Transaction tx = null;
		 RmsUserDomain resultObj = null;
		 try {
			 tx = session.beginTransaction();
			 resultObj = (RmsUserDomain) session.get(RmsUserDomain.class, userId);
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
	 
	 public List<RmsUserDomain> getUserList() {
		 Session session = sessionFactory.openSession();
		 Transaction tx = null;
		 List<RmsUserDomain> resultObj = new ArrayList<RmsUserDomain>();
		 try {
			 tx = session.beginTransaction();
			 resultObj = session.createCriteria(RmsUserDomain.class).list();
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
	 
//	 public RmsUserDomain validateUser(RmsUserDomain userModel) {
//		    Session session = sessionFactory.openSession();
//		    Transaction tx = null;
//		    RmsUserDomain resultObj = new RmsUserDomain();
//		    try {
//		      tx = session.beginTransaction();
//		      Criteria criteria = session.createCriteria(RmsUserDomain.class);
//		      criteria.add(Restrictions.eq("username", userModel.getUsername()));
//		      criteria.add(Restrictions.eq("password", userModel.getPassword()));
//		      resultObj = (RmsUserDomain) criteria.uniqueResult();
//		      tx.commit();
//		    } catch (HibernateException e) {
//		      if (tx != null) {
//		        tx.rollback();
//		      }
//		    } finally {
//		      session.close();
//		    }
//		    return resultObj;
//	  }
	 
	 public RmsUserDomain validateUser(RmsUserDomain userModel) {
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    RmsUserDomain resultObj = new RmsUserDomain();
		    try {
		      tx = session.beginTransaction();
		      Criteria criteria = session.createCriteria(RmsUserDomain.class);
		      criteria.add(Restrictions.eq("username", userModel.getUsername()));
		      criteria.add(Restrictions.eq("password", userModel.getPassword()));
		      resultObj = (RmsUserDomain) criteria.uniqueResult();
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
	
	 
}
