package pl.coderslab.model;

public class Employee {
    private int id = 0;
    private String name;
    private String surname;
    private String adress;
    private int phonenumber;
    private String note;
    private float workhours;


    public Employee() {
    }

    public Employee(String name, String surname, String adress, int phonenumber, String note, float workhours) {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.phonenumber = phonenumber;
        this.note = note;
        this.workhours = workhours;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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

    public String getAdress() {
        return adress;
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
