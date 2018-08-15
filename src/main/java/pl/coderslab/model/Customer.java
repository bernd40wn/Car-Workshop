package pl.coderslab.model;

import java.sql.Date;



public class Customer {
    private int id = 0;
    private String name;
    private String surename;
    private Date birthday;
    private int phonenumber;
    private String address;


    public Customer() {
    }

    public Customer(String name, String surename, Date birthday, int phonenumber, String adress) {
        this.name = name;
        this.surename = surename;
        this.birthday = birthday;
        this.phonenumber = phonenumber;
        this.address = adress;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }
}


