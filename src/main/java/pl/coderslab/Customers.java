package pl.coderslab;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.DbService;
import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Customers", urlPatterns = "/customers")
public class Customers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Customer> customers = CustomerDao.loadAll();

        request.setAttribute("customers", customers);

        getServletContext()
                .getRequestDispatcher("/customers.jsp")
                .forward(request,response);

    }
}
