package com.example.dst2_ica.bean;

import java.util.ArrayList;
import java.util.Arrays;

public class annotationResult extends Result{
    private String gene_name;
    private String drug_name;
    private String disease_name;
    private String variant_name;
    private String evidence;
    private String category;

    public String getCategory() {
        return category;
    }

    public String getDisease_name() {
        return disease_name;
    }

    public String getDrug_name() {
        return drug_name;
    }

    public String getEvidence() {
        return evidence;
    }

    public String getGene_name() {
        return gene_name;
    }

    public String getVariant_name() {
        return variant_name;
    }

    public annotationResult(String gene_name, String drug_name,
                            String disease_name, String variant_name,
                            String evidence, String category) {
        this.gene_name = gene_name;
        this.drug_name = drug_name;
        this.disease_name = disease_name;
        this.variant_name = variant_name;
        this.evidence = evidence;
        this.category = category;
    }

    // convert itself into front-end friendly ArrayLists
    public ArrayList<String> getHead() {
        return new ArrayList<>(Arrays.asList("Evidence Level", "Gene", "Variant", "Drug",
                "Disease", "Phenotype Category"));
    }

    public ArrayList<Data> getData() {
        ArrayList<Data> data = new ArrayList<>();
        data.add(new Data(evidence));
        data.add(new Data(gene_name, "display?search=~&db=gene&section=overview"));
        data.add(new Data(variant_name, "display?search=~&db=variant&section=overview"));
        data.add(new Data(drug_name, "display?search=~&db=drug&section=overview"));
        data.add(new Data(disease_name, "display?search=~&db=disease&section=overview"));
        data.add(new Data(category));
        return data;
    }
}
