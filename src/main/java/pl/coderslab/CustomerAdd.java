package pl.coderslab;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "CustomerAdd", urlPatterns = "/customer/add")
public class CustomerAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String birthdate = String.valueOf(request.getParameter("birthdate"));
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        try {
            Date date = Date.valueOf(birthdate);
            Integer phoneNumber = Integer.parseInt(phone);
            Customer customer = new Customer(name, surname, date, phoneNumber, address);
            CustomerDao.saveToDb(customer);

            request.setAttribute("success", true);

        } catch (Exception e) {
            request.setAttribute("error", true);
            e.printStackTrace();
        }

        getServletContext()
                .getRequestDispatcher("/customer-add.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher("/customer-add.jsp")
                .forward(request, response);

    }
}
