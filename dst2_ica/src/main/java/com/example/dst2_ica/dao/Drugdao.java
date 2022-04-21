package com.example.dst2_ica.dao;

import com.example.dst2_ica.bean.Drug;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Drugdao extends Basedao{
    public static ArrayList<Drug> generateResultList(String search) throws SQLException {
        String sql = "SELECT * FROM drug WHERE drug_name = '" + search + "'";
        ResultSet rs = getResultSet(sql);
        ArrayList<Drug> drugs = parseResultSet(rs);
        return drugs;
    }

    private static ArrayList<Drug> parseResultSet(ResultSet rs) throws SQLException {
        ArrayList<Drug> drugs = new ArrayList<>();
        while (rs.next()) {
            String id = rs.getString("drug_id");
            String name = rs.getString("drug_name");
            Drug drug = new Drug(id, name);
            drugs.add(drug);
        }
        return drugs;
    }
}
