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
import java.util.ArrayList;

@WebServlet(name = "CustomerEdit", urlPatterns = "/customer/edit")
public class CustomerEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("id");

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String birthdate = String.valueOf(request.getParameter("birthdate"));
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        try {
            Date date = Date.valueOf(birthdate);
            Integer phoneNumber = Integer.parseInt(phone);
            Customer customer = new Customer(Integer.parseInt(customerId), name, surname, date, phoneNumber, address);
            CustomerDao.saveToDb(customer);

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/customers");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("id");
        String deleteId = request.getParameter("del");
        if ("true".equals(deleteId)) {
            CustomerDao.delete(Integer.parseInt(customerId));
            response.sendRedirect("/customers");
        }else {

            Customer customer = CustomerDao.loadById(Integer.parseInt(customerId));

            request.setAttribute("customer", customer);
            getServletContext()
                    .getRequestDispatcher("/customer-edit.jsp")
                    .forward(request, response);
        }

    }
}
