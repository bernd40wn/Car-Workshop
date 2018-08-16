package pl.coderslab;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Order;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Orders", urlPatterns = "/orders")
public class Orders extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = 0;
        try {
            employeeId = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {

        }
        List<Order> orders = new ArrayList<>();
        if (employeeId == 0) {
            orders = OrderDao.loadAll();
        } else {
            orders = OrderDao.loadByEmployee(employeeId);
        }

        request.setAttribute("orders", orders);

        getServletContext()
                .getRequestDispatcher("/orders.jsp")
                .forward(request,response);
    }
}
