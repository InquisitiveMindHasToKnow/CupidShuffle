package com.example.cupidshuffle.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cupidshuffle.R;
import com.mikhaellopez.circularimageview.CircularImageView;

public class MainUserProfile extends AppCompatActivity {

    private ImageView mainUserProfilePictureImageView;
    private TextView mainUserProfileUserNameTextView;
    private TextView mainUserProfileUserLocationTextView;
    private TextView mainUserProfileUserOccupationTextView;
    private TextView mainUserProfileUserUserBio;
    private TextView mainUserProfileConnectSuggestionTextView;
    private CircularImageView connectOne;
    private CircularImageView connectTwo;
    private CircularImageView connectThree;
    private CircularImageView connectFour;
    private CircularImageView connectFive;
    private CircularImageView connectSix;
    private CircularImageView connectSeven;
    private CircularImageView connectEight;
    private Intent toConnectsPersonalPageIntent;

    private LinearLayout shuffleLinearLayout;
    private LinearLayout messageLinearLayout;
    private LinearLayout requestLinearLayout;

    private static final String USER_NAME = "username";
    private static final String USER_AGE = "userage";
    private static final String USER_OCCUPATION = "useroccupation";
    private static final String USER_PICTURE = "userpicture";
    private static final String USER_LOCATION = "userlocation";
    private static final String USER_BIO = "userbio";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user_profile);


        mainUserProfilePictureImageView = findViewById(R.id.main_user_profile_imageview);
        mainUserProfileUserNameTextView = findViewById(R.id.main_user_profile_username_textview);
        mainUserProfileUserLocationTextView = findViewById(R.id.main_user_profile_location_textview);
        mainUserProfileUserOccupationTextView = findViewById(R.id.main_user_profile_occupation_textview);
        mainUserProfileUserUserBio = findViewById(R.id.main_user_profile_bio_textview);
        mainUserProfileConnectSuggestionTextView = findViewById(R.id.main_user_profile_connect_suggestion_textview);
        connectOne = findViewById(R.id.main_user_profile_first_connect);
        connectTwo = findViewById(R.id.main_user_profile_second_connect);
        connectThree = findViewById(R.id.main_user_profile_third_connect);
        connectFour = findViewById(R.id.main_user_profile_fourth_connect);
        connectFive = findViewById(R.id.main_user_profile_fifth_connect);
        connectSix = findViewById(R.id.main_user_profile_sixth_connect);
        connectSeven = findViewById(R.id.main_user_profile_seventh_connect);
        connectEight = findViewById(R.id.main_user_profile_eighth_connect);

        shuffleLinearLayout = findViewById(R.id.main_user_profile_connect_linear_layout);
        messageLinearLayout = findViewById(R.id.main_user_profile_messages_linear_layout);
        requestLinearLayout = findViewById(R.id.main_user_profile_request_linear_layout);

        shuffleLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toShuffledLoveBirdIntent = new Intent(MainUserProfile.this, ShuffleTheLoveBirdsActivity.class);
                startActivity(toShuffledLoveBirdIntent);

            }
        });



        messageLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toPrivateMessagesAndRequestsRecyclerViewIntent = new Intent(MainUserProfile.this, ViewPrivateMessagesAndConnectionRequest.class);
                startActivity(toPrivateMessagesAndRequestsRecyclerViewIntent);
            }
        });


        requestLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        connectOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String connectOneName = "Nickki Parker";
                String connectOneAge = "35";
                String connectOneJob = "Cyber Guru";
                String connectOnePicture = "https://pmctvline2.files.wordpress.com/2016/02/arrow-felicity-father-reunion-calculator.jpg?w=619";
                String connectOneLocation = "Houston, TX";
                String connectOneBio = "Coding is life!";

                toConnectsPersonalPageIntent = new Intent(MainUserProfile.this, IndividualProfilePage.class);
                toConnectsPersonalPageIntent.putExtra(USER_NAME, connectOneName);
                toConnectsPersonalPageIntent.putExtra(USER_AGE, connectOneAge);
                toConnectsPersonalPageIntent.putExtra(USER_PICTURE, connectOnePicture);
                toConnectsPersonalPageIntent.putExtra(USER_LOCATION, connectOneLocation);
                toConnectsPersonalPageIntent.putExtra(USER_OCCUPATION, connectOneJob);
                toConnectsPersonalPageIntent.putExtra(USER_BIO, connectOneBio);
                startActivity(toConnectsPersonalPageIntent);

            }
        });

        connectTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String connectTwoName = "Penny Hofstadter";
                String connectTwoAge = "28";
                String connectTwoJob = "Bartender Extraordinaire";
                String connectTwoPicture = "https://hips.hearstapps.com/digitalspyuk.cdnds.net/18/09/1519992073-penny-the-big-bang-theory.jpg";
                String connectTwoLocation = "New Haven, CT";
                String connectTwoBio = "Did someone say drink?!";

                toConnectsPersonalPageIntent = new Intent(MainUserProfile.this, IndividualProfilePage.class);
                toConnectsPersonalPageIntent.putExtra(USER_NAME, connectTwoName);
                toConnectsPersonalPageIntent.putExtra(USER_AGE, connectTwoAge);
                toConnectsPersonalPageIntent.putExtra(USER_OCCUPATION, connectTwoJob);
                toConnectsPersonalPageIntent.putExtra(USER_PICTURE, connectTwoPicture);
                toConnectsPersonalPageIntent.putExtra(USER_LOCATION, connectTwoLocation);
                toConnectsPersonalPageIntent.putExtra(USER_BIO, connectTwoBio);
                startActivity(toConnectsPersonalPageIntent);
            }
        });

        connectThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String connectThreeName = "Emily Turner";
                String connectThreeAge = "20";
                String connectThreeJob = "Actress";
                String connectThreePicture = "https://afro.com/wp-content/uploads/2018/09/Meagan-Good-001.jpg";
                String connectThreeLocation = "Sacramento, CA";
                String connectThreeBio = "Girl, it's 90 day rule or else!";

                toConnectsPersonalPageIntent = new Intent(MainUserProfile.this, IndividualProfilePage.class);
                toConnectsPersonalPageIntent.putExtra(USER_NAME, connectThreeName);
                toConnectsPersonalPageIntent.putExtra(USER_AGE, connectThreeAge);
                toConnectsPersonalPageIntent.putExtra(USER_OCCUPATION, connectThreeJob);
                toConnectsPersonalPageIntent.putExtra(USER_PICTURE, connectThreePicture);
                toConnectsPersonalPageIntent.putExtra(USER_LOCATION, connectThreeLocation);
                toConnectsPersonalPageIntent.putExtra(USER_BIO, connectThreeBio);
                startActivity(toConnectsPersonalPageIntent);

            }
        });

        connectFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String connectFourName = "Natalie Baker";
                String connectFourAge = "42";
                String connectFourJob = "Pharmacist";
                String connectFourPicture = "https://www.biography.com/.image/t_share/MTIwNjA4NjMzNjk1NTM2NjUy/monique-517474-1-402.jpg";
                String connectFourLocation = "Orange, NJ";
                String connectFourBio = "Heeeey, Professor Oglevee!";

                toConnectsPersonalPageIntent = new Intent(MainUserProfile.this, IndividualProfilePage.class);
                toConnectsPersonalPageIntent.putExtra(USER_NAME, connectFourName);
                toConnectsPersonalPageIntent.putExtra(USER_AGE, connectFourAge);
                toConnectsPersonalPageIntent.putExtra(USER_OCCUPATION, connectFourJob);
                toConnectsPersonalPageIntent.putExtra(USER_PICTURE, connectFourPicture);
                toConnectsPersonalPageIntent.putExtra(USER_LOCATION, connectFourLocation);
                toConnectsPersonalPageIntent.putExtra(USER_BIO, connectFourBio);
                startActivity(toConnectsPersonalPageIntent);
            }
        });

        connectFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String connectFiveName = "Princess Gordon";
                String connectFiveAge = "39";
                String connectFiveJob = "Lawyer";
                String connectFivePicture = "https://www.emmys.com/sites/default/files/styles/bio_pics_detail/public/bios/sandra-oh-2018-nom-450x600.jpg?itok=4POAOVme";
                String connectFiveLocation = "Seattle, WA";
                String connectFiveBio = "Know your rights or you dont have any.";

                toConnectsPersonalPageIntent = new Intent(MainUserProfile.this, IndividualProfilePage.class);
                toConnectsPersonalPageIntent.putExtra(USER_NAME, connectFiveName);
                toConnectsPersonalPageIntent.putExtra(USER_AGE, connectFiveAge);
                toConnectsPersonalPageIntent.putExtra(USER_OCCUPATION, connectFiveJob);
                toConnectsPersonalPageIntent.putExtra(USER_PICTURE, connectFivePicture);
                toConnectsPersonalPageIntent.putExtra(USER_LOCATION, connectFiveLocation);
                toConnectsPersonalPageIntent.putExtra(USER_BIO, connectFiveBio);
                startActivity(toConnectsPersonalPageIntent);

            }
        });

        connectSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String connectSixName = "Natasha Saunders";
                String connectSixAge = "49";
                String connectSixJob = "Doctor";
                String connectSixPicture = "https://upload.wikimedia.org/wikipedia/commons/a/a3/Geethuanna.jpg";
                String connectSixLocation = "Baltimore, MD";
                String connectSixBio = "Health is wealth. Love yourself!";

                toConnectsPersonalPageIntent = new Intent(MainUserProfile.this, IndividualProfilePage.class);
                toConnectsPersonalPageIntent.putExtra(USER_NAME, connectSixName);
                toConnectsPersonalPageIntent.putExtra(USER_AGE, connectSixAge);
                toConnectsPersonalPageIntent.putExtra(USER_OCCUPATION, connectSixJob);
                toConnectsPersonalPageIntent.putExtra(USER_PICTURE, connectSixPicture);
                toConnectsPersonalPageIntent.putExtra(USER_LOCATION, connectSixLocation);
                toConnectsPersonalPageIntent.putExtra(USER_BIO, connectSixBio);
                startActivity(toConnectsPersonalPageIntent);

            }
        });

        connectSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String connectSevenName = "Madonna Brown";
                String connectSevenAge = "52";
                String connectSevenJob = "Teacher";
                String connectSevenPicture = "https://www.cmchealthcare.org/wp-content/uploads/sites/18/2019/01/laura-kee_pp.jpg";
                String connectSevenLocation = "Miami, FL";
                String connectSevenBio = "Education is the key to success!";

                toConnectsPersonalPageIntent = new Intent(MainUserProfile.this, IndividualProfilePage.class);
                toConnectsPersonalPageIntent.putExtra(USER_NAME, connectSevenName);
                toConnectsPersonalPageIntent.putExtra(USER_AGE, connectSevenAge);
                toConnectsPersonalPageIntent.putExtra(USER_OCCUPATION, connectSevenJob);
                toConnectsPersonalPageIntent.putExtra(USER_PICTURE, connectSevenPicture);
                toConnectsPersonalPageIntent.putExtra(USER_LOCATION, connectSevenLocation);
                toConnectsPersonalPageIntent.putExtra(USER_BIO, connectSevenBio);
                startActivity(toConnectsPersonalPageIntent);

            }
        });

        connectEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String connectEightName = "Tanya Riley";
                String connectEightAge = "44";
                String connectEightJob = "Entrepreneur";
                String connectEightPicture = "https://www.biography.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cg_face%2Cq_auto:good%2Cw_300/MTQzMzAyMTU3MjA5MTgzODE1/tyra-banks_gettyimages-516572662jpg.jpg";
                String connectEightLocation = "Yuma, AZ";
                String connectEightBio = "Be your own boss.";

                toConnectsPersonalPageIntent = new Intent(MainUserProfile.this, IndividualProfilePage.class);
                toConnectsPersonalPageIntent.putExtra(USER_NAME, connectEightName);
                toConnectsPersonalPageIntent.putExtra(USER_AGE, connectEightAge);
                toConnectsPersonalPageIntent.putExtra(USER_OCCUPATION, connectEightJob);
                toConnectsPersonalPageIntent.putExtra(USER_PICTURE, connectEightPicture);
                toConnectsPersonalPageIntent.putExtra(USER_LOCATION, connectEightLocation);
                toConnectsPersonalPageIntent.putExtra(USER_BIO, connectEightBio);
                startActivity(toConnectsPersonalPageIntent);
            }
        });

    }
}
