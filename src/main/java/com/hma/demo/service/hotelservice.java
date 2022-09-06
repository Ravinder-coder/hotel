package com.hma.demo.service;



import java.util.List;

import com.hma.demo.entity.Hotel;
import com.hma.demo.exception.HotelDetailsNotFoundException; 



public interface hotelservice  {

	

	public List<Hotel> getHotels() throws HotelDetailsNotFoundException;

	public Hotel gethotel(int id) throws HotelDetailsNotFoundException;

	public Hotel addhotel(Hotel htl);

	public Hotel updatehotel(Hotel ht) throws HotelDetailsNotFoundException;

	public String deletehotel(int parseInt) throws HotelDetailsNotFoundException;
	


}
