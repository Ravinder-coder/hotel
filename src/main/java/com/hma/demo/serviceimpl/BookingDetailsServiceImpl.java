package com.hma.demo.serviceimpl;

import java.util.List;   
import javax.transaction.Transactional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hma.demo.entity.BookingDetails;
import com.hma.demo.entity.Customer;
import com.hma.demo.entity.RoomDetails;
import com.hma.demo.exception.BookingDetailsNotFoundException;
import com.hma.demo.repository.BookingDetailsRepository;
import com.hma.demo.repository.RoomDetailsRepository;
import com.hma.demo.repository.UserRepository;
import com.hma.demo.service.BookingDetailsService;


@Service
@Transactional
public class BookingDetailsServiceImpl implements BookingDetailsService{

	@Autowired
	BookingDetailsRepository bookingrepo;
	
	@Autowired
	RoomDetailsRepository roomrepo;
	
	@Override
	public BookingDetails addBookingDetails(BookingDetails bookingdetails) {
		BookingDetails bookingDetails1 = new BookingDetails();
		bookingDetails1.setBooked_from(bookingdetails.getBooked_from());
		bookingDetails1.setBooked_to(bookingdetails.getBooked_to());
		bookingDetails1.setRoom_id(bookingdetails.getRoom_id());
		bookingDetails1.setNo_of_adults(bookingdetails.getNo_of_adults());
		bookingDetails1.setNo_of_children(bookingdetails.getNo_of_children());
		bookingDetails1.setAmount(bookingdetails.getAmount());
		
		bookingDetails1.setUser(bookingdetails.getUser());
		bookingDetails1.setHotel(bookingdetails.getHotel());
		
		RoomDetails room= roomrepo.getById(bookingdetails.getRoom_id());
		room.setIs_available(false);
		roomrepo.save(room);
		bookingrepo.save(bookingDetails1);
		return bookingDetails1;
	}

	@Override
	public BookingDetails updateBookingDetails(BookingDetails bookingdetails) throws BookingDetailsNotFoundException {
		if(bookingrepo.findById(bookingdetails.getBooking_id()).isPresent()) {
		    BookingDetails bookingDetails1 = bookingrepo.getById(bookingdetails.getBooking_id());
			bookingDetails1.setBooked_from(bookingdetails.getBooked_from());
			bookingDetails1.setBooked_to(bookingdetails.getBooked_to());
			bookingDetails1.setRoom_id(bookingdetails.getRoom_id());
			bookingDetails1.setNo_of_adults(bookingdetails.getNo_of_adults());
			bookingDetails1.setNo_of_children(bookingdetails.getNo_of_children());
			bookingDetails1.setAmount(bookingdetails.getAmount());
			
			bookingDetails1.setUser(bookingdetails.getUser());
			bookingDetails1.setHotel(bookingdetails.getHotel());
			bookingrepo.save(bookingDetails1);
			return bookingDetails1; 
		   
		}
		else
			throw new BookingDetailsNotFoundException();
	}

	@Override
	public String removeBookingDetails(int booking_id) throws BookingDetailsNotFoundException{
		if(bookingrepo.findById(booking_id).isPresent()) {
		   BookingDetails bd= bookingrepo.getById(booking_id);
		   bookingrepo.deleteById(booking_id);
		   return "Booking details are deleted";
	   }else
		   throw new BookingDetailsNotFoundException();
	}

	@Override
	public List<BookingDetails> showAllBookingDetails() throws BookingDetailsNotFoundException{
		List<BookingDetails> list=bookingrepo.findAll();
		if(list.isEmpty()) {
			throw new BookingDetailsNotFoundException();
		}
	    return list;
	}

	@Override
	public BookingDetails showBookingDetails(int booking_id) throws BookingDetailsNotFoundException{
		if(bookingrepo.findById(booking_id).isPresent()) {
		    BookingDetails bd= bookingrepo.getById(booking_id);
		    return bd;
		}
		else
			throw new BookingDetailsNotFoundException();
	}

}