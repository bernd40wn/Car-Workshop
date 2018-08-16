package pl.coderslab.model;

import java.sql.Date;

public class Vehicle {
    private int id=0;
    private String model;
    private String brand;
    private Date productionDate;
    private String plateNumber;
    private Date nextService;
    Customer customer;
    private int customer_id;

    public Vehicle() {
    }

    public Vehicle(String model, String brand, Date productionDate, String plateNumber, Date nextService, Customer customer, int customer_id) {
        this.model = model;
        this.brand = brand;
        this.productionDate = productionDate;
        this.plateNumber = plateNumber;
        this.nextService = nextService;
        this.customer = customer;
        this.customer_id = customer_id;

    }

    public Vehicle(int id, String model, String brand, Date productionDate, String plateNumber, Date nextService, int customer_id) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.productionDate = productionDate;
        this.plateNumber = plateNumber;
        this.nextService = nextService;
        this.customer_id = customer_id;
    }


    public int getId() {
        return id;
    }

    public Vehicle setId(int id) {
        this.id = id;
        return this;
    }

    public Vehicle setModel(String model) {
        this.model = model;
        return this;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public Vehicle setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public Vehicle setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
        return this;
    }

    public Vehicle setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
        return this;
    }

    public Vehicle setNextService(Date nextService) {
        this.nextService = nextService;
        return this;
    }

    public Vehicle setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
        return this;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public Date getNextService() {
        return nextService;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }
}
