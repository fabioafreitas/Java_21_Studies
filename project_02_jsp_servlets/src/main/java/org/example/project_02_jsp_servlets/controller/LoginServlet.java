package org.example.project_02_jsp_servlets.controller;

import org.example.project_02_jsp_servlets.dao.UserDAO;
import org.example.project_02_jsp_servlets.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    // encapsulates db access regarding user domain
    private final UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userDAO.login(username, password);

        if (user == null) {
            // the very attribute that is going to be used in jstl to render error if it occurs
            req.setAttribute("error", "username or password incorrect");
            req.getRequestDispatcher("views/login.jsp").forward(req, resp);
            return;
        }

        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        resp.sendRedirect("views/dashboard.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/login.jsp").forward(req, resp);
    }
}
