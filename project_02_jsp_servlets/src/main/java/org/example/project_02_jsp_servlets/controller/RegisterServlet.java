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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    // encapsulates db access regarding user domain
    private final UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String createPassword = req.getParameter("create-password");
        String confrimPassword = req.getParameter("confirm-password");

        if (!createPassword.equals(confrimPassword)) {
            req.setAttribute("error", "passwords do not match");
            req.getRequestDispatcher("views/register.jsp").forward(req, resp);
        }

        boolean isUserCreated = userDAO.register(new User(username, createPassword));

        if (!isUserCreated) {
            HttpSession session = req.getSession();
            req.setAttribute("error", "unexpected error occurred");
            req.getRequestDispatcher("views/register.jsp").forward(req, resp);
            return;
        }

        // the very attribute that is going to be used in jstl to render error if it occurs
        resp.sendRedirect("views/login.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/register.jsp").forward(req, resp);
    }
}
