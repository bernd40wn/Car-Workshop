package pl.coderslab;


import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "EmployeeEdit", urlPatterns = "/employee/edit")
public class EmployeeEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employee_id = request.getParameter("id");

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String note = request.getParameter("note");
        String hourlyrate = request.getParameter("hourlyrate");

        try {
            Integer phoneNumber = Integer.parseInt(phone);
            Float hourlyrate1 = Float.parseFloat(hourlyrate);
            Integer id = Integer.parseInt(employee_id);
            Employee employee = new Employee(id, name, surname, address, phoneNumber, note, hourlyrate1);
            EmployeeDao.saveToDb(employee);

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/employees");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String employeeId = request.getParameter("id");
        String deleteId = request.getParameter("del");
        if ("true".equals(deleteId)) {
            EmployeeDao.delete(Integer.parseInt(employeeId));
            response.sendRedirect("/employees");
        } else {

            Employee employee = EmployeeDao.loadById(Integer.parseInt(employeeId));

            request.setAttribute("employee", employee);
            getServletContext()
                    .getRequestDispatcher("/employee-edit.jsp")
                    .forward(request, response);
        }
    }
}
