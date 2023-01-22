package org.example.file3;

import java.util.ArrayList;

public class Report {
    private int id;
    private String title;
    private String value;
    private ArrayList<Report> values;

    public Report() {}

    public Report(int id, String title, String value, ArrayList<Report> values){
        this.id = id;
        this.title = title;
        this.value = value;
        this.values = values;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ArrayList<Report> getValues() {
        return values;
    }

    public void setValues(ArrayList<Report> values) {
        this.values = values;
    }
}
