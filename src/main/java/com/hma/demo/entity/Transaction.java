package com.hma.demo.entity;


import javax.persistence.Entity; 
import javax.persistence.Id;
import javax.persistence.OneToOne;
  

@Entity
public class Transaction {
    @Id
	private Integer transaction_id;
	private double amount;
		
}
