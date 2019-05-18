package com.example.cupidshuffle.surveys.models.finance;

public class Finance {
    private String category;
    private FinanceQuestionOne questionOne;
    private FinanceQuestionTwo questionTwo;
    private FinanceQuestionThree questionThree;
    private FinanceQuestionFour questionFour;
    private FinanceQuestionFive questionFive;

    public String getCategory() {
        return category;
    }

    public FinanceQuestionOne getQuestionOne() {
        return questionOne;
    }

    public FinanceQuestionTwo getQuestionTwo() {
        return questionTwo;
    }

    public FinanceQuestionThree getQuestionThree() {
        return questionThree;
    }

    public FinanceQuestionFour getQuestionFour() {
        return questionFour;
    }

    public FinanceQuestionFive getQuestionFive() {
        return questionFive;
    }
}
