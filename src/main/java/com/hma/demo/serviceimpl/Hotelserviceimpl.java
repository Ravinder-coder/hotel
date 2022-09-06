package com.hma.demo.serviceimpl;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hma.demo.entity.Hotel;
import com.hma.demo.exception.HotelDetailsNotFoundException;
import com.hma.demo.repository.HotelRepository;
import com.hma.demo.service.hotelservice;


@Service
public class Hotelserviceimpl implements hotelservice {
	@Autowired
	private HotelRepository hrepo;

	@Override
	public List<Hotel> getHotels() throws HotelDetailsNotFoundException{
		List<Hotel> list = hrepo.findAll();
		if(list.isEmpty())
			throw new HotelDetailsNotFoundException();
		return list;
	}


	@Override
	public Hotel gethotel(int id) throws HotelDetailsNotFoundException{
		if(hrepo.findById(id).isPresent()) {
			Hotel h = hrepo.findById(id).get();
			return h;
		}
		else
			throw new HotelDetailsNotFoundException();
	}


	@Override
	public Hotel addhotel(Hotel h){
		hrepo.save(h);
		return h;
	}


	@Override
	public Hotel updatehotel(Hotel ht) throws HotelDetailsNotFoundException{
		if(hrepo.findById(ht.getHotel_id()).isPresent()) {
			hrepo.save(ht);
			return ht;
		}
		else
			throw new HotelDetailsNotFoundException();
	}


	@Override
	public String deletehotel(int hid) throws HotelDetailsNotFoundException{
		if(hrepo.findById(hid).isPresent()) {
			hrepo.deleteById(hid);
			return "Hotel details are deleted";
		}
		else
			throw new HotelDetailsNotFoundException();
	}

}
