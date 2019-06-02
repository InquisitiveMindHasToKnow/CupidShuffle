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
    private String financeWidth;
    private String hobbiesWidth;
    private String cultureWidth;
    private String sexWidth;
    private String generalWidth;

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
        financeWidth = in.readString();
        hobbiesWidth = in.readString();
        cultureWidth = in.readString();
        sexWidth = in.readString();
        generalWidth = in.readString();
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
        dest.writeString(financeWidth);
        dest.writeString(hobbiesWidth);
        dest.writeString(cultureWidth);
        dest.writeString(sexWidth);
        dest.writeString(generalWidth);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public String getFinanceWidth() {
        return financeWidth;
    }

    public String getHobbiesWidth() {
        return hobbiesWidth;
    }

    public String getCultureWidth() {
        return cultureWidth;
    }

    public String getSexWidth() {
        return sexWidth;
    }

    public String getGeneralWidth() {
        return generalWidth;
    }
}
