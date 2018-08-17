package pl.coderslab;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

@WebServlet(name = "VehicleEdit", urlPatterns = "/vehicle/edit")
public class VehicleEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vehicle_id = request.getParameter("id");
        String model = request.getParameter("model");
        String brand = request.getParameter("brand");
        String productionDate = request.getParameter("productionDate");
        String plateNumber = request.getParameter("plateNumber");
        String nextService = request.getParameter("nextService");

        String customer_idStr = request.getParameter("customer_id");
        try {
            Date productionDateSql = Date.valueOf(productionDate);
            Date nextServiceSql = Date.valueOf(nextService);
            int customer_id = Integer.parseInt(customer_idStr);
            Customer customer = CustomerDao.loadById(customer_id);
            Vehicle vehicle = new Vehicle(Integer.parseInt(vehicle_id), model, brand, productionDateSql, plateNumber, nextServiceSql, customer, customer_id);
            VehicleDao.saveToDb(vehicle);

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/vehicles");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vehicle_id = request.getParameter("id");
        String deleteId = request.getParameter("del");
        if ("true".equals(deleteId)) {
            VehicleDao.delete(Integer.parseInt(vehicle_id));
            response.sendRedirect("/vehicles");
        }else {
            Vehicle vehicle = VehicleDao.loadById(Integer.parseInt(vehicle_id));
            ArrayList<Customer> customers = CustomerDao.loadAll();

            request.setAttribute("vehicle", vehicle);
            request.setAttribute("customers", customers);

            getServletContext()
                    .getRequestDispatcher("/vehicle-edit.jsp")
                    .forward(request, response);
        }
    }
}
