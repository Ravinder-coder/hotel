package com.hma.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.hma.demo.entity.Payment;
import com.hma.demo.repository.PaymentRepository;
import com.hma.demo.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Payment addPayment(Payment payment) {
		return paymentRepository.save(payment);
	}

}
