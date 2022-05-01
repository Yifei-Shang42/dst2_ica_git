package com.example.dst2_ica.dao;

import com.example.dst2_ica.bean.annotationResult;
import com.example.dst2_ica.bean.relationResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class relationDao extends baseDao {
    public static final String schema = "dst_ica";
    public static ArrayList<relationResult> generateResultList(String search, String db) throws SQLException {
        // statement
        String sql = "";
        // get result set
        ResultSet rs = getResultSet(sql, schema);
        // parse & merge result sets into output array
        ArrayList<relationResult> out = new ArrayList<>();
        out.addAll(parseResultSet(rs));
        return out;
    }

    private static ArrayList<relationResult> parseResultSet(ResultSet rs) throws SQLException {
        ArrayList<relationResult> relationResults = new ArrayList<>();
        while (rs.next()) {
            String firstEntityName = rs.getString("Entity1_name");
            String firstEntityType = rs.getString("Entity1_type");
            String secondEntityName = rs.getString("Entity2_name");
            String secondEntityType = rs.getString("Entity2_type");
            String association = rs.getString("Association");
            String PMIDs = rs.getString("PMIDs");
            relationResult relationResult= new relationResult(firstEntityName, firstEntityType, secondEntityName,
                    secondEntityType, association, PMIDs);
            relationResults.add(relationResult);
        }
        return relationResults;
    }
}
