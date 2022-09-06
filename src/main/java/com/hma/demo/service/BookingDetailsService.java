package com.hma.demo.service;

import java.util.List; 

import org.springframework.stereotype.Service;

import com.hma.demo.entity.BookingDetails;
import com.hma.demo.exception.BookingDetailsNotFoundException;



@Service
public interface BookingDetailsService {

	public BookingDetails addBookingDetails(BookingDetails bookingdetails);
	public BookingDetails updateBookingDetails(BookingDetails bookingdetails) throws BookingDetailsNotFoundException;
	public String removeBookingDetails(int booking_id) throws BookingDetailsNotFoundException;
	public List<BookingDetails> showAllBookingDetails() throws BookingDetailsNotFoundException;
	public BookingDetails showBookingDetails(int booking_id) throws BookingDetailsNotFoundException;
}