package pl.coderslab.dao;

import pl.coderslab.model.Status;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusDao {


    public static void saveToDb(Status status) {
        if (status.getId() == 0) {
            String query = "INSERT INTO Status (status) VALUES(?)";
            List<String> params = new ArrayList<>();
            params.add(String.valueOf(status.getStatus()));
            try {
                Integer id = DbService.insertIntoDatabase(query, params);
                if (id != null) {
                    status.setId(id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            String query = "UPDATE Status SET status = ? WHERE id = ?";
            List<String> params = new ArrayList<>();
            params.add(String.valueOf(status.getStatus()));

            params.add(String.valueOf(status.getId()));
            try {
                DbService.executeUpdate(query, params);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<Status> loadAll() {
        ArrayList<Status> statuses = new ArrayList<>();
        String query = "SELECT id, statusId  FROM Status";
        try {
            List<String[]> rows = DbService.getData(query, null);
            for (String[] row : rows) {
                Status status = new Status();
                status.setId(Integer.parseInt(row[0]));
                status.setStatus(row[1]);

                statuses.add(status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statuses;
    }

    public static Status loadById(int id) {
        String query = "SELECT id, status  FROM Status WHERE id = ?";
        try {
            ArrayList<String> params = new ArrayList<>();
            params.add(String.valueOf(id));
            List<String[]> rows = DbService.getData(query, params);
            for (String[] row : rows) {
                Status status = new Status();
                status.setId(Integer.parseInt(row[0]));
                status.setStatus(row[1]);

                return status;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void delete(int id) {
        String query = "DELETE FROM Status WHERE id =?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        try {
            int affectedRows = DbService.executeUpdate(query, params);
            if (affectedRows > 0) {
                System.out.println("Usunalem status o id: " + id);
            } else {
                System.out.println("Operacja usuniecia zadania zakonczyla sie niepowodzeniem");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
