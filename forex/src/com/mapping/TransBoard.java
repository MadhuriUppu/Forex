package com.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="trans_board")
@Table(name="trans_board")
public class TransBoard {

	@Id
	@Column(name="tid")
	int tid;
	
	@Column(name="currency_pair")
	String currency_pair;
	
	@Column(name="volume")
	int volume;
	
	@Column(name="commission")
	double commission;
	
	@Column(name="trans_date")
	String trans_date;
	
	public TransBoard() {}
	
	public TransBoard(int tid,String currency_pair,int volume,double commission2,String trans_date) {
		this.tid=tid;
		this.currency_pair=currency_pair;
		this.volume=volume;
		this.commission=commission2;
		this.trans_date=trans_date;
	}
	
}
