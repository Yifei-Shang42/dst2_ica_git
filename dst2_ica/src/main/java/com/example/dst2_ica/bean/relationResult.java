package com.example.dst2_ica.bean;

import java.util.ArrayList;
import java.util.Arrays;

public class relationResult extends Result{
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

    // convert itself into front-end friendly ArrayLists
    public ArrayList<String> getHead() {
        return new ArrayList<>(Arrays.asList("Related Item(s)", "Category", "Association", "PMIDs"));
    }

    public ArrayList<Data> getData() {
        ArrayList<Data> data = new ArrayList<>();
        // for chemicals, we search drug database manually specified here
        if (secondEntityType.equals("Chemical")) {
            data.add(new Data(secondEntityName, "display?search=~&db=drug&section=overview"));
        } else {
            data.add(new Data(secondEntityName,"display?search=~&db="+secondEntityType.toLowerCase()+"&section=overview"));
        }
        data.add(new Data(secondEntityType));
        data.add(new Data(association));
        data.add(new Data(PMIDs, "https://pubmed.ncbi.nlm.nih.gov/~"));
        return data;
    }
}
