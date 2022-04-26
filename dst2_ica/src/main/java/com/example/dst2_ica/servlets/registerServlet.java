package com.example.dst2_ica.servlets;

import com.example.dst2_ica.dao.Registerdao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class registerServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String uname = req.getParameter("username");
        String pass = req.getParameter("password");
        Registerdao dao = new Registerdao();
        if (dao.addUser(uname, pass)) {
            req.setAttribute("success", true);
        } else {
            req.setAttribute("success", false);
        }
        req.getRequestDispatcher("/register.jsp").forward(req, res);
    }
}
