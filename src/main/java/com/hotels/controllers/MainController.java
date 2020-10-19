package com.hotels.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hotels.model.Country;
import com.hotels.model.Hotel;
import com.hotels.model.Room;
import com.hotels.services.CountryService;
import com.hotels.services.HotelService;
import com.hotels.services.RoomService;

@Controller
@ComponentScan({ "com.hotels.services" })
public class MainController {

	private static Long id_country;
	private static Long id_hotel;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RoomService roomService;
	//_____________________________________________________________Countries_________________________	
	@GetMapping	
	public String homeCountries(@ModelAttribute("country") Country country,
			Model model) {
		model.addAttribute("countries", countryService.getCountries());
		return "home-page";
	}

	@PostMapping
	public String getCountries(@ModelAttribute("country") Country country) {
		countryService.save(country);
		System.out.println(country);
		return "redirect:/";
	}
	//______________________________________________________________Hotels________________________
	@GetMapping("/country/{id}")
	public String homeCountryHotels(@ModelAttribute("hotel") Hotel hotel,
			@PathVariable Long id,
			Model model) {
		id_country = id;
		List<Hotel> hotels = hotelService.getHotelsById(id);
		System.out.println(hotels);
		model.addAttribute("hotels", hotels);
		return "country-hotels";
	}
	
	@PostMapping("/country/{id}")
	public String getCountryHotels(@ModelAttribute("hotel") Hotel hotel,
			@PathVariable Long id) {
		hotelService.save(hotel);
		System.out.println(hotel);
		return "redirect:/country/" + id_country;
	}
	//_______________________________________________________________Rooms_______________________
	
	@GetMapping("/country/hotel/rooms/{id}")
	public String homeCountryHotelRooms(@ModelAttribute("room") Room room,
			@PathVariable Long id,
			Model model) {
		id_hotel = id;
		model.addAttribute("rooms", roomService.getRoomsById(id));
		return "country-hotel-rooms";
	}
	
	@PostMapping("/country/hotel/rooms/{id}")
	public String getCountryHotelRooms(@ModelAttribute("room") Room room,
			@PathVariable Long id) {
		roomService.save(room);
		return "redirect:/country/hotel/rooms/" + id_hotel;
	}
	
	@GetMapping("/search")
	public String search(@PathVariable String name, Model model) {
		model.addAttribute("hotels", countryService.getCountryByName(name));
		
		return "search-page";
	}
}
