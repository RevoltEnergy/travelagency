package com.travelagency.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ace on 07/06/2017.
 */
@Entity
@Table(name = "customers", schema = "travel_agency")
public class CustomerEntity {
    private int id;
    private String firstname;
    private String lastname;

    private List<OrderEntity> orders;

    public CustomerEntity(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    private String searchCustomer;

    public String getSearchCustomer() {
        return searchCustomer;
    }

    public void setSearchCustomer(String searchCustomer) {
        this.searchCustomer = searchCustomer;
    }

    public CustomerEntity() {
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
    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
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

        CustomerEntity that = (CustomerEntity) o;

        return id == that.id && (firstname != null ? firstname.equals(that.firstname) : that.firstname == null)
                && (lastname != null ? lastname.equals(that.lastname) : that.lastname == null);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return id + " " + firstname + " " + lastname + ".";
    }
}
