package com.hma.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hma.demo.entity.RoomDetails;
import com.hma.demo.exception.RoomDetailsNotFoundException;
import com.hma.demo.serviceimpl.RoomDetailsServiceImpl;



@RestController
@CrossOrigin
public class RoomDetailsController {
	
	@Autowired 
	RoomDetailsServiceImpl rservice;
	
	@PostMapping("/room/add")
	public ResponseEntity<?> addroom(@RequestBody RoomDetails room) {
		return new ResponseEntity<>(rservice.addRoomDetails(room),HttpStatus.OK);
		
	}
	
	@PutMapping("/room/update")
	public ResponseEntity<?> updateroom(@RequestBody RoomDetails room) throws RoomDetailsNotFoundException {
		return new ResponseEntity<>(rservice.updateRoomDetails(room),HttpStatus.OK);
	}
	
	@DeleteMapping("/room/delete/{id}")
	public ResponseEntity<?> deleteroom(@PathVariable Integer id) throws RoomDetailsNotFoundException {
		return new ResponseEntity<>(rservice.removeRoomDetails(id),HttpStatus.OK);
	}
	
	@GetMapping("/room/getall")
	public ResponseEntity<?> getall() throws RoomDetailsNotFoundException{
		return new ResponseEntity<>(rservice.showAllRoomDetails(),HttpStatus.OK);
	}
	
	@GetMapping("/room/getroom/{id}")
	public ResponseEntity<?> getroom(@PathVariable Integer id) throws RoomDetailsNotFoundException {
		return new ResponseEntity<>(rservice.showRoomDetails(id),HttpStatus.OK);
	}

}
