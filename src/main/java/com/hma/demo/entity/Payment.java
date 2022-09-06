package com.hma.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Payment {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int payment_id;

@ManyToOne(targetEntity = BookingDetails.class,cascade = CascadeType.ALL)
@JoinColumn(name = "booking_id",referencedColumnName = "booking_id")
private BookingDetails bookingdetails;

@OneToOne(targetEntity = Transaction.class,cascade = CascadeType.ALL)
@JoinColumn(name = "transaction_id",referencedColumnName = "transaction_id")
private Transaction transaction;

}
