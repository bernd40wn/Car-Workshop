package pl.coderslab.dao;

import pl.coderslab.model.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    public static void saveToDb(Employee employee) {
        if (employee.getId() == 0) {
            String query = "INSERT INTO Employees (name, surname, address, phonenumber, note, workhours, hourlyrate ) VALUES(?,?,?,?,?,?,?)";
            List<String> params = new ArrayList<>();
            params.add(employee.getName());
            params.add(employee.getSurname());
            params.add(employee.getAddress());
            params.add(String.valueOf(employee.getPhonenumber()));
            params.add(employee.getNote());
            params.add(String.valueOf(employee.getWorkhours()));
            params.add(String.valueOf(employee.getHourlyrate()));
            try {
                Integer id = DbService.insertIntoDatabase(query, params);
                if (id != null) {
                    employee.setId(id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        } else {
            String query = "UPDATE Employees SET name = ?, surname = ?, address = ?, phonenumber = ?, note = ?, workhours = ?, hourlyrate = ? WHERE id = ?";
            List<String> params = new ArrayList<>();
            params.add(employee.getName());
            params.add(employee.getSurname());
            params.add(employee.getAddress());
            params.add(String.valueOf(employee.getPhonenumber()));
            params.add(employee.getNote());
            params.add(String.valueOf(employee.getWorkhours()));
            params.add(String.valueOf(employee.getHourlyrate()));

            params.add(String.valueOf(employee.getId()));
            try {
                DbService.executeUpdate(query, params);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public static void delete(int id) {
        String query = "DELETE FROM Employees WHERE id =?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        try {
            int affectedRows = DbService.executeUpdate(query, params);
            if (affectedRows > 0) {
                System.out.println("Usunalem pracownika o id: " + id);
            } else {
                System.out.println("Operacja usuniecia zadania zakonczyla sie niepowodzeniem");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Employee> loadAll() {

        ArrayList<Employee> employees = new ArrayList<>();
        String query = "SELECT id, name, surname, address, phonenumber, note, workhours, hourlyrate FROM Employees";
        try {
            List<String[]> rows = DbService.getData(query, null);
            for (String[] row : rows) {
                Employee employee = new Employee();
                employee.setId(Integer.parseInt(row[0]));
                employee.setName(row[1]);
                employee.setSurname(row[2]);
                employee.setAddress(row[3]);
                employee.setPhonenumber(Integer.parseInt(row[4]));
                employee.setNote(row[5]);
                employee.setWorkhours(Float.parseFloat(row[6]));
                employee.setHourlyrate(Float.parseFloat(row[7]));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return employees;
    }

    public static Employee loadById(int id) {
        String query = "SELECT id, name, surname, address, phonenumber, note, workhours, hourlyrate FROM Employees WHERE id = ?";
        try {
            ArrayList<String> params = new ArrayList<>();
            params.add(String.valueOf(id));
            List<String[]> rows = DbService.getData(query, params);
            for (String[] row : rows) {
                Employee employee = new Employee();
                employee.setId(Integer.parseInt(row[0]));
                employee.setName(row[1]);
                employee.setSurname(row[2]);
                employee.setAddress(row[3]);
                employee.setPhonenumber(Integer.parseInt(row[4]));
                employee.setNote(row[5]);
                employee.setWorkhours(Float.parseFloat(row[6]));
                employee.setHourlyrate(Float.parseFloat(row[7]));

                return employee;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}