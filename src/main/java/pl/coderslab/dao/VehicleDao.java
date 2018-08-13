package pl.coderslab.dao;

import pl.coderslab.dbservice.DbService;
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
//        if (vehicle.getId() == 0) {
//            String query = "INSERT into book(title, author, isbn) VALUES (?,?,?)";
//            poprawic query
//            List<String> params = new ArrayList<>();
//            params.add(vehicle.getTitle());
//            params.add(vehicle.getAuthor());
//            params.add(vehicle.getIsbn());
//            try {
//                Integer id = DbService.insertIntoDatabase(query, params);
//                if (id != null) {
//                    vehicle.setId(id);
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
    }

//    public static void deleteVehicle(int id) throws SQLException {
////        String query = "DELETE from book where id = ?";
//        List<String> params = new ArrayList<>();
//        params.add(String.valueOf(id));
//        DbService.executeUpdate(query, params);
//
//
//    }
}
