package com.travelagency.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ace on 07/06/2017.
 */
@Entity
@Table(name = "orders", schema = "travel_agency")
public class OrderEntity {
    private int id;
    private Date dateIn;
    private Date dateOut;

    private CustomerEntity customer;
    private HotelEntity hotel;

    public OrderEntity(Date dateIn, Date dateOut, CustomerEntity customer, HotelEntity hotel) {
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.customer = customer;
        this.hotel = hotel;
    }

    public OrderEntity() {
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
    @Column(name = "date_in")
    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    @Basic
    @Column(name = "date_out")
    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id")
    public HotelEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        return id == that.id && (dateIn != null ? dateIn.equals(that.dateIn) : that.dateIn == null)
                && (dateOut != null ? dateOut.equals(that.dateOut) : that.dateOut == null);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dateIn != null ? dateIn.hashCode() : 0);
        result = 31 * result + (dateOut != null ? dateOut.hashCode() : 0);
        return result;
    }
}
