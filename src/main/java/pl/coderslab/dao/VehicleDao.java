package pl.coderslab.dao;

import pl.coderslab.model.Vehicle;


import java.sql.SQLException;
import java.util.ArrayList;


public class VehicleDao {


    public static void saveToDb(Vehicle vehicle) {
        System.out.println("gmm");
        System.out.println("test2");
    }

    public static void deleteVehicle(int id) throws SQLException {

    }

    public static ArrayList<Vehicle> loadAll() {
        return null;
    }
    public static Vehicle loadById(int id) {
        return null;
    }
}
