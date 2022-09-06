package com.hma.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hma.demo.entity.Payment;
import com.hma.demo.service.PaymentService;



@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/add/payment")
	public ResponseEntity<?> addPayment(@RequestBody Payment payment) {
		
		return new ResponseEntity<>(paymentService.addPayment(payment),HttpStatus.OK);
	}

}
