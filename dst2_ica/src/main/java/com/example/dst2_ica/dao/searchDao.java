package com.example.dst2_ica.dao;

import com.example.dst2_ica.bean.searchResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class searchDao extends baseDao {
    public static final String schema = "dst_ica";
    public static ArrayList<searchResult> generateResultList(String search) throws SQLException {
        // Prepare all statements for search
        String sql_drug = "SELECT * FROM drug WHERE drug_name REGEXP '^" + search + "' LIMIT 50";
        String sql_gene = "SELECT * FROM gene WHERE gene_name REGEXP '^" + search + "' LIMIT 50";
        String sql_variant = "SELECT * FROM variant WHERE variant_name REGEXP '^" + search + "' LIMIT 50";
        String sql_disease = "SELECT * FROM disease WHERE disease_name REGEXP '^" + search + "' LIMIT 50";
        // get 4 result sets
        ResultSet rs_drug = getResultSet(sql_drug, schema);
        ResultSet rs_gene = getResultSet(sql_gene, schema);
        ResultSet rs_variant = getResultSet(sql_variant, schema);
        ResultSet rs_disease = getResultSet(sql_disease, schema);
        // parse & merge result sets into output array
        ArrayList<searchResult> out = new ArrayList<>();
        out.addAll(parseResultSet(rs_drug, "drug"));
        out.addAll(parseResultSet(rs_gene, "gene"));
        out.addAll(parseResultSet(rs_variant, "variant"));
        out.addAll(parseResultSet(rs_disease, "disease"));
        return out;
    }

    private static ArrayList<searchResult> parseResultSet(ResultSet rs, String db) throws SQLException {
        ArrayList<searchResult> searchResults = new ArrayList<>();
        while (rs.next()) {
            String id = rs.getString(db+"_id");
            String name = rs.getString(db+"_name");
            searchResult searchResult = new searchResult(id, name, db);
            searchResults.add(searchResult);
        }
        return searchResults;
    }
}
