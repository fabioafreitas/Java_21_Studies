package org.example.project_02_jsp_servlets.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {
    "/my-anotated-servlet",
    "/hello-world-2",
    "*.helloworld2"
})
public class MyAnnotatedServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>MyAnnotatedServlet</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
