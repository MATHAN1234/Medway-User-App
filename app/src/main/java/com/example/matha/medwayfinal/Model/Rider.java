package com.example.matha.medwayfinal.Model;

/**
 * Created by sickbay on 12/14/2017.
 */

public class Rider {
    private String phone;
    private String password,email,name,allergies,medication,GaurName,GaurPhone,relations,DOB,BloodGroup;;

    public Rider() {
    }

    public Rider(String bloodGroup, String DOB, String relations, String medication, String password, String phone, String email, String allergies, String name, String gaurName, String gaurPhone) {
        BloodGroup = bloodGroup;
        this.DOB = DOB;
        this.relations = relations;
        this.medication = medication;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.allergies = allergies;
        this.name = name;
        GaurName = gaurName;
        GaurPhone = gaurPhone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getGaurName() {
        return GaurName;
    }

    public void setGaurName(String gaurName) {
        GaurName = gaurName;
    }

    public String getGaurPhone() {
        return GaurPhone;
    }

    public void setGaurPhone(String gaurPhone) {
        GaurPhone = gaurPhone;
    }

    public String getRelations() {
        return relations;
    }

    public void setRelations(String relations) {
        this.relations = relations;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getBloodGroup() {
        return BloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        BloodGroup = bloodGroup;
    }
}
