package com.example.dst2_ica.dao;


import com.example.dst2_ica.bean.Disease;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class diseaseDao extends overviewDao {
    public static ArrayList<Disease> generateResultList(String search, String db) throws SQLException {
        ResultSet rs = generateResultSet(search, db);
        ArrayList<Disease> diseases = new ArrayList<>();
        while (rs.next()) {
            String disease_name = rs.getString("disease_name");
            Disease disease = new Disease(disease_name);
            diseases.add(disease);
        }
        return diseases;
    }
}
