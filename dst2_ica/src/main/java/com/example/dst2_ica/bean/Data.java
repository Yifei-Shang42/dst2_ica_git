package com.example.dst2_ica.bean;

import java.util.ArrayList;
import java.util.Arrays;

public class Data {
    /*
    * 2 scenarios, either the data only contains one item,
    * or the data is actually items separated by ;,
    * this case we split and return ArrayList
    * */
    private String info;
    private String link;
    private ArrayList<String> infoList;

    public Data(String info, String link) {
        if (info == null) {
            this.info = "NaN";
            this.link = "";
        } else {
            if (info.contains(";"))
                this.infoList = convertInfoList(info);
            this.info = info;
            this.link = link;
        }
    }

    public ArrayList<String> convertInfoList(String info) {
        return new ArrayList<>(Arrays.asList(info.split(";")));
    }

    public Data(String info) {
        if (info == null) {
            this.info = "NaN";
        } else {
            this.info = info;
        }
        this.link = "";
    }

    public boolean hasMultipleLinks() { return info.contains(";"); }

    public boolean hasLink() {
        return !link.equals("");
    }

    public String getInfo() {
        return info;
    }

    public String getLink() {
        if (!hasMultipleLinks())
            return link.replaceAll("~", info.replaceAll(" ", "%20"));
        else
            return link;
    }

    public ArrayList<String> getInfoList() {
        return infoList;
    }
}
