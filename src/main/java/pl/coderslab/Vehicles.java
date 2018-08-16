package pl.coderslab;

import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Vehicles", urlPatterns = "/vehicles")
public class Vehicles extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = 0;
        try {
            customerId = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {

        }
        List<Vehicle> vehicles = new ArrayList<>();
        if (customerId == 0) {
            vehicles = VehicleDao.loadAll();
        } else {
            vehicles = VehicleDao.loadByCustomer(customerId);
        }

        request.setAttribute("vehicles", vehicles);

        getServletContext()
                .getRequestDispatcher("/vehicles.jsp")
                .forward(request,response);
    }
}
