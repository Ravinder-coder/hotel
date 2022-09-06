package com.hma.demo;
import static org.assertj.core.api.Assertions.assertThat; 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hma.demo.entity.BookingDetails;
import com.hma.demo.entity.Customer;
import com.hma.demo.entity.Hotel;
import com.hma.demo.repository.BookingDetailsRepository;
import com.hma.demo.service.BookingDetailsService;

@SpringBootTest
class HotelBookingApplicationTests{

	@Autowired
	BookingDetailsService service;
	
	@Autowired
	BookingDetailsRepository repo; 
	
	@Test
	void testgetBookingDetailsbyId() {
		Customer user = new Customer(20,"ravi","ravi@gmail.com","ravi007","developer","8794561230","chennai");
		Hotel hotel= new Hotel(103,"chennai","deluxe","chennai","good",800,"deluxe@gmail.com","8974561230","9745863012","www.deluxe.com");
		BookingDetails bd = new BookingDetails(3,204,new Date(),new Date(),2,2,7000,user,hotel);
		repo.save(bd);
		assertThat(repo.findById(bd.getBooking_id()).isPresent());
		repo.deleteAll();
		}
	
	@Test
	void testsaveBookingDetails() {
		Customer user = new Customer(20,"ravi","ravi@gmail.com","ravi007","developer","8794561230","chennai");
		Hotel hotel= new Hotel(103,"chennai","deluxe","chennai","good",800,"deluxe@gmail.com","8974561230","9745863012","www.deluxe.com");
		BookingDetails bd = new BookingDetails(3,204,new Date(),new Date(),2,2,7000,user,hotel);
		repo.save(bd);
		Iterable<BookingDetails> it= repo.findAll();
		List<BookingDetails> list = new ArrayList<>();
		for (BookingDetails b : it) {
			list.add(b);
		}
		assertThat(list.size()).isEqualTo(1);
		repo.deleteAll();
		}
	
	@Test
	void testupdateBookingDetailsbyId() {
		Customer user = new Customer(20,"ravi","ravi@gmail.com","ravi007","developer","8794561230","chennai");
		Hotel hotel= new Hotel(103,"chennai","deluxe","chennai","good",800,"deluxe@gmail.com","8974561230","9745863012","www.deluxe.com");
		BookingDetails bd = new BookingDetails(3,204,new Date(),new Date(),2,2,7000,user,hotel);
		repo.save(bd);
		bd.setNo_of_children(3);
		repo.save(bd);
        assertThat(repo.findById(3).get().getNo_of_children()).isEqualTo(3);
		repo.deleteAll();
		}
	
	@Test
	void testgetAllBookingDetails() {
		Customer user = new Customer(20,"ravi","ravi@gmail.com","ravi007","developer","8794561230","chennai");
		Hotel hotel= new Hotel(103,"chennai","deluxe","chennai","good",800,"deluxe@gmail.com","8974561230","9745863012","www.deluxe.com");
		BookingDetails bd = new BookingDetails(3,204,new Date(),new Date(),2,2,7000,user,hotel);
		Customer user1 = new Customer(21,"jaii","jai@gmail.com","jai007","developer","8794561230","chennai");
		Hotel hotel1= new Hotel(103,"chennai","deluxe","chennai","good",800,"deluxe@gmail.com","8974561230","9745863012","www.deluxe.com");
		BookingDetails bd1 = new BookingDetails(3,205,new Date(),new Date(),2,2,7000,user1,hotel1);
		repo.save(bd);
		repo.save(bd1);
		Iterable<BookingDetails> it= repo.findAll();
		List<BookingDetails> list = new ArrayList<>();
		for (BookingDetails b : it) {
			list.add(b);
		}
		assertThat(list.size()).isEqualTo(2);
		repo.deleteAll();
		}
    
	@Test
	void testdeleteBookingDetails() {
		Customer user = new Customer(20,"ravi","ravi@gmail.com","ravi007","developer","8794561230","chennai");
		Hotel hotel= new Hotel(103,"chennai","deluxe","chennai","good",800,"deluxe@gmail.com","8974561230","9745863012","www.deluxe.com");
		BookingDetails bd = new BookingDetails(3,204,new Date(),new Date(),2,2,7000,user,hotel);
		Customer user1 = new Customer(21,"jaii","jai@gmail.com","jai007","developer","8794561230","chennai");
		Hotel hotel1= new Hotel(103,"chennai","deluxe","chennai","good",800,"deluxe@gmail.com","8974561230","9745863012","www.deluxe.com");
		BookingDetails bd1 = new BookingDetails(3,205,new Date(),new Date(),2,2,7000,user1,hotel1);
		repo.save(bd);
		repo.save(bd1);
		repo.deleteById(4);
		Iterable<BookingDetails> it= repo.findAll();
		List<BookingDetails> list = new ArrayList<>();		
		for (BookingDetails b : it) {
			list.add(b);
		}
		assertThat(list.size()).isEqualTo(1);
		repo.deleteAll();
		}
}
