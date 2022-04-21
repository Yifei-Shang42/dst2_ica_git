package com.example.dst2_ica.dao;

import com.example.dst2_ica.bean.Gene;

import java.sql.*;
import java.util.ArrayList;

public abstract class Basedao {
    public static ResultSet getResultSet(String sql) throws SQLException{
        // Get ResultSet from DB
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/dst2_project";
        String username = "root";
        String password = "parzival42,./";
        Connection con = DriverManager.getConnection(url, username, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }
}
