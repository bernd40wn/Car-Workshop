package pl.coderslab.tests;

import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Vehicle;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main1 {
    public static void main(String[] args) {
//        Date date = new Date();
//        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
//
//        try {
//            date = df.parse("1999-08-28");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        java.sql.Date datasql = new java.sql.Date(date.getTime());
//
//        System.out.println("crashtesty");
//        Vehicle test1 = new Vehicle("model2", "brand2", datasql, "platenumber2", datasql, 1);
//        VehicleDao.saveToDb(test1);
//        Vehicle test2 = new Vehicle("model3", "brand4", datasql, "platenumber3", datasql, 1);
//        VehicleDao.saveToDb(test2);

        Vehicle test3 = VehicleDao.loadById(8);

        System.out.println(test3);

        System.out.println("crashtesty");

        Customer cust1 = new Customer();
//        this.model = model;
//        this.brand = brand;
//        this.productionDate = productionDate;
//        this.plateNumber = plateNumber;
//        this.nextService = nextService;
//        this.customer_id = customer_id;
    }
}
