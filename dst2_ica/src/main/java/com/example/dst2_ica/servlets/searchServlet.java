package com.example.dst2_ica.servlets;

import com.example.dst2_ica.bean.*;
import com.example.dst2_ica.dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "searchServlet", urlPatterns = "/search")
public class searchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String search = req.getParameter("search");
        // try search in gene table
        try {
            ArrayList<searchResult> searchResults = searchDao.generateResultList(search);
            req.setAttribute("output", searchResults);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // dispatch
        req.setAttribute("search", search);
        req.getRequestDispatcher("/searchRes.jsp").forward(req, res);
    }
}
