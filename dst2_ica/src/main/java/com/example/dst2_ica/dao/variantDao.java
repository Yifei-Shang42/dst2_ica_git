package com.example.dst2_ica.dao;

import com.example.dst2_ica.bean.Variant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class variantDao extends overviewDao {
    public static ArrayList<Variant> generateResultList(String search, String db) throws SQLException {
        ResultSet rs = generateResultSet(search, db);
        ArrayList<Variant> variants = new ArrayList<>();
        while (rs.next()) {
            String variant_name = rs.getString("variant_name");
            String gene_name = rs.getString("gene_name");
            String location = rs.getString("Location");
            Variant variant= new Variant(variant_name, gene_name, location);
            variants.add(variant);
        }
        return variants;
    }
}
