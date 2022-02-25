package com.cleaningservice.co.Model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    private int id;
    private String name;
    private String cityOfResidence;
    private long phone_no;
    private String email;
    @Transient
    private Cleaner cleaner;

    public Customer(int id, String name, String cityOfResidence, long phone_no, String email) {
        this.id = id;
        this.name = name;
        this.cityOfResidence = cityOfResidence;
        this.phone_no = phone_no;
        this.email = email;
    }

    public Cleaner getCleaner() {
        return cleaner;
    }

    public void setCleaner(Cleaner cleaner) {
        this.cleaner = cleaner;
    }

    public Customer() {
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

    public String getCityOfResidence() {
        return cityOfResidence;
    }

    public void setCityOfResidence(String cityOfResidence) {
        this.cityOfResidence = cityOfResidence;
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

    @Override
    public boolean equals(Object o) {


        if (o == this) {
            return true;
        }


        if (!(o instanceof Customer)) {
            return false;
        }


        Customer c = (Customer) o;


        return c.getName().equals(this.getName()) && c.getPhone_no() == this.getPhone_no();
    }
}
