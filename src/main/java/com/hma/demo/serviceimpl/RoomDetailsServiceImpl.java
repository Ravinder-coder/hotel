
package com.hma.demo.serviceimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Iterator;
import java.util.List; 
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hma.demo.entity.BookingDetails;
import com.hma.demo.entity.RoomDetails;
import com.hma.demo.exception.RoomDetailsNotFoundException;
import com.hma.demo.repository.BookingDetailsRepository;
import com.hma.demo.repository.RoomDetailsRepository;
import com.hma.demo.service.RoomDetailsService;



@Service
public class RoomDetailsServiceImpl implements RoomDetailsService{
	@Autowired
	RoomDetailsRepository rrepo;

	@Autowired
	BookingDetailsRepository brepo;
		
	public String addRoomDetails(RoomDetails room) {
		rrepo.save(room);
		return "Room Added successfully";
		
	}
	public String updateRoomDetails(RoomDetails room) throws RoomDetailsNotFoundException{
	  if(rrepo.findById(room.getRoom_id()).isPresent()) {
		Integer id = room.getRoom_id();
		Optional<RoomDetails> roomEntity= rrepo.findById(id);
		roomEntity.get().setIs_available(null);
		roomEntity.get().setRate_per_day(null);
		roomEntity.get().setRoom_no(null);
		rrepo.save(roomEntity.get());
		return "Room Details updated";
		}
	  else
		  throw new RoomDetailsNotFoundException();
	}
	public String removeRoomDetails(Integer rid) throws RoomDetailsNotFoundException{
		if(rrepo.findById(rid).isPresent()) {
			rrepo.deleteById(rid);
			return "Room details are deleted";
		}
		else
			throw new RoomDetailsNotFoundException(); 
	}
	public List<RoomDetails> showAllRoomDetails() throws RoomDetailsNotFoundException{
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM"); 
	   LocalDate today = LocalDate.now();
	   	   
	   List<RoomDetails> list =rrepo.findAll();	   
	   if(list.isEmpty())
		   throw new RoomDetailsNotFoundException();
	   
	   List<BookingDetails> list1 =brepo.findAll();
	   Iterator<BookingDetails> it=list1.iterator();
	   for(BookingDetails bd : list1) {
		   String[] s =it.next().getBooked_to().toString().split(" ");
		   LocalDate bookedto = LocalDate.parse(s[0]);
		   if(today.compareTo(bookedto)>0) {
		       RoomDetails r= rrepo.getById(bd.getRoom_id());
			   r.setIs_available(true);
		       rrepo.save(r); }
	   }
	   return rrepo.findAll();
	
	}
	
	public  RoomDetails showRoomDetails(Integer id) throws RoomDetailsNotFoundException{
		if(rrepo.findById(id).isPresent()) {
			RoomDetails r= rrepo.getById(id);
			return r;
	   }
		else
			 throw new RoomDetailsNotFoundException();
}
}
