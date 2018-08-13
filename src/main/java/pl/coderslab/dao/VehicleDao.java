package pl.coderslab.dao;

import pl.coderslab.model.Vehicle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.awt.print.Book;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {

    private static DataSource ds;


    public static Connection getConn() throws SQLException {
        return getInstance().getConnection();
    }

    private static DataSource getInstance() {
        if (ds == null) {
            try {
                Context ctx = new InitialContext();
                ds = (DataSource) ctx.lookup("java:comp/env/jdbc/school");
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return ds;
    }


    public static void saveToDb(Vehicle vehicle) {

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
