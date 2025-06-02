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

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if(sessionUser == null){
            req.getRequestDispatcher("views/login.jsp").forward(req, resp);
        }
        req.getRequestDispatcher("views/dashboard.jsp").forward(req, resp);
    }
}
