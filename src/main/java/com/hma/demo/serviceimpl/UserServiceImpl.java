package com.hma.demo.serviceimpl;

import java.util.List; 
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hma.demo.entity.Customer;
import com.hma.demo.exception.UserNotFoundException;
import com.hma.demo.repository.UserRepository;
import com.hma.demo.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	
	@Autowired
	UserRepository userRepository;
	
	
	//add user
	
	@Override
	public Customer addUser(Customer user) {
		return userRepository.save(user);
		
	}

	
	//update user
	
	@Override
	public Customer updateUser(Integer user_id , Customer u) throws UserNotFoundException {
		
        Customer userDB = userRepository.findById(user_id).get();
        
   
		// checking if passed User object properties are null or blank
        
		if(Objects.nonNull(u.getUser_name()) && !"".equalsIgnoreCase(u.getUser_name())) {
			userDB.setUser_name(u.getUser_name());
		}
		
		if(Objects.nonNull(u.getEmail()) && !"".equalsIgnoreCase(u.getEmail())) {
			userDB.setEmail(u.getEmail());
		}
		
		if(Objects.nonNull(u.getPassword()) && !"".equalsIgnoreCase(u.getPassword())) {
			userDB.setPassword(u.getPassword());
		}
		

		if(Objects.nonNull(u.getRole()) && !"".equalsIgnoreCase(u.getRole())) {
			userDB.setRole(u.getRole());
		}
		
		if(Objects.nonNull(u.getMobile()) && !"".equalsIgnoreCase(u.getMobile())) {
			userDB.setMobile(u.getMobile());
		}
		
		if(Objects.nonNull(u.getAddress()) && !"".equalsIgnoreCase(u.getAddress())) {
			userDB.setAddress(u.getAddress());
		}
		
		return userRepository.save(userDB);	}

	
	
	//remove user
	
	@Override
	public String removeUser(Integer user_id) throws UserNotFoundException {
		
		if(userRepository.findById(user_id).isPresent()) {
		userRepository.deleteById(user_id);
		 return "deleted user";
		}else {
			throw new UserNotFoundException();
			
		}

	}

	
	//Show all user
	
	@Override
	public List<Customer> ShowAllUser() throws UserNotFoundException {
		List<Customer> list=(List<Customer>) userRepository.findAll();
		if(list.isEmpty()) {
			throw new UserNotFoundException();
		}
        return list;
	}

	
	
	//show user
	
	@Override
	public Customer ShowUser(Integer user_id) throws UserNotFoundException {
		
		if(userRepository.findById(user_id).isPresent()) {
			Customer u = userRepository.findById(user_id).get();
			return u;	
		}
		else throw new UserNotFoundException();
		
	}

	
}
