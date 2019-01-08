package com.example.jasperreport.model;

/**
 * This class should be map with jrxml file
 * for this on in jrxml required two fields
 *  1.name
 *  2.country
 *
 *  If you doutb let check jasper_report_template.jrxml file in resource/jasper folder
 */
public class ExampleModel {
    private String name;
    private String country;

    public String getName() {
        return name;
    }

    public ExampleModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public ExampleModel setCountry(String country) {
        this.country = country;
        return this;
    }
}