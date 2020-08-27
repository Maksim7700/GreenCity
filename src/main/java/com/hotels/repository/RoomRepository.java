package com.hotels.repository;

import org.hibernate.SessionFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hotels.model.Room;

@Repository
@Transactional
public class RoomRepository {

	@Autowired
	private SessionFactory sessionFactory;
	private static Long id_hotel;
	
	public void saveRoom(Room room) {
		sessionFactory.getCurrentSession().createNativeQuery(
				"INSERT INTO room(price, type, hotel_id) VALUES ("+room.getPrice()+",'"+room.getType()+"',"+id_hotel+");").executeUpdate();
	}
	
	public List<Room> getRoomsByHotelId(Long id) {
		id_hotel = id;
		return sessionFactory.getCurrentSession().createQuery("from Room where hotel_id =" +id).list();
		
	}
	
}
