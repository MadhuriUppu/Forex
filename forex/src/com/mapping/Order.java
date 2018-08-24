package com.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="order_board")
@Table(name="order_board")

public class Order {
	@Id
	@Column(name="orderid")
	int orderid;
	
	@Column(name="cid")
	int cid;
	
	@Column(name="currency_pair")
	String currency_pair;
	
	@Column(name="order_date")
	String order_date;
	
	@Column(name="volume")
	int volume;
	
	@Column(name="bid")
	double bid;
	
	@Column(name="ask_price")
	double ask_price;
	
	@Column(name="status")
	String status;
	
	@Column(name="t_ype")
	String t_ype;
	
	public Order() {}
	
	public Order(int orderid,int cid,String order_date,int volume,double bid,double ask_price,String status,String type) {
		this.orderid=orderid;
		this.cid=cid;
		this.order_date=order_date;
		this.volume=volume;
		this.bid=bid;
		this.ask_price=ask_price;
		this.status=status;
		this.t_ype=type;
	}
}
