package com.hma.demo.service;

import java.util.List;

import com.hma.demo.entity.RoomDetails;
import com.hma.demo.exception.RoomDetailsNotFoundException;

public interface RoomDetailsService {

	public String addRoomDetails(RoomDetails room);
	public String updateRoomDetails(RoomDetails room) throws RoomDetailsNotFoundException;
	public String removeRoomDetails(Integer rid) throws RoomDetailsNotFoundException;
	public List<RoomDetails> showAllRoomDetails() throws RoomDetailsNotFoundException;
	public  RoomDetails showRoomDetails(Integer id) throws RoomDetailsNotFoundException;
}
