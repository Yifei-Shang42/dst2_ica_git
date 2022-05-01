package com.example.dst2_ica.servlets;

import com.example.dst2_ica.dao.loginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String uname = request.getParameter("username");
        String pass = request.getParameter("password");
        loginDao dao = new loginDao();

        if(dao.check(uname, pass)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", uname);
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("signin.jsp");
        }
    }
}