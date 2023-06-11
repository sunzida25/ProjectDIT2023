package com.example.projectdit2023;

public class UserHelper {
    String name,phone,password,gender,division,district,upozila,bloodGroup,bldUpo;

    public UserHelper(){

    }

    public UserHelper(String name, String phone, String password, String gender, String division, String district, String upozila,String bloodGroup,String bldUpo) {
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.gender = gender;
        this.division = division;
        this.district = district;
        this.upozila = upozila;
        this.bloodGroup=bloodGroup;
        this.bldUpo=bldUpo;
    }
    public String getBldUpo(){return bldUpo;}
    public void setBldUpo(String bldUpo) {this.bldUpo=bldUpo;}

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getUpozila() {
        return upozila;
    }

    public void setUpozila(String upozila) {
        this.upozila = upozila;
    }
}