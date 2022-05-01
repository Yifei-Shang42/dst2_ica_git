package com.example.dst2_ica.servlets;

import com.example.dst2_ica.bean.annotationResult;
import com.example.dst2_ica.bean.occurrenceResult;
import com.example.dst2_ica.bean.relationResult;
import com.example.dst2_ica.dao.clinicalAnnotationDao;
import com.example.dst2_ica.dao.occurrenceDao;
import com.example.dst2_ica.dao.relationDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "displayServlet", urlPatterns = "/display")
public class displayServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String search = req.getParameter("search");
        String db = req.getParameter("db");
        String section = req.getParameter("section");
        req.setAttribute("search", search);
        req.setAttribute("db", db);
        // get results from corresponding DAOs
        switch (section) {
            case "clinical-annotation":
                try {
                    ArrayList<annotationResult> annotationResults = clinicalAnnotationDao.generateResultList(search, db);
                    req.setAttribute("output", annotationResults);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            case "related-to":
                try {
                    ArrayList<relationResult> relationResults = relationDao.generateResultList(search, db);
                    req.setAttribute("output", relationResults);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            case "literature":
                try {
                    ArrayList<occurrenceResult> occurrenceResults = occurrenceDao.generateResultList("literature", search, db);
                    req.setAttribute("output", occurrenceResults);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            case "pathway":
                try {
                    ArrayList<occurrenceResult> occurrenceResults = occurrenceDao.generateResultList("pathway", search, db);
                    req.setAttribute("output", occurrenceResults);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        // dispatch
        req.getRequestDispatcher("/display.jsp").forward(req, res);
    }
}
