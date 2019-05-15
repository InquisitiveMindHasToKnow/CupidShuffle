package com.example.cupidshuffle.model;

public class UserProfiles {

    private String user;
    private String gender;
    private String age;
    private String location;
    private String bio;
    private String picture;
    private String occupation;

    public UserProfiles(String user, String gender, String age, String location, String bio, String picture, String occupation) {
        this.user = user;
        this.gender = gender;
        this.age = age;
        this.location = location;
        this.bio = bio;
        this.picture = picture;
        this.occupation = occupation;
    }

    public String getUser() {
        return user;
    }

    public String getPicture() {
        return picture;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    public String getBio() {
        return bio;
    }

    public String getOccupation() {
        return occupation;
    }
}
