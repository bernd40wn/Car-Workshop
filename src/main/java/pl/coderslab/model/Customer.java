package pl.coderslab.model;

import java.sql.Date;



public class Customer {
    private int id = 0;
    private String name;
    private String surname;
    private Date birthday;
    private int phonenumber;
    private String address;


    public Customer() {
    }

    public Customer(String name, String surname, Date birthday, int phonenumber, String adress) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.phonenumber = phonenumber;
        this.address = adress;
    }

    public Customer(int id, String name, String surname, Date birthday, int phonenumber, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.phonenumber = phonenumber;
        this.address = address;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }
}


