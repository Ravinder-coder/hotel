package com.hma.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.hma.demo.entity.Customer; 



public interface UserRepository extends CrudRepository<Customer, Integer> {


}
