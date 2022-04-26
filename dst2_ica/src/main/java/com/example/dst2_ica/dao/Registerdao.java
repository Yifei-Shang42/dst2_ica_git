package com.example.dst2_ica.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Registerdao {
    String sql_add = "insert into user (user_name, user_pass) values (?,?)";
    String sql_check = "select * from user where user_name=?";
    String url = "jdbc:mysql://localhost:3306/dst2_ica_login";
    String username = "root";
    String password = "parzival42,./";

    public boolean addUser(String uname, String pass)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            // check if username already used
            PreparedStatement st_check = con.prepareStatement(sql_check);
            st_check.setString(1, uname);
            ResultSet rs_check = st_check.executeQuery();
            if (rs_check.next()) {
                return false;
            } else {
                PreparedStatement st_add = con.prepareStatement(sql_add);
                st_add.setString(1, uname);
                st_add.setString(2, pass);
                int i = st_add.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
