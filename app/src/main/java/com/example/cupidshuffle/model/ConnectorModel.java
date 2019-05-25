package com.example.cupidshuffle.model;

public class ConnectorModel {
    private String connect;
    private String picture;

    public ConnectorModel(String connect, String picture) {
        this.connect = connect;
        this.picture = picture;
    }

    public String getConnect() {
        return connect;
    }

    public String getPicture() {
        return picture;
    }
}
