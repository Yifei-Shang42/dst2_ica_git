package com.example.dst2_ica.servlets;

import com.example.dst2_ica.bean.*;
import com.example.dst2_ica.dao.*;

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
            case "overview":
                switch (db) {
                    case "gene":
                        try {
                            ArrayList<Gene> genes = geneDao.generateResultList(search, db);
                            req.setAttribute("output", genes);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "variant":
                        try {
                            ArrayList<Variant> variants = variantDao.generateResultList(search, db);
                            req.setAttribute("output", variants);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "disease":
                        try {
                            ArrayList<Disease> diseases = diseaseDao.generateResultList(search, db);
                            req.setAttribute("output", diseases);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "drug":
                        try {
                            ArrayList<Drug> drugs = drugDao.generateResultList(search, db);
                            req.setAttribute("output", drugs);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                }
                break;
            case "clinical-annotation":
                try {
                    ArrayList<annotationResult> annotationResults = clinicalAnnotationDao.generateResultList(search, db);
                    req.setAttribute("output", annotationResults);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case "related-to":
                try {
                    ArrayList<relationResult> relationResults = relationDao.generateResultList(search, db);
                    req.setAttribute("output", relationResults);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case "literature":
                try {
                    ArrayList<occurrenceResult> literatureResults = occurrenceDao.generateResultList(search, db, "Literature");
                    req.setAttribute("output", literatureResults);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case "pathway":
                try {
                    ArrayList<occurrenceResult> pathwayResults = occurrenceDao.generateResultList(search, db, "Pathway");
                    req.setAttribute("output", pathwayResults);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
        // dispatch
        req.getRequestDispatcher("/display.jsp").forward(req, res);
    }
}
