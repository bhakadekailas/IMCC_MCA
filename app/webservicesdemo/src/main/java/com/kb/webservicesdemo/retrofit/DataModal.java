package com.kb.webservicesdemo.retrofit;

public class DataModal {

    private String name;
    private String job;

    public DataModal(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "DataModal{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}