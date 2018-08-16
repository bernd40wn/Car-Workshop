package pl.coderslab.dao;

import pl.coderslab.model.Vehicle;


import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class VehicleDao {



    public static void saveToDb(Vehicle vehicle) {
        if (vehicle.getId() == 0) {
            String query = "INSERT INTO Vehicles (model, brand, productionDate, plateNumber, nextService, customer_id) VALUES(?,?,?,?,?,?)";
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
            String query = "UPDATE Vehicles SET model = ?, brand = ?, productionDate = ?, plateNumber = ?, nextService = ?, customer_id = ? WHERE id = ?";
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
        String query = "SELECT id, model, brand, productionDate, plateNumber, nextService, customer_id FROM Vehicles";
        try {
            List<String[]> rows = DbService.getData(query, null);
            for (String[] row : rows) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(Integer.parseInt(row[0]));
                vehicle.setModel(row[1]);
                vehicle.setBrand(row[2]);
                vehicle.setProductionDate(Date.valueOf(row[3]));
                vehicle.setPlateNumber(row[4]);
                vehicle.setNextService(Date.valueOf(row[5]));
                vehicle.setCustomer_id(Integer.parseInt(row[6]));

                vehicle.setCustomer(CustomerDao.loadById(vehicle.getCustomer_id()));

                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return vehicles;
    }

    public static ArrayList<Vehicle> loadByCustomer(int id) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT id, model, brand, productionDate, plateNumber, nextService, customer_id FROM Vehicles WHERE customer_id = ?";
        try {
            ArrayList<String> params = new ArrayList<>();
            params.add(String.valueOf(id));
            List<String[]> rows = DbService.getData(query, params);
            for (String[] row : rows) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(Integer.parseInt(row[0]));
                vehicle.setModel(row[1]);
                vehicle.setBrand(row[2]);
                vehicle.setProductionDate(Date.valueOf(row[3]));
                vehicle.setPlateNumber(row[4]);
                vehicle.setNextService(Date.valueOf(row[5]));
                vehicle.setCustomer_id(Integer.parseInt(row[6]));

                vehicle.setCustomer(CustomerDao.loadById(vehicle.getCustomer_id()));

                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return vehicles;
    }

    public static Vehicle loadById(int id) {
        String query = "SELECT id, model, brand, productionDate, plateNumber, nextService, customer_id FROM Vehicles WHERE id = ?";
        try {
            ArrayList<String> params = new ArrayList<>();
            params.add(String.valueOf(id));
            List<String[]> rows = DbService.getData(query, params);
            for (String[] row : rows) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(Integer.parseInt(row[0]));
                vehicle.setModel(row[1]);
                vehicle.setBrand(row[2]);
                vehicle.setProductionDate(Date.valueOf(row[3]));
                vehicle.setPlateNumber(row[4]);
                vehicle.setNextService(Date.valueOf(row[5]));
                vehicle.setCustomer_id(Integer.parseInt(row[6]));

                vehicle.setCustomer(CustomerDao.loadById(vehicle.getCustomer_id()));

                return vehicle;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void delete(int id) {
        String query = "DELETE FROM Vehicles WHERE id =?";
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
