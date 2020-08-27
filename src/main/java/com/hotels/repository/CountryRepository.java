package com.hotels.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.hotels.model.Country;

@Repository
@Transactional
public class CountryRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveCountry(Country country) {
		sessionFactory.getCurrentSession().save(country);
	}
	
	public List<Country> countryList() {
		return sessionFactory.getCurrentSession().createQuery("from Country").list();
	}
	
	
	
}
