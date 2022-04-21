package com.example.dst2_ica.dao;

import com.example.dst2_ica.bean.Gene;
import com.example.dst2_ica.bean.Variant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Variantdao extends Basedao{
    public static ArrayList<Variant> generateResultList(String search) throws SQLException {
        String sql = "SELECT * FROM variant WHERE variant_name = '" + search + "'";
        ResultSet rs = getResultSet(sql);
        ArrayList<Variant> variants = parseResultSet(rs);
        return variants;
    }

    private static ArrayList<Variant> parseResultSet(ResultSet rs) throws SQLException {
        ArrayList<Variant> variants = new ArrayList<>();
        while (rs.next()) {
            String id = rs.getString("variant_id");
            String name = rs.getString("variant_name");
            Variant variant = new Variant(id, name);
            variants.add(variant);
        }
        return variants;
    }
}
