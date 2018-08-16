package pl.coderslab.dao;

import pl.coderslab.model.Order;


import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    public static void saveToDb(Order order) {
        if (order.getId() == 0) {
            String query = "INSERT INTO Orders (admissionDate, plannedServiceDate, serviceDate, carProblemDescription, carFixDescription, " +
                    "fixCosts, partsCosts, customer_id, employee_id, vehicle_id, status_id)" +
                    " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            List<String> params = new ArrayList<>();
            params.add(String.valueOf(order.getAdmissionDate()));
            params.add(String.valueOf(order.getPlannedServiceDate()));
            params.add(String.valueOf(order.getServiceDate()));
            params.add(order.getCarProblemDescription());
            params.add(order.getCarFixDescription());
            params.add(String.valueOf(order.getFixCosts()));
            params.add(String.valueOf(order.getPartsCosts()));
            //referencje na inne tabele

            params.add(String.valueOf(order.getCustomerId()));
            params.add(String.valueOf(order.getEmployeeId()));
            params.add(String.valueOf(order.getVehicleId()));
            params.add(String.valueOf(order.getStatusId()));
            try {
                Integer id = DbService.insertIntoDatabase(query, params);
                if (id != null) {
                    order.setId(id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            String query = "UPDATE Orders SET admissionDate = ? , plannedServiceDate = ? , serviceDate = ? , carProblemDescription = ? , carFixDescription = ? , " +
                    "fixCosts = ? , partsCosts = ? , customer_id = ? , employee_id = ? , vehicle_id = ? , status_id = ? WHERE id = ?";
            List<String> params = new ArrayList<>();
            params.add(String.valueOf(order.getAdmissionDate()));
            params.add(String.valueOf(order.getPlannedServiceDate()));
            params.add(String.valueOf(order.getServiceDate()));
            params.add(order.getCarProblemDescription());
            params.add(order.getCarFixDescription());
            params.add(String.valueOf(order.getFixCosts()));
            params.add(String.valueOf(order.getPartsCosts()));
            //referencje na inne tabele

            params.add(String.valueOf(order.getCustomerId()));
            params.add(String.valueOf(order.getEmployeeId()));
            params.add(String.valueOf(order.getVehicleId()));
            params.add(String.valueOf(order.getStatusId()));

            params.add(String.valueOf(order.getId()));
            try {
                DbService.executeUpdate(query, params);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    public static ArrayList<Order> loadAll() {
        ArrayList<Order> orders = new ArrayList<>();
        String query = "SELECT id, admissionDate, plannedServiceDate, serviceDate, carProblemDescription, carFixDescription, " +
                "fixCosts, partsCosts, customer_id, employee_id, vehicle_id, status_id FROM Orders";
        try {
            List<String[]> rows = DbService.getData(query, null);
            for (String[] row : rows) {
                Order order = new Order();
                order.setId(Integer.parseInt(row[0]));
                order.setAdmissionDate(Date.valueOf(row[1]));
                order.setPlannedServiceDate(Date.valueOf(row[2]));
                order.setServiceDate(Date.valueOf(row[3]));
                order.setCarProblemDescription(row[4]);
                order.setCarFixDescription(row[5]);
                order.setFixCosts(Float.parseFloat(row[6]));
                order.setPartsCosts(Float.parseFloat(row[7]));
                //referencje z innych tablic

                order.setCustomerId(Integer.parseInt(row[8]));
                order.setEmployeeId(Integer.parseInt(row[9]));
                order.setVehicleId(Integer.parseInt(row[10]));
                order.setStatusId(Integer.parseInt(row[11]));

                //wczytanie i dodanie obiektow
                order.setEmployee(EmployeeDao.loadById(order.getEmployeeId()));
                order.setStatus(StatusDao.loadById(order.getStatusId()));
                order.setVehicle(VehicleDao.loadById(order.getVehicleId()));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return orders;
    }

    public static ArrayList<Order> loadByEmployee(int id) {
        ArrayList<Order> orders = new ArrayList<>();
        String query = "SELECT id, admissionDate, plannedServiceDate, serviceDate, carProblemDescription, carFixDescription, " +
                "fixCosts, partsCosts, customer_id, employee_id, vehicle_id, status_id FROM Orders WHERE employee_id = ?";
        try {
            ArrayList<String> params = new ArrayList<>();
            params.add(String.valueOf(id));
            List<String[]> rows = DbService.getData(query, params);
            for (String[] row : rows) {
                Order order = new Order();
                order.setId(Integer.parseInt(row[0]));
                order.setAdmissionDate(Date.valueOf(row[1]));
                order.setPlannedServiceDate(Date.valueOf(row[2]));
                order.setServiceDate(Date.valueOf(row[3]));
                order.setCarProblemDescription(row[4]);
                order.setCarFixDescription(row[5]);
                order.setFixCosts(Float.parseFloat(row[6]));
                order.setPartsCosts(Float.parseFloat(row[7]));
                //referencje z innych tablic

                order.setCustomerId(Integer.parseInt(row[8]));
                order.setEmployeeId(Integer.parseInt(row[9]));
                order.setVehicleId(Integer.parseInt(row[10]));
                order.setStatusId(Integer.parseInt(row[11]));

                //wczytanie i dodanie obiektow
                order.setEmployee(EmployeeDao.loadById(order.getEmployeeId()));
                order.setStatus(StatusDao.loadById(order.getStatusId()));
                order.setVehicle(VehicleDao.loadById(order.getVehicleId()));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return orders;
    }

    public static Order loadById(int id) {
        String query = "SELECT id, admissionDate, plannedServiceDate, serviceDate, carProblemDescription, carFixDescription, " +
                "fixCosts, partsCosts, customer_id, employee_id, vehicle_id, status_id FROM Orders WHERE id = ?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        try {
            List<String[]> rows = DbService.getData(query, params);
            for (String[] row : rows) {
                Order order = new Order();
                order.setId(Integer.parseInt(row[0]));
                order.setAdmissionDate(Date.valueOf(row[1]));
                order.setPlannedServiceDate(Date.valueOf(row[2]));
                order.setServiceDate(Date.valueOf(row[3]));
                //Employee empleyee

                order.setCarProblemDescription(row[4]);
                order.setCarFixDescription(row[5]);
                //Status status
                //Vehicle vehicle

                order.setFixCosts(Float.parseFloat(row[6]));
                order.setPartsCosts(Float.parseFloat(row[7]));
                //referencje z innych tablic

                order.setCustomerId(Integer.parseInt(row[8]));
                order.setEmployeeId(Integer.parseInt(row[9]));
                order.setVehicleId(Integer.parseInt(row[10]));
                order.setStatusId(Integer.parseInt(row[11]));

                //wczytanie i dodanie obiektow (brauej mi customer i employee
                order.setEmployee(EmployeeDao.loadById(order.getEmployeeId()));
                order.setStatus(StatusDao.loadById(order.getStatusId()));
                order.setVehicle(VehicleDao.loadById(order.getVehicleId()));
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    public static void delete(int id) {
        String query = "DELETE FROM Orders WHERE id = ?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        try {
            int affectedRows = DbService.executeUpdate(query, params);
            if (affectedRows > 0) {
                System.out.println("Usunalem zamowienie o id: " + id);
            } else {
                System.out.println("Operacja usuniecia zamowienia zakonczyla sie niepowodzeniem");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
