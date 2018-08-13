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




}
