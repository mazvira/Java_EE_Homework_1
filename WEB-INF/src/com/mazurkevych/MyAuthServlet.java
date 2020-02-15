package com.mazurkevych;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MyAuthServlet extends HttpServlet {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "1234";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='login' method='POST'>");
            out.println("Login: ");
            out.println("<br/>");
            out.println("<input type='text' name='username'/>");
            out.println("<br/>");
            out.println("Password: ");
            out.println("<br/>");
            out.println("<input type='password' name='password'/>");
            out.println("<br/>");
            out.println("<input type='submit' value='Submit'/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isAuthSuccessful = username.equals(USERNAME) && password.equals(PASSWORD);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>" + "LogIn" + "</title>");
            out.println("</head>");
            out.println("<body>");
            out.println(isAuthSuccessful ? ("Hello, " + username + "!") : "Wrong username or password!");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
