package com.example.dst2_ica.dao;

import com.example.dst2_ica.bean.Disease;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Diseasedao extends Basedao{
    public static ArrayList<Disease> generateResultList(String search) throws SQLException {
        String sql = "SELECT * FROM disease WHERE disease_name = '" + search + "'";
        ResultSet rs = getResultSet(sql);
        ArrayList<Disease> diseases = parseResultSet(rs);
        return diseases;
    }

    private static ArrayList<Disease> parseResultSet(ResultSet rs) throws SQLException {
        ArrayList<Disease> diseases = new ArrayList<>();
        while (rs.next()) {
            String id = rs.getString("disease_id");
            String name = rs.getString("disease_name");
            Disease disease = new Disease(id, name);
            diseases.add(disease);
        }
        return diseases;
    }
}
