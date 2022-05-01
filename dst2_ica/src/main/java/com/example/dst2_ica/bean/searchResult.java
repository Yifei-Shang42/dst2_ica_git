package com.example.dst2_ica.bean;

public class searchResult {
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
}
