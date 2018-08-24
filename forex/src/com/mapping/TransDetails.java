package com.mapping;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jsp.HibernateUtil;

public class TransDetails {
	Transaction tx = null;
	Session session = HibernateUtil.openSession();
	


	public boolean insert(Trans_details transdet) {
		// TODO Auto-generated method stub
		int c=0;
		try {
			System.out.println("1");
	         tx = session.getTransaction();
	         System.out.println("Sec");
	         tx.begin();
	         System.out.println("Third");
	         session.save(transdet);
	         System.out.println("four");
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
