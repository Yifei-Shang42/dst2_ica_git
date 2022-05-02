package com.example.dst2_ica.dao;

import com.example.dst2_ica.bean.annotationResult;
import com.example.dst2_ica.bean.searchResult;

import java.sql.*;
import java.util.ArrayList;

public class clinicalAnnotationDao extends baseDao {
    public static final String schema = "dst_ica";
    public static ArrayList<annotationResult> generateResultList(String search, String db) throws SQLException{
        // statement
        String sql = "SELECT * FROM clinical_annotation where "+db+" = "+"'"+search+"'";
        // get result set
        ResultSet rs = getResultSet(sql, schema);
        // parse & merge result sets into output array
        return parseResultSet(rs);
    }

    private static ArrayList<annotationResult> parseResultSet(ResultSet rs) throws SQLException {
        ArrayList<annotationResult> annotationResults = new ArrayList<>();
        while (rs.next()) {
            String gene_name = rs.getString("gene");
            String drug_name = rs.getString("drug");
            String disease_name = rs.getString("disease");
            String variant_name = rs.getString("variant");
            String evidence = rs.getString("evidence");
            String category = rs.getString("category");
            annotationResult annotationResult= new annotationResult(gene_name, drug_name, disease_name,
                    variant_name, evidence, category);
            annotationResults.add(annotationResult);
        }
        return annotationResults;
    }
}
