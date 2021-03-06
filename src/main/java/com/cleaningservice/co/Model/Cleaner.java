package com.cleaningservice.co.Model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Cleaners")
public class Cleaner {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    private long phone_no;
    private String email;
    private String cityOfService;
    private double rating;
    //@Transient
    @ElementCollection
   // @JoinColumn(name = "name", nullable = false)
    private List<String> customers = new ArrayList<>();


    public Cleaner(int id, String name, long phone_no, String email, String cityOfService, double rating) {
        this.id = id;
        this.name = name;
        this.phone_no = phone_no;
        this.email = email;
        this.cityOfService = cityOfService;
        this.rating = rating;
    }

    public Cleaner() {
    }


    public List<String> getCustomers() {
        return customers;
    }

    public boolean bookService(String customer) {
        if (customer == null) return false;
        if(!this.customers.contains(customer)){
            customers.add(customer);
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(long phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCityOfService() {
        return cityOfService;
    }

    public void setCityOfService(String cityOfService) {
        this.cityOfService = cityOfService;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {


        if (o == this) {
            return true;
        }


        if (!(o instanceof Cleaner)) {
            return false;
        }

        Cleaner c = (Cleaner) o;

        // Compare the objects name and phone number
        return c.getName().equals(this.getName()) && c.getPhone_no() == this.getPhone_no();
    }
}
