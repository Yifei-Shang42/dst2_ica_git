package com.example.dst2_ica.dao;

import com.example.dst2_ica.bean.Gene;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class overviewDao extends baseDao{
    public static final String schema = "dst_ica";
    protected static ResultSet generateResultSet(String search, String db) throws SQLException {
        String sql = "SELECT * FROM "+db+" where "+db+"_name = "+"'"+search+"'";
        ResultSet rs = getResultSet(sql, schema);
        return rs;
    }
}
