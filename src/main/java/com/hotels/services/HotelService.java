package com.hotels.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.hotels.model.Hotel;
import com.hotels.repository.HotelRepository;

@Service
@ComponentScan("com.hotels.repository")
public class HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	public void save(Hotel hotel) {
		hotelRepository.saveHotel(hotel);
	}
	
	public List<Hotel> getHotelsById(Long id) {
		return hotelRepository.getHotelsByCountryId(id);
	}

}
