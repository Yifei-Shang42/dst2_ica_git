package com.example.dst2_ica.bean;

import java.util.ArrayList;
import java.util.Arrays;

public class Disease extends Result {
    private String disease_name;

    public Disease(String disease_name) {
        this.disease_name = disease_name;
    }

    // convert itself into front-end friendly ArrayLists
    public ArrayList<String> getHead() {
        return new ArrayList<>(Arrays.asList("Disease Name"));
    }

    public ArrayList<Data> getData() {
        ArrayList<Data> data = new ArrayList<>();
        data.add(new Data(disease_name));
        return data;
    }
}
