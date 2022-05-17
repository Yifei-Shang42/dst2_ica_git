package com.example.dst2_ica.bean;

import java.util.ArrayList;
import java.util.Arrays;

public class dosingResult extends Result {
    private String drugName;
    private String url;

    public dosingResult(String drugName, String url) {
        this.drugName = drugName;
        this.url = url;
    }
    // convert itself into front-end friendly ArrayLists
    public ArrayList<String> getHead() {
        return new ArrayList<>(Arrays.asList("Drug Label", "Drug Name"));
    }

    public ArrayList<Data> getData() {
        ArrayList<Data> data = new ArrayList<>();

        data.add(new Data(url, "https://www.pharmgkb.org/labelAnnotation/"+url));
        data.add(new Data(drugName));
        return data;
    }
}
