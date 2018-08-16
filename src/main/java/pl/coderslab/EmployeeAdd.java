package pl.coderslab;


import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeAdd", urlPatterns = "/employee/add")
public class EmployeeAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String note = request.getParameter("note");
        String workhours = request.getParameter("workhours");
        String hourlyrate = request.getParameter("hourlyrate");
        try {

            Float workhours1 = Float.parseFloat(workhours);
            Float hourlyrate1 = Float.parseFloat(hourlyrate);
            Integer phoneNumber = Integer.parseInt(phone);
            Employee employee = new Employee(name, surname, address, phoneNumber, note, workhours1, hourlyrate1);
            EmployeeDao.saveToDb(employee);

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/employees");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher("/employee-add.jsp")
                .forward(request, response);
    }
}
