package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String login = request.getParameter("login");

        if (login.equals(getServletConfig().getInitParameter("login")) && request.getParameter("password").equals(getServletConfig().getInitParameter("password"))) {
            session.setAttribute("username", login);
            response.sendRedirect("/home");
        } else {
            doGet(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            String user = session.getAttribute("username").toString();
            if (user.equals(request.getParameter("logout"))) {
                session.removeAttribute("username");
            }
        }catch (Exception e) {

        }

        getServletContext()
                .getRequestDispatcher("/login.jsp")
                .forward(request, response);

    }

}

