package com.example.dst2_ica.dao;

import com.example.dst2_ica.bean.Gene;
import com.example.dst2_ica.bean.Result;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Genedao extends Basedao{
    public static ArrayList<Gene> generateResultList(String search) throws SQLException {
        String sql = "SELECT * FROM gene WHERE gene_name = '" + search + "'";
        ResultSet rs = getResultSet(sql);
        ArrayList<Gene> genes = parseResultSet(rs);
        return genes;
    }

    private static ArrayList<Gene> parseResultSet(ResultSet rs) throws SQLException {
        ArrayList<Gene> genes = new ArrayList<>();
        while (rs.next()) {
            String id = rs.getString("gene_id");
            String name = rs.getString("gene_name");
            Gene gene = new Gene(id, name);
            genes.add(gene);
        }
        return genes;
    }

//    public static ArrayList<Gene> getDetailedInfo(String search) throws SQLException {
//        String sql = ""
//    }

    public static void main(String[] args) throws SQLException {
        ArrayList<Gene> genes = generateResultList("BRCA2");
        for (Gene gene : genes) {
            System.out.println(gene.getName());
        }
    }
}
