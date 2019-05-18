package com.example.cupidshuffle.surveys.models;

import com.example.cupidshuffle.surveys.models.culturefinance.CultureLifestyle;
import com.example.cupidshuffle.surveys.models.finance.Finance;
import com.example.cupidshuffle.surveys.models.generalinterests.GeneralInterest;
import com.example.cupidshuffle.surveys.models.hobbies.Hobbies;
import com.example.cupidshuffle.surveys.models.sex.Sex;

public class Questionaire {
    private Finance finance;
    private Hobbies hobbies;
    private CultureLifestyle cultureLifestyle;
    private Sex sex;
    private GeneralInterest generalInterest;

    public Finance getFinance() {
        return finance;
    }

    public Hobbies getHobbies() {
        return hobbies;
    }

    public CultureLifestyle getCultureLifestyle() {
        return cultureLifestyle;
    }

    public Sex getSex() {
        return sex;
    }

    public GeneralInterest getGeneralInterest() {
        return generalInterest;
    }


}
