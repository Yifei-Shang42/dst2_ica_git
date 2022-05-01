package com.example.dst2_ica.bean;

public class annotationResult {
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
}
