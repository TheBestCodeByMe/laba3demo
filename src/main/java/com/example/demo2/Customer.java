package com.example.demo2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name="customer")
@NamedQuery(name = "Customer.getAll", query = "SELECT u from customer u")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;
    @Column(name = "zip", nullable = false)
    private int zip;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "firstAddress", nullable = false)
    private String firstAddress;
    @Column(name = "secondAddress", nullable = false)
    private String secondAddress;
    @Column(name = "numbFax", nullable = false)
    private int numbFax;
    @Column(name = "city", nullable = false)
    private String city;

    public Customer() {
    }

    public Customer(int zip, String name, String firstAddress, String secondAddress, int numbFax, String city) {
        this.zip = zip;
        this.name = name;
        this.firstAddress = firstAddress;
        this.secondAddress = secondAddress;
        this.numbFax = numbFax;
        this.city = city;
    }

    public Customer(long id, int zip, String name, String firstAddress, String secondAddress, int numbFax, String city) {
        this.id = id;
        this.zip = zip;
        this.name = name;
        this.firstAddress = firstAddress;
        this.secondAddress = secondAddress;
        this.numbFax = numbFax;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstAddress() {
        return firstAddress;
    }

    public void setFirstAddress(String firstAddress) {
        this.firstAddress = firstAddress;
    }

    public String getSecondAddress() {
        return secondAddress;
    }

    public void setSecondAddress(String secondAddress) {
        this.secondAddress = secondAddress;
    }

    public int getNumbFax() {
        return numbFax;
    }

    public void setNumbFax(int numbFax) {
        this.numbFax = numbFax;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
