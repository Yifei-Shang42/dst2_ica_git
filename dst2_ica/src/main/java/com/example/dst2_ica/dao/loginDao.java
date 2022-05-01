package com.example.dst2_ica.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class loginDao extends baseDao{
    String sql = "select * from user where user_name=? and user_pass=?";
    String url = "jdbc:mysql://localhost:3306/dst2_ica_login";
    String username = "root";
    String password = "parzival42,./";
    String schema = "dst2_ica_login";

    public boolean check(String uname, String pass) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, uname);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            System.out.println("connection established");
            if(rs.next())
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}