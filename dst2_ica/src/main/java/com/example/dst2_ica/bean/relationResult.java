package com.example.dst2_ica.bean;

public class relationResult {
    private String firstEntityName;
    private String firstEntityType;
    private String secondEntityName;
    private String secondEntityType;
    private String association;
    private String PMIDs;

    public String getFirstEntityName() {
        return firstEntityName;
    }

    public String getFirstEntityType() {
        return firstEntityType;
    }

    public String getSecondEntityName() {
        return secondEntityName;
    }

    public String getSecondEntityType() {
        return secondEntityType;
    }

    public String getAssociation() {
        return association;
    }

    public String getPMIDs() {
        return PMIDs;
    }

    public relationResult(String firstEntityName, String firstEntityType, String secondEntityName,
                          String secondEntityType, String association, String PMIDs) {
        this.firstEntityName = firstEntityName;
        this.firstEntityType = firstEntityType;
        this.secondEntityName = secondEntityName;
        this.secondEntityType = secondEntityType;
        this.association = association;
        this.PMIDs = PMIDs;
    }
}
