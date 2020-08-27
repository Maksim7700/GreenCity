package com.hotels.services;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.hotels.model.Country;
import com.hotels.repository.CountryRepository;

@Service
@ComponentScan({"com.hotels.repository"})
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	public void save(Country country) {
		countryRepository.saveCountry(country);
	}
	
	public List<Country> getCountries() {
		List<Country> list = new ArrayList<>();
		 Stream<Country> s = list.stream().filter(name -> name.getCountry().startsWith(""));
		return countryRepository.countryList();
	}
	
	public List<Country> getCountryByName(String name) {
		List<Country> list = countryRepository.countryList();
		List<Country> s = list.stream().filter(x -> x.getCountry().startsWith(name)).collect(Collectors.toList());
		System.out.println(list.toString());
		return s;
	}
	
}
