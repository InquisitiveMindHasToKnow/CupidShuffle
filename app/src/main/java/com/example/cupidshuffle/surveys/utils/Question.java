package com.example.cupidshuffle.surveys.utils;

import java.util.HashMap;
import java.util.Map;

public class Question {
    private Map<String, Choice> surveyHashMap = new HashMap<>();
    private String promptQuestion;
    private String selectedUserAnswer;

    public Question(String promptQuestion) {
        this.promptQuestion = promptQuestion;
    }

    public void addAnswer(String key, Choice answer){
        this.surveyHashMap.put(key,answer);
    }

    public Choice getSelectedUserAnswer(){
        return surveyHashMap.get(selectedUserAnswer);
    }

    public void setSelectedUserAnswer(String selectedUserAnswer) {
        this.selectedUserAnswer = selectedUserAnswer;
    }
}
