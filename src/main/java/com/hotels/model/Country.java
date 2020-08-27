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
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;

    @OneToMany(targetEntity = Hotel.class, cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="country_id",  referencedColumnName = "id")
    private List<Hotel> hotels = new ArrayList<>();

    public Country() {
    }

    public Country(String country, List<Hotel> hotels) {
        this.country = country;
        this.hotels = hotels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Country country1 = (Country) object;
        return Objects.equals(id, country1.id) &&
                Objects.equals(country, country1.country) &&
                Objects.equals(hotels, country1.hotels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, hotels);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", hotels=" + hotels +
                '}';
    }
}