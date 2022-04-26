package com.example.dst2_ica.servlets;

import com.example.dst2_ica.bean.*;
import com.example.dst2_ica.dao.Diseasedao;
import com.example.dst2_ica.dao.Drugdao;
import com.example.dst2_ica.dao.Genedao;
import com.example.dst2_ica.dao.Variantdao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "searchServlet", urlPatterns = "/search")
public class searchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String search = req.getParameter("search");
        // put into one list
        ArrayList<List> output = new ArrayList<>();
        // try search in gene table
        try {
            ArrayList<Gene> genes = Genedao.generateResultList(search);
//            ArrayList<Variant> variants = Variantdao.generateResultList(search);
//            ArrayList<Drug> drugs = Drugdao.generateResultList(search);
//            ArrayList<Disease> diseases = Diseasedao.generateResultList(search);
            for (Gene gene : genes) {
                output.add(new ArrayList<>(Arrays.asList(gene.getName(), "Gene")));
            }
//            for (Variant variant : variants) {
//                output.add(new ArrayList<String>(Arrays.asList(variant.getName(),"Variant")));
//            }
//            for (Drug drug : drugs) {
//                output.add(new ArrayList<String>(Arrays.asList(drug.getName(),"Drug")));
//            }
//            for (Disease disease : diseases) {
//                output.add(new ArrayList<String>(Arrays.asList(disease.getName(),"Disease")));
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // dispatch
        req.setAttribute("output", output);
        req.setAttribute("search", search);
        req.getRequestDispatcher("/searchRes.jsp").forward(req, res);
    }
}
