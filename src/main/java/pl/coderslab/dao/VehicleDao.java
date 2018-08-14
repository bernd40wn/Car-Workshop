package pl.coderslab.dao;

import pl.coderslab.model.Vehicle;


import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class VehicleDao {



    public static void saveToDb(Vehicle vehicle) {
        if (vehicle.getId() == 0) {
            String query = "INSERT INTO Vehicle (model, brand, productionDate, plateNumber, nextService, customer_id) VALUES(?,?,?,?,?,?)";
            List<String> params = new ArrayList<>();
            params.add(vehicle.getModel());
            params.add(vehicle.getBrand());
            params.add(String.valueOf(vehicle.getProductionDate()));
            params.add(vehicle.getPlateNumber());
            params.add(String.valueOf(vehicle.getNextService()));
            params.add(String.valueOf(vehicle.getCustomer_id()));


            try {
                Integer id = DbService.insertIntoDatabase(query, params);
                if (id != null) {
                    vehicle.setId(id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            String query = "UPDATE Vehicle SET model = ?, brand = ?, productionDate = ?, plateNumber = ?, nextService = ?, customer_id = ? WHERE id = ?";
            List<String> params = new ArrayList<>();
            params.add(vehicle.getModel());
            params.add(vehicle.getBrand());
            params.add(String.valueOf(vehicle.getProductionDate()));
            params.add(vehicle.getPlateNumber());
            params.add(String.valueOf(vehicle.getNextService()));
            params.add(String.valueOf(vehicle.getCustomer_id()));

            params.add(String.valueOf(vehicle.getId()));
            try {
                DbService.executeUpdate(query, params);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<Vehicle> loadAll() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT id, model, brand, productionDate, plateNumber, nextService, customer_id FROM Vehicle";
        try {
            List<String[]> rows = DbService.getData(query, null);
            for (String[] row : rows) {
                DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
                Vehicle vehicle = new Vehicle();
                vehicle.setId(Integer.parseInt(row[0]));
                vehicle.setModel(row[1]);
                vehicle.setBrand(row[2]);
                vehicle.setProductionDate(df.parse(row[3]));
                vehicle.setPlateNumber(row[4]);
                vehicle.setProductionDate(df.parse(row[5]));
                vehicle.setCustomer_id(Integer.parseInt(row[6]));
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public static Vehicle loadById(int id) {
        String query = "SELECT id, model, brand, productionDate, plateNumber, nextService, customer_id FROM Vehicle WHERE id = ?";
        try {
            ArrayList<String> params = new ArrayList<>();
            params.add(String.valueOf(id));
            List<String[]> rows = DbService.getData(query, params);
            for (String[] row : rows) {
                DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
                Vehicle vehicle = new Vehicle();
                vehicle.setId(Integer.parseInt(row[0]));
                vehicle.setModel(row[1]);
                vehicle.setBrand(row[2]);
                vehicle.setProductionDate(df.parse(row[3]));
                vehicle.setPlateNumber(row[4]);
                vehicle.setProductionDate(df.parse(row[5]));
                vehicle.setCustomer_id(Integer.parseInt(row[6]));
                return vehicle;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void delete(int id) {
        String query = "DELETE FROM Vehicle WHERE id =?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        try {
            int affectedRows = DbService.executeUpdate(query, params);
            if (affectedRows > 0) {
                System.out.println("Usunalem pojazd o id: " + id);
            } else {
                System.out.println("Operacja usuniecia zadania zakonczyla sie niepowodzeniem");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
