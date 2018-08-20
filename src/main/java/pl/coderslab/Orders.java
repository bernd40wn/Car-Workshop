package pl.coderslab;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Order;

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
            employeeId = Integer.parseInt(request.getParameter("employee_id"));
        } catch (Exception e) {

        }

        List<Order> orders = new ArrayList<>();
        if (employeeId == 0) {
            orders = OrderDao.loadAll();
        } else {
            orders = OrderDao.loadByEmployee(employeeId);
        }
        request.setAttribute("orders", orders);

        List<Employee> employees = new ArrayList<>();
        employees = EmployeeDao.loadAll();
        request.setAttribute("employees", employees);
        request.setAttribute("employee_id", employeeId);

        getServletContext()
                .getRequestDispatcher("/orders.jsp")
                .forward(request, response);
    }
}
