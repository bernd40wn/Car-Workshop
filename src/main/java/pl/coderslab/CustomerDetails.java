package pl.coderslab;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerDetails", urlPatterns = "/customer/details")
public class CustomerDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("id");
        Customer customer = CustomerDao.loadById(Integer.parseInt(customerId));

        request.setAttribute("customer", customer);
        getServletContext()
                .getRequestDispatcher("/customer-details.jsp")
                .forward(request, response);

    }
}
