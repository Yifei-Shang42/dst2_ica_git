package com.example.dst2_ica.bean;

import java.util.ArrayList;
import java.util.Arrays;

public class occurrenceResult extends Result{
    private String sourceID;
    private String sourceName;
    private String objectType;
    private String objectName;

    public String getObjectName() {
        return objectName;
    }

    public String getObjectType() {
        return objectType;
    }

    public String getSourceID() {
        return sourceID;
    }

    public String getSourceName() {
        return sourceName;
    }

    public occurrenceResult(String sourceID, String sourceName,
                            String objectType, String objectName) {
        this.sourceID = sourceID;
        this.sourceName = sourceName;
        this.objectName = objectName;
        this.objectType = objectType;
    }

    // convert itself into front-end friendly ArrayLists
    public ArrayList<String> getHead() {
        return new ArrayList<>(Arrays.asList("Source ID", "Source Name",
                "Object Name", "Object Type"));
    }

    public ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>(Arrays.asList(getSourceID(), getSourceName(),
                getObjectName(), getObjectType()));
        return data;
    }

    public ArrayList<String> getLinks() {
        ArrayList<String> data = new ArrayList<>(Arrays.asList(getSourceID(), getSourceName(),
                getObjectName(), getObjectType()));
        return data;
    }
}
