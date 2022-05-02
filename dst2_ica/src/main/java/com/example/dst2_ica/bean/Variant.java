package com.example.dst2_ica.bean;

import java.util.ArrayList;
import java.util.Arrays;

public class Variant extends Result {
    private String variant_name;
    private String gene_name;
    private String location;

    public Variant(String variant_name, String gene_name, String location) {
        this.variant_name = variant_name;
        this.gene_name = gene_name;
        this.location = location;
    }

    // convert itself into front-end friendly ArrayLists
    public ArrayList<String> getHead() {
        return new ArrayList<>(Arrays.asList("Variant Name", "Gene Name", "Location"));
    }

    public ArrayList<Data> getData() {
        ArrayList<Data> data = new ArrayList<>();
        data.add(new Data(variant_name));
        data.add(new Data(gene_name));
        data.add(new Data(location));
        return data;
    }
}
