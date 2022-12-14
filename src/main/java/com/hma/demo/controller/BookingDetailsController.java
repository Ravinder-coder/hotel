package com.hma.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;   
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hma.demo.entity.BookingDetails;
import com.hma.demo.exception.BookingDetailsNotFoundException;
import com.hma.demo.service.BookingDetailsService;


@RestController
@RequestMapping("/BookingDetails")
public class BookingDetailsController {

	@Autowired
	BookingDetailsService service;
	
	@GetMapping("/view")
	public ResponseEntity<?> listBookingDetails() throws BookingDetailsNotFoundException{		
		return new ResponseEntity<>(service.showAllBookingDetails(),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addBookingDetails(@RequestBody BookingDetails bd) {		
		return new ResponseEntity<>(service.addBookingDetails(bd), HttpStatus.OK);
	}
	
	@GetMapping("/getbyid/{booking_id}")
	public ResponseEntity<?> getBookingDetails(@PathVariable("booking_id") Integer booking_id ) throws BookingDetailsNotFoundException {		
		return new ResponseEntity<>(service.showBookingDetails(booking_id), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody BookingDetails bd) throws BookingDetailsNotFoundException {		
		return new ResponseEntity<>(service.updateBookingDetails(bd), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{booking_id}")
	public ResponseEntity<?> remove(@PathVariable("booking_id") Integer booking_id ) throws BookingDetailsNotFoundException{
		return new ResponseEntity<>(service.removeBookingDetails(booking_id), HttpStatus.OK);
	}
}
