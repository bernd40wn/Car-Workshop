package pl.coderslab;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "Employees", urlPatterns = "/employees")
public class Employees extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Employee> employeeList = EmployeeDao.loadAll();

        request.setAttribute("employeeList", employeeList);

        getServletContext()
                .getRequestDispatcher("/employees.jsp")
                .forward(request,response);
    }
}
