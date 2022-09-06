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
import org.springframework.web.bind.annotation.RestController;

import com.hma.demo.entity.Hotel;
import com.hma.demo.exception.HotelDetailsNotFoundException;
import com.hma.demo.service.hotelservice;



@RestController
public class HotelController {
	@Autowired
	private hotelservice hs;
	
	
	//add hotel
	@GetMapping("/hotels")
	public ResponseEntity<?> getHotels() throws HotelDetailsNotFoundException{
		return new ResponseEntity<>(hs.getHotels(),HttpStatus.OK);
	}
	 
	
	//hotel by id
	@GetMapping("/hotels/{id}")
	public ResponseEntity<?> gethotel(@PathVariable int id) throws HotelDetailsNotFoundException
	{
		return new ResponseEntity<>(hs.gethotel(id),HttpStatus.OK);
	}

	
	@PostMapping("/addhotels")
	public ResponseEntity<?> addhotel(@RequestBody Hotel htl)
	{
		return new ResponseEntity<>(hs.addhotel(htl),HttpStatus.OK);
	}
	
	
	@PutMapping("/updatehotels")
	public ResponseEntity<?> updatehotel(@RequestBody Hotel ht) throws HotelDetailsNotFoundException {
		return new ResponseEntity<>(hs.updatehotel(ht),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/hotels/{id}")
	public ResponseEntity<?> deletehotel(@PathVariable int id) throws HotelDetailsNotFoundException{
	    return new ResponseEntity<>(hs.deletehotel(id),HttpStatus.OK);
	}
}
