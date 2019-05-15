package com.example.cupidshuffle.surveys.utils;

public class Choice {
    Destination destination;
    String answerString;

    public Choice(String answerString, Destination destination) {
        this.answerString = answerString;
        this.destination = destination;
    }

    public Destination getDestination(){
        return destination;
    }git
}
