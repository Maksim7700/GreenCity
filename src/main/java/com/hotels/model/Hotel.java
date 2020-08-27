package com.hotels.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Hotel {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    
	    private int stars;

	    

	    @OneToMany(targetEntity = Room.class, cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	    @JoinColumn(name="hotel_id",  referencedColumnName = "id")
	    private List<Room> rooms = new ArrayList<>();

	    public Hotel() {
	    }

	    public Hotel(int stars, String name, List<Room> rooms) {
	        this.stars = stars;
	        this.name = name;
	        this.rooms = rooms;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public int getStars() {
	        return stars;
	    }

	    public void setStars(int stars) {
	        this.stars = stars;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public List<Room> getRooms() {
	        return rooms;
	    }

	    public void setRooms(List<Room> rooms) {
	        this.rooms = rooms;
	    }

	    @Override
	    public boolean equals(Object object) {
	        if (this == object) return true;
	        if (object == null || getClass() != object.getClass()) return false;
	        Hotel hotel = (Hotel) object;
	        return stars == hotel.stars &&
	                Objects.equals(id, hotel.id) &&
	                Objects.equals(rooms, hotel.rooms);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(id, stars,rooms);
	    }

	    @Override
	    public String toString() {
	        return "Hotel{" +
	                "id=" + id +
	                ", stars=" + stars +
	                ", name =" + name +
	                ", rooms=" + rooms +
	                '}';
	    }
}

