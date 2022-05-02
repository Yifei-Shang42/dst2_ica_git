package com.example.dst2_ica.bean;

import com.example.dst2_ica.dao.clinicalAnnotationDao;
import com.example.dst2_ica.dao.geneDao;

import java.sql.SQLException;
import java.util.ArrayList;

public class testBeans {
    public static void main(String args[]) throws SQLException {
        String search = "rs6265";
        String db = "variant";
        testGene(search, db);
    }
    public static void testCliAnno(String search, String db) throws SQLException {
        ArrayList<annotationResult> res = clinicalAnnotationDao.generateResultList(search, db);
        for (Result result : res) {
            for (Data data : result.getData()) {
                System.out.print(data.getInfo());
            }
            System.out.println();
        }
    }

    public static void testGene(String search, String db) throws SQLException {
        ArrayList<Gene> genes = geneDao.generateResultList(search, db);
    }
}
