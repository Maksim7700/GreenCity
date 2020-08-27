package com.hotels.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.hotels.model.Room;
import com.hotels.repository.RoomRepository;

@Service
@ComponentScan("com.hotels.repository")
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;
	
	public void save(Room room) {
		roomRepository.saveRoom(room);
	}
	
	public List<Room> getRoomsById(Long id) {
		return roomRepository.getRoomsByHotelId(id);
	}
	
}
