package com.momentumTech.rms.springmvc.dao;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;


@Repository("commonDao")
public class RmsCommonDaoImp implements RmsCommonDao {

  /**
   * 
   */
  private static final long serialVersionUID = -253798659987576751L;
  @Autowired
  private SessionFactory sessionFactory;


  public boolean updateByQuery(String query) {
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    boolean result = false;
    try {
      tx = session.beginTransaction();
      Query q = session.createQuery(query);
      q.executeUpdate();
      tx.commit();
      result = true;
    } catch (HibernateException e) {
      e.printStackTrace();
      if (tx != null) {
        tx.rollback();
      }
    } finally {
      session.close();
    }
    return result;
  }

}
