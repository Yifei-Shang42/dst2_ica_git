package com.example.dst2_ica.bean;

import java.util.ArrayList;
import java.util.Arrays;

public class Drug extends Result {
    private String drug_name;
    private String trade_name;

    public Drug(String drug_name, String trade_name) {
        this.drug_name = drug_name;
        this.trade_name = trade_name;
    }

    // convert itself into front-end friendly ArrayLists
    public ArrayList<String> getHead() {
        return new ArrayList<>(Arrays.asList("Drug Name", "Trade Name(s)"));
    }

    public ArrayList<Data> getData() {
        ArrayList<Data> data = new ArrayList<>();
        data.add(new Data(drug_name));
        data.add(new Data(trade_name));
        return data;
    }
}
