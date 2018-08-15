package pl.coderslab.model;

public class Employee {
    private int id = 0;
    private String name;
    private String surname;
    private String address;
    private int phonenumber;
    private String note;
    private float workhours;
    private float hourlyrate;


    public Employee() {
    }

    public Employee(String name, String surname, String address, int phonenumber, String note, float workhours, float hourlyrate) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phonenumber = phonenumber;
        this.note = note;
        this.workhours = workhours;
        this.hourlyrate = hourlyrate;
    }

    public float getHourlyrate() {
        return hourlyrate;
    }

    public Employee setHourlyrate(float hourlyrate) {
        this.hourlyrate = hourlyrate;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setWorkhours(float workhours) {
        this.workhours = workhours;
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

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public String getNote() {
        return note;
    }

    public float getWorkhours() {
        return workhours;
    }
}
