package com.hma.demo.service;

import java.util.List; 

import org.springframework.stereotype.Service;

import com.hma.demo.entity.Customer;
import com.hma.demo.exception.UserNotFoundException;



@Service
public interface UserService {

	public Customer addUser(Customer user );
	public String removeUser(Integer user_id) throws UserNotFoundException;
	public List<Customer> ShowAllUser() throws UserNotFoundException;
	public Customer ShowUser(Integer user_id) throws UserNotFoundException;
	public Customer updateUser(Integer user_id , Customer user)throws UserNotFoundException;


}
