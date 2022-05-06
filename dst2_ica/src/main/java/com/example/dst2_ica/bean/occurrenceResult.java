package com.example.dst2_ica.bean;

import java.util.ArrayList;
import java.util.Arrays;

public class occurrenceResult extends Result{
    private String sourceType;
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
                            String objectType, String objectName, String sourceType) {
        this.sourceID = sourceID;
        this.sourceName = sourceName;
        this.objectName = objectName;
        this.objectType = objectType;
        this.sourceType = sourceType;
    }

    // convert itself into front-end friendly ArrayLists
    public ArrayList<String> getHead() {
        return new ArrayList<>(Arrays.asList("Source ID", "Source Name",
                "Object Name", "Object Type"));
    }   

    public ArrayList<Data> getData() {
        ArrayList<Data> data = new ArrayList<>();
        if (sourceType.equals("Literature"))
            data.add(new Data(sourceID, "https://www.ncbi.nlm.nih.gov/pmc/articles/"+sourceID));
        else
            data.add(new Data(sourceID, "https://www.pharmgkb.org/pathway/"+sourceID+"/overview"));
        data.add(new Data(sourceName));
        data.add(new Data(objectName, "display?search="+objectName.replaceAll(" ", "%20")+"&db="+objectType.toLowerCase()+"&section=overview"));
        data.add(new Data(objectType));
        return data;
    }
}
