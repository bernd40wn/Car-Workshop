package pl.coderslab.tests;

import pl.coderslab.dao.*;
import pl.coderslab.model.*;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class main1 {
    public static void main(String[] args) {
        Date date = new Date();
        Date date2 = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");

        try {
            date = df.parse("1999-08-28");
            date2 = df.parse("2018-08-30");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date datasql1 = new java.sql.Date(date.getTime());
        java.sql.Date datasql2 = new java.sql.Date(date2.getTime());

        Customer customer1 = new Customer("Jacek", "Wroblewski", datasql1, 870876890, "Warszawa Prosta 51");

//        CustomerDao.saveToDb(customer1);
        ArrayList<Customer> customers = CustomerDao.loadAll();
        Customer custtomer2 = CustomerDao.loadById(1);
        CustomerDao.delete(1);

        //    private String name;
        //    private String surename;
        //    private Date birthday;
        //    private int phonenumber;
        //    private String adress;

        System.out.println("dodalem klienta");

        Employee employee1 = new Employee("Jan", "Kowalski", "Warszawa Krzywa 15", 999888777, "SuperMechanik i w ogole zajbiscie", 29.5f, 20.5f);

       // EmployeeDao.saveToDb(employee1);
        ArrayList<Employee> employees = EmployeeDao.loadAll();
        Employee employee = EmployeeDao.loadById(1);
        EmployeeDao.delete(5);


        //    private String name;
        //    private String surname;
        //    private String adress;
        //    private int phonenumber;
        //    private String note;
        //    private float workhours;

        System.out.println("dodalem pracownika");

        Status status1 = new Status("Przyjęty");

//        StatusDao.saveToDb(status1);
//        Przyjęty
//        Zatwierdzone koszty naprawy
//        W naprawie
//        Gotowy do odbioru
//                Rezygnacja


        //    private String status;

        System.out.println("dodalem status");

        Vehicle vehicle1 = new Vehicle("f50", "ferrari", datasql1, "ZaSzybkiZaWsciekly", datasql2, customer1, 1);

//        VehicleDao.saveToDb(vehicle1);
        ArrayList<Vehicle> vehicles = VehicleDao.loadAll();
        Vehicle vehicle = VehicleDao.loadById(1);

        VehicleDao.delete(2);

        //    private String model;
        //    private String brand;
        //    private Date productionDate;
        //    private String plateNumber;
        //    private Date nextService;
        //    private int customer_id;

        System.out.println("dodalem pojazd");

        Order order1 = new Order(datasql1,datasql2,datasql2,employee1,"samochod nie uruchamia sie", "wymienic rozrusznik", status1, vehicle1,399.99f,250.69f,1,1,1,1);

//        OrderDao.saveToDb(order1);
        ArrayList<Order> orders = OrderDao.loadAll();
        Order order = OrderDao.loadById(1);
        OrderDao.delete(1);

//        private java.sql.Date admissionDate;
//        private java.sql.Date plannedServiceDate;
//        private java.sql.Date serviceDate;
//        private Employee employee;
//
//        private String carProblemDescription;
//        private String carFixDescription;
//
//        private Status status;
//        private Vehicle vehicle;
//
//        private float fixCosts;
//        private float partsCosts;
//        private int customer_id;
//        private int employee_id;
//        private int vehicle_id;
//        private int status_id;

        System.out.println("dodalem zamowienie");


//
//        System.out.println("crashtesty");
//        Vehicle test1 = new Vehicle("model2", "brand2", datasql, "platenumber2", datasql, 1);
//        VehicleDao.saveToDb(test1);
//        Vehicle test2 = new Vehicle("model3", "brand4", datasql, "platenumber3", datasql, 1);
//        VehicleDao.saveToDb(test2);

//        this.model = model;
//        this.brand = brand;
//        this.productionDate = productionDate;
//        this.plateNumber = plateNumber;
//        this.nextService = nextService;
//        this.customer_id = customer_id;
    }
}
