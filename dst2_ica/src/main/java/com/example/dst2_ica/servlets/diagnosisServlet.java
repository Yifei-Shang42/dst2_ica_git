package com.example.dst2_ica.servlets;

import com.example.dst2_ica.bean.annotationResult;
import com.example.dst2_ica.dao.clinicalAnnotationDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet(urlPatterns = "/diagnosis")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class diagnosisServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ArrayList<String> searchList = generateSearchList(req.getParameter("searchList"));
        // iterate through arraylist to get all records in clinical annotation
        ArrayList<annotationResult> output = new ArrayList<>();
            try {
                for (String search : searchList) {
                    ArrayList<annotationResult> currentRes = clinicalAnnotationDao.generateResultList(search, "variant");
                    output.addAll(currentRes);
                    System.out.println(currentRes.size());
                    System.out.println(output.size());
                }
            } catch (SQLException e) {
                e.printStackTrace();
        }

        //testing
        for (String search : searchList) {
            System.out.println(search);
        }
        System.out.println(searchList.size());
        System.out.println(output.size());
        //testing

        req.setAttribute("output", output);
        req.getRequestDispatcher("/diagnosisRes.jsp").forward(req, res);
    }

    public ArrayList<String> generateSearchList(String rawSearch) {
        String trimmedSearch = rawSearch.trim();
        return new ArrayList<>(Arrays.asList(trimmedSearch.split("\\r?\\n")));
    }
}
