package com.example.dst2_ica.dao;

import com.example.dst2_ica.bean.Gene;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class geneDao extends overviewDao{
    public static ArrayList<Gene> generateResultList(String search, String db) throws SQLException {
        ResultSet rs = generateResultSet(search, db);
        ArrayList<Gene> genes = new ArrayList<>();
        while (rs.next()) {
            String gene_name = rs.getString("gene_name");
            String ensemblID = rs.getString("Ensembl_ID");
            String description = rs.getString("gene_description");
            String chromosome = rs.getString("Chromosome");
            String start = rs.getString("Chromosomal_Start_GRCh38");
            String end = rs.getString("Chromosomal_Stop_GRCh38");
            Gene gene= new Gene(gene_name, ensemblID, description, chromosome, start, end);
            genes.add(gene);
        }
        return genes;
    }

//    public static void main(String[] args) throws SQLException {
//        ArrayList<Gene> genes = generateResultList("BRCA2", "gene");
//    }
}
