package com.travelagency.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ace on 07/06/2017.
 */
@Entity
@Table(name = "hotels", schema = "travel_agency")
public class HotelEntity {
    private int id;
    private String hotelname;
    private String country;
    private String city;
    private Integer freeRooms;
    private Byte availability;

    private List<OrderEntity> orders;

    public HotelEntity(String hotelname, String country, String city, Integer freeRooms, Byte availability) {
        this.hotelname = hotelname;
        this.country = country;
        this.city = city;
        this.freeRooms = freeRooms;
        this.availability = availability;
    }

    public HotelEntity() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "hotelname")
    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "free_rooms")
    public Integer getFreeRooms() {
        return freeRooms;
    }

    public void setFreeRooms(Integer freeRooms) {
        this.freeRooms = freeRooms;
    }

    @Basic
    @Column(name = "availability")
    public Byte getAvailability() {
        return availability;
    }

    public void setAvailability(Byte availability) {
        this.availability = availability;
    }

    @OneToMany(mappedBy = "hotel")
    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotelEntity that = (HotelEntity) o;

        return id == that.id && (hotelname != null ? hotelname.equals(that.hotelname) : that.hotelname == null)
                && (country != null ? country.equals(that.country) : that.country == null)
                && (city != null ? city.equals(that.city) : that.city == null)
                && (freeRooms != null ? freeRooms.equals(that.freeRooms) : that.freeRooms == null)
                && (availability != null ? availability.equals(that.availability) : that.availability == null);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (hotelname != null ? hotelname.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (freeRooms != null ? freeRooms.hashCode() : 0);
        result = 31 * result + (availability != null ? availability.hashCode() : 0);
        return result;
    }
}
