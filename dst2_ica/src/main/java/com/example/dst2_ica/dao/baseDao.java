package com.example.dst2_ica.dao;

import com.example.dst2_ica.bean.searchResult;

import java.sql.*;
import java.util.ArrayList;

public abstract class baseDao {
    protected static ResultSet getResultSet(String sql, String schema) throws SQLException{
        // Get ResultSet from DB
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/"+schema;
        String username = "root";
        String password = "parzival42,./";
        Connection con = DriverManager.getConnection(url, username, password);
        Statement st = con.createStatement();
        return st.executeQuery(sql);
    }
}
