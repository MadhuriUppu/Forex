package com.mapping;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jsp.HibernateUtil;



public class OrderMapping {

	static int tid=1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("hello");
		List<Order> sell = new ArrayList<Order>();
		List<Order> buy=new ArrayList<Order>();
		Session session = HibernateUtil.openSession();
		Transaction tx=null;
		
		try {
			tx = session.getTransaction();
	         tx.begin();         
	         
	         sell = session.createQuery("from com.mapping.Order where status='pending' and t_ype='sell'").list();
	         buy = session.createQuery("from com.mapping.Order where status='pending' and t_ype='buy'").list();
	         
	         System.out.println("this is running");       
	         
	     mapping(sell,buy);
	     oneToManyMapping(sell,buy);
	     
		}
		catch(Exception e) {
			System.out.println("this is not running");
			e.printStackTrace();
			if(tx!=null){
	             tx.rollback();
	         }
		}
		finally {
			session.close();
		}
	}
	
	static void mapping(List<Order> sell, List<Order> buy) {
		String temp="";
		Trans trans=new Trans();
		for(int i=0;i<sell.size();i++) {
			for(int j=0;j<buy.size();j++) {
				if((sell.get(i).currency_pair.equals(buy.get(j).currency_pair)) 
						&& (sell.get(i).volume==buy.get(j).volume) && 
						(sell.get(i).status.equals(buy.get(j).status))) {
					String currency_pair=buy.get(j).currency_pair;
					int volume=buy.get(i).volume;
					double commission=volume*(buy.get(i).ask_price-buy.get(i).bid);
					int oid1=sell.get(i).cid;
					int oid2=buy.get(j).cid;
					
					doTransInsertion(currency_pair, volume, commission,oid1,oid2);
					break;
				}
			}
		}
		
	}
	static void doTransInsertion(String currency_pair,int volume,double commission,int orderid_1,int orderid_2) {
		Date d=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String trans_date=String.valueOf(sd.format(d));
		TransBoard tb=new TransBoard(tid, currency_pair, volume, commission, trans_date);
		
		Trans t=new Trans();
		boolean result=t.insert(tb);
		
		if(result==true) {
		
			tid++;
			System.out.println("Insertion done in trans_board table");
			boolean res=doTransDetails(orderid_1, orderid_2);
			
			if(res==true) {
				System.out.println("Insertion successfull in trans details table");
			}
			else
				System.out.println("Insertion exception in transdetails table");
		}
		else
			System.out.println("Insertion exception in trans_board table");
	}
	
	static boolean doTransDetails(int orderid_1,int orderid_2) {
		
		Trans_details td=new Trans_details(tid, orderid_1, orderid_2);
				
		TransDetails transdet=new TransDetails();
		
		boolean result=transdet.insert(td);
		
		if(result==true)
			return true;
		else 
			return false;
	}

static void oneToManyMapping(List<Order>sell,List<Order>buy) {
	int i,j,k;
	int n1 = sell.size();
	int n2 = buy.size();
	List<Order>buy1=null,buy2;
	String oid2="";
	for(i=0;i<n1;i++) {
		for(j=0;j<n2;j++) {
			if(buy.get(j).currency_pair.equals(sell.get(i).currency_pair)) 
				{
					buy1.add(buy.get(i));
				}
		}
		try {
			buy2=com.mapping.SubsetSum.printAllSubsets(buy1,buy1.size(),sell.get(i).volume);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(buy2 != null) {
			for(k=0;k<buy2.size();k++) {
				oid2 += (Integer.toString((buy2.get(k).cid)));
			}
		}else {
			System.out.println("no match found");
		}
		String currency_pair = buy.get(i).currency_pair;
		int volume = buy.get(i).volume;
		double commission=volume*(buy.get(i).ask_price-buy.get(i).bid);
		String oid1 = Integer.toString(buy.get(i).cid);
		doTransInsertion(currency_pair, volume, commission,oid1,oid2);
		}
	}
}

