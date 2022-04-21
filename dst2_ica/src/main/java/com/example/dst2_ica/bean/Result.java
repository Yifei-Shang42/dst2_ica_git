package com.example.dst2_ica.bean;

public abstract class Result {
    private String id;
    private String name;

    protected Result(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
