package pl.coderslab.dao;

import java.sql.SQLException;
import java.util.ArrayList;


public class CustomerDao {
    //test

    public static void saveToDb(Customer customer) {
        if (customer.getId() == 0) {
            String query = "INSERT INTO Customer (name, surename, birthday, phonenumber, adress) VALUES(?,?,?,?,?,)";
            List<String> params = new ArrayList<>();
            params.add(customer.getName());
            params.add(customer.getSurename());
            params.add(String.valueOf(customer.getBirthday()));
            params.add(String.valueOf(customer.getPhonenumber()));
            params.add(customer.getAdress());
            try {
                Integer id = DbService.insertIntoDatabase(query, params);
                if (id != null) {
                    customer.setId(id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            String query = "UPDATE Customer SET name = ?, surename = ?, birthday = ?, phonenumber = ?, adress = ? WHERE id = ?";
            List<String> params = new ArrayList<>();
            params.add(customer.getName());
            params.add(customer.getSurename());
            params.add(String.valueOf(customer.getBirthday()));
            params.add(String.valueOf(customer.getPhonenumber()));
            params.add(customer.getAdress());

            params.add(String.valueOf(customer.getId()));
            try {
                DbService.executeUpdate(query, params);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void deleteCustomer(int id) throws SQLException {
        String query = "DELETE FROM Customer WHERE id =?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        try {
            int affectedRows = DbService.executeUpdate(query, params);
            if (affectedRows > 0) {
                System.out.println("Usunalem klienta o id: " + id);
            } else {
                System.out.println("Operacja usuniecia zadania zakonczyla sie niepowodzeniem");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<Customer> loadAll() {
        ArrayList<Customer> customer = new ArrayList<>();
        String query = "SELECT id, name, surename, birthday, phonenumber, adress FROM Customer";
        try {
            List<String[]> rows = DbService.getData(query, null);
            for (String[] row : rows) {
                Customer customer = new Customer();
                customer.setId(Integer.parseInt(row[0]));
                customer.setName(row[1]);
                customer.setSurename(row[2]);
                customer.setBirthday(Date.valueOf(row[3]));
                customer.setPhonenumber(Integer.parseInt(row[4]));
                customer.setAdress(row[5]);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return customers;

    }

    public static Customer loadById(int id) {
        String query = "SELECT id, name, surename, birthday, phonenumber, adress FROM Customer WHERE id = ?";
        try {
            ArrayList<String> params = new ArrayList<>();
            params.add(String.valueOf(id));
            List<String[]> rows = DbService.getData(query, params);
            for (String[] row : rows) {
                Customer customer = new Customer();
                Customer setId(Integer.parseInt(row[0]));
                customer.setName(row[1]);
                customer.setSurename(row[2]);
                customer.setBirthday(Date.valueOf(row[3]));
                customer.setPhonenumber(Integer.parseInt(row[4]));
                customer.setAdress(row[5]);
                return customer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
