package com.example.dst2_ica.dao;

import com.example.dst2_ica.bean.Drug;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class drugDao extends overviewDao {
    public static ArrayList<Drug> generateResultList(String search, String db) throws SQLException {
        ResultSet rs = generateResultSet(search, db);
        ArrayList<Drug> drugs = new ArrayList<>();
        while (rs.next()) {
            String drug_name = rs.getString("drug_name");
            String trade_name = rs.getString("Trade_Names");
            Drug drug = new Drug(drug_name, trade_name);
            drugs.add(drug);
        }
        return drugs;
    }
}
