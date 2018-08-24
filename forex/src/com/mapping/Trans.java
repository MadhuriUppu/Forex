package com.mapping;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jsp.HibernateUtil;

public class Trans {
	
	Transaction tx = null;
	Session session = HibernateUtil.openSession();
	
	public boolean insert(TransBoard tb) {
		int c=0;
		try {
	         tx = session.getTransaction();
	         tx.begin();
	         session.save(tb);
	        // System.out.println(user.username);
	         tx.commit();
	     } catch (Exception e) {
	         if (tx != null) {
	             tx.rollback();
	         }
	         e.printStackTrace();
	         c++;
	     } finally {
	         session.close();
	     } 
		if(c==0)
			return true;
		else
			return false;
	}

}
