package com.example.projectdit2023;

public class model1 {
    String h_name, h_location, vaccine_name;
    int h_phone;
    double longi, lati;

    model1() {

    }

    public model1(String h_name, String h_location, String vaccine_name, int h_phone, double longi, double lati) {
        this.h_name = h_name;
        this.h_location = h_location;
        this.vaccine_name = vaccine_name;
        this.h_phone = h_phone;
        this.longi = longi;
        this.lati = lati;
    }

    public String getH_name() {
        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    public String getH_location() {
        return h_location;
    }

    public void setH_location(String h_location) {
        this.h_location = h_location;
    }

    public String getVaccine_name() {
        return vaccine_name;
    }

    public void setVaccine_name(String vaccine_name) {
        this.vaccine_name = vaccine_name;
    }

    public int getH_phone() {
        return h_phone;
    }

    public void setH_phone(int h_phone) {
        this.h_phone = h_phone;
    }

    public double getLongi() {
        return longi;
    }

    public void setLongi(double longi) {
        this.longi = longi;
    }

    public double getLati() {
        return lati;
    }

    public void setLati(double lati) {
        this.lati = lati;
    }
}