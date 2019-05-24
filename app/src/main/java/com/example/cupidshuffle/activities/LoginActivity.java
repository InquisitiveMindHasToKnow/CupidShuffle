package com.example.cupidshuffle.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cupidshuffle.R;
import com.squareup.picasso.Picasso;

public class LoginActivity extends AppCompatActivity {

    private static final String SHARED_PREFS_KEY = "sharedPrefsTesting";
    private long lastButtonClickTime = 0;
    private TextView loginScreenTitleTextView;
    private TextView loginOrRegisterPrompt;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private CheckBox rememberMeCheckBox;
    private Button loginButton;
    private Button registerButton;
    private SharedPreferences loginSharedPreferences;
    private ImageView loginPageImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginScreenTitleTextView = findViewById(R.id.login_screen_title_textview);
        loginOrRegisterPrompt = findViewById(R.id.sign_in_prompt_textview);
        usernameEditText = findViewById(R.id.user_name_edittext);
        passwordEditText = findViewById(R.id.user_password_edittext);
        rememberMeCheckBox = findViewById(R.id.remember_me_checkbox);
        loginButton = findViewById(R.id.login_button);
        registerButton = findViewById(R.id.register_button);
        loginPageImage = findViewById(R.id.loginRegistrationImageView);

        registerButton.setPaintFlags(registerButton.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        Picasso.get()
                .load(R.drawable.cupid2)
                .into(loginPageImage);

        loginSharedPreferences = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);

        if (loginSharedPreferences.getBoolean("isChecked", false)) {
            usernameEditText.setText(loginSharedPreferences.getString("username", null));
            passwordEditText.setText(loginSharedPreferences.getString("password", null));
            rememberMeCheckBox.setChecked(loginSharedPreferences.getBoolean("isChecked", false));
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (SystemClock.elapsedRealtime() - lastButtonClickTime < 3000) {
                    return;
                }
                lastButtonClickTime = SystemClock.elapsedRealtime();

                SharedPreferences.Editor editor = loginSharedPreferences.edit();
                if (rememberMeCheckBox.isChecked()) {
                    editor.putString("username", usernameEditText.getText().toString());
                    editor.putString("password", passwordEditText.getText().toString());
                    editor.putBoolean("isChecked", rememberMeCheckBox.isChecked());
                    editor.commit();
                } else {
                    editor.putBoolean("isChecked", rememberMeCheckBox.isChecked());
                    editor.commit();
                }
                String checkUser = "user" + usernameEditText.getText().toString();
                String checkPassword = "password" + usernameEditText.getText().toString();

                if (usernameEditText.getText().toString().equalsIgnoreCase(loginSharedPreferences.getString(checkUser, null))
                        && passwordEditText.getText().toString().equals(loginSharedPreferences.getString(checkPassword, null))) {
                    Intent loginIntent = new Intent(LoginActivity.this, PageAfterLoginActivity.class);
                    loginIntent.putExtra("currentUser", usernameEditText.getText().toString());
                    LoginActivity.this.finish();
                    LoginActivity.this.startActivity(loginIntent);
                } else {
                    Toast.makeText(LoginActivity.this.getApplicationContext(), "Username or password invalid!", Toast.LENGTH_LONG).show();
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SystemClock.elapsedRealtime() - lastButtonClickTime < 3000) {
                    return;
                }
                lastButtonClickTime = SystemClock.elapsedRealtime();
                Intent registerIntent = new Intent(LoginActivity.this, UserRegistrationActivity.class);
                registerIntent.putExtra("testKey", SHARED_PREFS_KEY);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

    }
}
