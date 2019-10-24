package com.myexample.resume.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "PersonalDataModel")
public class PersonalDataModel {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    public String name;
    private String email;
    private String address;
    private String phone;
    private String careerSummary;
    private String image;

    public PersonalDataModel( String name, String email, String address, String phone, String careerSummary) {

        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.careerSummary = careerSummary;

    }



    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getCareerSummary() {
        return careerSummary;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
