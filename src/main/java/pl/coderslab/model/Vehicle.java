package pl.coderslab.model;

import java.util.Date;

public class Vehicle {
    int id;
    private String model;
    private String brand;
    private int productionDate;
    private String plateNumber;
    private Date nextService;

    public Vehicle() {
    }

    public Vehicle(String model, String brand, int productionDate, String plateNumber, Date nextService) {
        this.model = model;
        this.brand = brand;
        this.productionDate = productionDate;
        this.plateNumber = plateNumber;
        this.nextService = nextService;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getProductionDate() {
        return productionDate;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public Date getNextService() {
        return nextService;
    }
}
