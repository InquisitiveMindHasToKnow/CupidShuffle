package com.example.cupidshuffle.model;

import android.os.Parcel;
import android.os.Parcelable;

public class UserProfile implements Parcelable {

    private String user;
    private String gender;
    private String age;
    private String location;
    private String bio;
    private String picture;
    private String occupation;
    private String topCategoryOne;
    private String topCategoryTwo;
    private String topCategoryThree;

    protected UserProfile(Parcel in) {
        user = in.readString();
        gender = in.readString();
        age = in.readString();
        location = in.readString();
        bio = in.readString();
        picture = in.readString();
        occupation = in.readString();
        topCategoryOne = in.readString();
        topCategoryTwo = in.readString();
        topCategoryThree = in.readString();
    }

    public static final Creator<UserProfile> CREATOR = new Creator<UserProfile>() {
        @Override
        public UserProfile createFromParcel(Parcel in) {
            return new UserProfile(in);
        }

        @Override
        public UserProfile[] newArray(int size) {
            return new UserProfile[size];
        }
    };

    public String getUser() {
        return user;
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

    public String getPicture() {
        return picture;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getTopCategoryOne() {
        return topCategoryOne;
    }

    public String getTopCategoryTwo() {
        return topCategoryTwo;
    }

    public String getTopCategoryThree() {
        return topCategoryThree;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(user);
        dest.writeString(gender);
        dest.writeString(age);
        dest.writeString(location);
        dest.writeString(bio);
        dest.writeString(picture);
        dest.writeString(occupation);
        dest.writeString(topCategoryOne);
        dest.writeString(topCategoryTwo);
        dest.writeString(topCategoryThree);
    }
}
