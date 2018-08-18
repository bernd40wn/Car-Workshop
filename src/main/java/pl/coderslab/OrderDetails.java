package pl.coderslab;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderDetails", urlPatterns = "/order/details")
public class OrderDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String order_id = request.getParameter("id");
        Order order = OrderDao.loadById(Integer.parseInt(order_id));

        request.setAttribute("order", order);

        getServletContext()
                .getRequestDispatcher("/order-details.jsp")
                .forward(request, response);
    }
}

