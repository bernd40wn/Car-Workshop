package pl.coderslab;

import pl.coderslab.dao.*;
import pl.coderslab.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

@WebServlet(name = "OrderAdd", urlPatterns = "/order/add")
public class OrderAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String admissionDate = request.getParameter("admissionDate");
        String plannedServiceDate = request.getParameter("plannedServiceDate");
        String serviceDate = request.getParameter("serviceDate");

        String carProblemDescription = request.getParameter("carProblemDescription");
        String carFixDescription = request.getParameter("carFixDescription");

        String fixCostsStr = request.getParameter("fixCosts");
        String partsCostsStr = request.getParameter("partsCosts");
        String employee_idStr = request.getParameter("employee_id");
        String vehicle_idStr = request.getParameter("vehicle_id");
        String status_idStr = request.getParameter("status_id");

        try {
            Date admissionDateSql = Date.valueOf(admissionDate);
            Date plannedServiceDateSql = Date.valueOf(plannedServiceDate);
            Date serviceDateSql = Date.valueOf(serviceDate);

            Float fixCosts = Float.parseFloat(fixCostsStr);
            Float partsCosts = Float.parseFloat(partsCostsStr);

            int employee_id = Integer.parseInt(employee_idStr);
            Employee employee = EmployeeDao.loadById(employee_id);
            int vehicle_id = Integer.parseInt(vehicle_idStr);
            Vehicle vehicle = VehicleDao.loadById(vehicle_id);
            int status_id = Integer.parseInt(status_idStr);
            Status status = StatusDao.loadById(status_id);
            int customer_id = vehicle.getCustomer_id();


            Order order = new Order(admissionDateSql, plannedServiceDateSql, serviceDateSql, employee,
                    carProblemDescription, carFixDescription, status, vehicle, fixCosts,
                    partsCosts, customer_id, employee_id, vehicle_id, status_id);
            OrderDao.saveToDb(order);

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/orders");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Employee> employees = EmployeeDao.loadAll();
        ArrayList<Vehicle> vehicles = VehicleDao.loadAll();
        ArrayList<Status> statuses = StatusDao.loadAll();

        request.setAttribute("employees", employees);
        request.setAttribute("vehicles", vehicles);
        request.setAttribute("statuses", statuses);


        getServletContext()
                .getRequestDispatcher("/order-add.jsp")
                .forward(request, response);
    }
}
