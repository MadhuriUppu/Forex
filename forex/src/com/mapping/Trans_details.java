package com.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="trans_details")
@Table(name="trans_details")
public class Trans_details {
	
	
	@Id
	@Column(name="tid")
	int tid;
	
	@Column(name="orderid_1")
	int orderid_1;
	
	@Column(name="orderid_2")
	int orderid_2;
	
	public Trans_details() {}
	
	public Trans_details(int tid,int orderid_1,int orderid_2) {
		this.tid=tid;
		this.orderid_1=orderid_1;
		this.orderid_2=orderid_2;
	}
}
