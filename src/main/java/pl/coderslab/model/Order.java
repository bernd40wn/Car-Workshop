package pl.coderslab.model;

import java.time.temporal.ValueRange;
import java.util.Date;

public class Order {
    int id;
    private Date admissionDate;
    private Date plannedServiceDate;
    private Date serviceDate;
    private Employee employee;

    private String carProblemDescription;
    private String carFixDescription;

    private Status status;
    private Vehicle vehicle;

    private float fixCosts;
    private float partsCosts;


    public Order() {
    }

    public Order(Date admissionDate, Date plannedServiceDate, Date serviceDate, Employee employee, String carProblemDescription, String carFixDescription, Status status, Vehicle vehicle, float fixCosts, float partsCosts) {
        this.admissionDate = admissionDate;
        this.plannedServiceDate = plannedServiceDate;
        this.serviceDate = serviceDate;
        this.employee = employee;
        this.carProblemDescription = carProblemDescription;
        this.carFixDescription = carFixDescription;
        this.status = status;
        this.vehicle = vehicle;
        this.fixCosts = fixCosts;
        this.partsCosts = partsCosts;
    }

    public int getId() {
        return id;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public Order setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
        return this;
    }

    public Date getPlannedServiceDate() {
        return plannedServiceDate;
    }

    public Order setPlannedServiceDate(Date plannedServiceDate) {
        this.plannedServiceDate = plannedServiceDate;
        return this;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public Order setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
        return this;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Order setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public String getCarProblemDescription() {
        return carProblemDescription;
    }

    public Order setCarProblemDescription(String carProblemDescription) {
        this.carProblemDescription = carProblemDescription;
        return this;
    }

    public String getCarFixDescription() {
        return carFixDescription;
    }

    public Order setCarFixDescription(String carFixDescription) {
        this.carFixDescription = carFixDescription;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Order setStatus(Status status) {
        this.status = status;
        return this;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Order setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public float getFixCosts() {
        return fixCosts;
    }

    public Order setFixCosts(float fixCosts) {
        this.fixCosts = fixCosts;
        return this;
    }

    public float getPartsCosts() {
        return partsCosts;
    }

    public Order setPartsCosts(float partsCosts) {
        this.partsCosts = partsCosts;
        return this;
    }
}


