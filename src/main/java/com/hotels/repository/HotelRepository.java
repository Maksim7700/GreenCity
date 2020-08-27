package com.hotels.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hotels.model.Hotel;

@Repository
@Transactional
public class HotelRepository {

	@Autowired
	private SessionFactory sessionFactory;
	private static Long id_country;
	public void saveHotel(Hotel hotel) {
		sessionFactory.getCurrentSession().createNativeQuery(
				"INSERT INTO Hotel(name, stars, country_id) VALUES ('"+hotel.getName()+"',"+hotel.getStars()+","+id_country+");").executeUpdate();
		
	}
	
	public List<Hotel> getHotelsByCountryId(Long id) {
		id_country = id;
		return sessionFactory.getCurrentSession().createQuery("from Hotel where country_id = "+id).list();
	}
	
}
