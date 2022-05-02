package com.example.dst2_ica.dao;

import com.example.dst2_ica.bean.occurrenceResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class occurrenceDao extends baseDao {
    public static final String schema = "dst_ica";
    public static ArrayList<occurrenceResult> generateResultList(String search, String db, String occur) throws SQLException {
        // statement
        String sql = "SELECT * FROM occurrence where object_name = "+"'"+search+"' AND source_type = '"+occur+"'";
        // get result set
        ResultSet rs = getResultSet(sql, schema);
        // parse & merge result sets into output array
        ArrayList<occurrenceResult> out = new ArrayList<>();
        out.addAll(parseResultSet(rs));
        return out;
    }

    private static ArrayList<occurrenceResult> parseResultSet(ResultSet rs) throws SQLException {
        ArrayList<occurrenceResult> occurrenceResults = new ArrayList<>();
        while (rs.next()) {
            String sourceID = rs.getString("source_id");
            String sourceName = rs.getString("source_name");
            String objectType = rs.getString("object_type");
            String objectName = rs.getString("object_name");
            String sourceType = rs.getString("source_type");
            occurrenceResult occurrenceResult = new occurrenceResult(sourceID, sourceName,
                    objectType, objectName, sourceType);
            occurrenceResults.add(occurrenceResult);
        }
        return occurrenceResults;
    }
}
