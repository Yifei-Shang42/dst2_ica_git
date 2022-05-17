package com.example.dst2_ica.dao;

import com.example.dst2_ica.bean.annotationResult;
import com.example.dst2_ica.bean.dosingResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class dosingDao extends baseDao {
    public static final String schema = "dst_ica";
    public static ArrayList<dosingResult> generateResultList(String search, String db) throws SQLException {
        // statement
        String sql = "SELECT * FROM drug_label where Chemicals = "+"'"+search+"'";
        // get result set
        ResultSet rs = getResultSet(sql, schema);
        // parse & merge result sets into output array
        return parseResultSet(rs);
    }

    private static ArrayList<dosingResult> parseResultSet(ResultSet rs) throws SQLException {
        ArrayList<dosingResult> dosingResults = new ArrayList<>();
        while (rs.next()) {
            String drug_name = rs.getString("Chemicals");
            String url = rs.getString("PharmGKB_ID");
            dosingResult dosingResult= new dosingResult(drug_name, url);
            dosingResults.add(dosingResult);
        }
        return dosingResults;
    }
}
