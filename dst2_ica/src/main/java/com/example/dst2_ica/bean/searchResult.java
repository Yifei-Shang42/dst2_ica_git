package com.example.dst2_ica.bean;

import java.util.ArrayList;
import java.util.Arrays;

public class searchResult extends Result{
    private String id;
    private String name;
    private String db;

    public searchResult(String id, String name, String db) {
        this.id = id;
        this.name = name;
        this.db = db;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDB() {
        return db;
    }

    @Override
    public String toString() {
        return getName();
    }

    public ArrayList<String> getHead() {
        return new ArrayList<>(Arrays.asList("Results:", "Category:"));
    }

    public ArrayList<Data> getData() {
        ArrayList<Data> data = new ArrayList<>();
        data.add(new Data(name, "display?search="+name+"&db="+db+"&section=overview"));
        data.add(new Data(db));
        return data;
    }
}
