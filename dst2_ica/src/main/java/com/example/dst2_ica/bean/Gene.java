package com.example.dst2_ica.bean;

import java.util.ArrayList;
import java.util.Arrays;

public class Gene extends Result{
    private String gene_name;
    private String ensemblID;
    private String description;
    private String chromosome;
    private String start;
    private String end;

    public Gene(String gene_name, String ensemblID, String description, String chromosome, String start, String end) {
        this.gene_name = gene_name;
        this.ensemblID = ensemblID;
        this.description = description;
        this.chromosome = chromosome;
        this.start = start;
        this.end = end;
    }

    public String getChromosomeData() {
        return chromosome+" : "+start+" - "+end;
    }

    // convert itself into front-end friendly ArrayLists
    public ArrayList<String> getHead() {
        return new ArrayList<>(Arrays.asList("Gene Name", "Ensemble ID", "Description", "Location GRCh38"));
    }

    public ArrayList<Data> getData() {
        ArrayList<Data> data = new ArrayList<>();
        data.add(new Data(gene_name));
        data.add(new Data(ensemblID));
        data.add(new Data(description));
        data.add(new Data(getChromosomeData()));
        return data;
    }
}
