package org.pursuit.unit_03_assessment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.pursuit.unit_03_assessment.R;

public class LoginActivity extends AppCompatActivity {

    private EditText emailView;
    private EditText passwordView;
    private CheckBox usernameCheckbox;
    private SharedPreferences sharedPreferences;

    private static final String SHARED_PREFS_KEY = "org.pursuit.unit_03_assessment";
    private static final String SHARED_USERNAME_KEY = "username";
    private static final String SHARED_PASSWORD_KEY = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailView = (EditText) findViewById(R.id.email_edittext);
        passwordView = (EditText) findViewById(R.id.password_edittext);
        usernameCheckbox = (CheckBox) findViewById(R.id.remember_username_checkbox);

        passwordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);


        getLoginCredentials();


        /*
        * TODO: add logic to set values to views:
        * TODO: 1. if there is a username value AND checkbox value in shared preferences - set the username EditText's value to the username value from shared preferences, and set the checkbox's value to the checkbox value from shared preferences
         */

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = emailView.getText().toString();
                String password = passwordView.getText().toString();
                boolean isSaveCredentialChecked = usernameCheckbox.isChecked();

                if (isSaveCredentialChecked) {
                    saveLoginCredential(username, password);
                }else{

                }
                attemptLogin();
            }
        });
    }

    private void saveLoginCredential(String username, String password) {
        sharedPreferences.edit()
                .putString(SHARED_USERNAME_KEY, username)
                .putString(SHARED_PASSWORD_KEY, password)
                .apply();
        Toast.makeText(getApplicationContext(), "Login credentials saved!", Toast.LENGTH_SHORT).show();
    }

    private void getLoginCredentials() {
        String username = sharedPreferences
                .getString(SHARED_USERNAME_KEY, "");
        String password = sharedPreferences
                .getString(SHARED_PASSWORD_KEY, "");

        emailView.setText(username);
        passwordView.setText(password);
    }

    private void attemptLogin() {

        emailView.setError(null);
        passwordView.setError(null);

        String email = emailView.getText().toString();
        String password = passwordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            passwordView.setError(getString(R.string.error_invalid_password));
            focusView = passwordView;
            cancel = true;
        }
        if (TextUtils.isEmpty(email)) {
            emailView.setError(getString(R.string.error_field_required));
            focusView = emailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            emailView.setError(getString(R.string.error_invalid_email));
            focusView = emailView;
            cancel = true;
        } else {
//            if (emailView.getText().equals("user@pursuit.org") && passwordView.getText().equals("Password")) {
                Intent intent = new Intent(LoginActivity.this, RecyclerActivity.class);
                startActivity(intent);



//            if (emailView.equals(sharedPreferences.getString(SHARED_PREFS_KEY, MODE_PRIVATE).get)){
//
//            }

            // String savedString = getSharedPreferences(SHAREDPREF_KEY, MODE_PRIVATE).getString("key", "");
            /*
             * TODO: Add logic to confirm that:
             * TODO: 2. the username matches the username stored in strings.xml and the password matches the password stored in strings.xml
             * TODO: 3. the checkbox is ticked - if both email and password in EditTexts match strings.xml, add username value and checkbox value to shared preferences
             * TODO: 4. the checkbox is NOT ticked - if it is not ticked, clear username in shared preferences
             * TODO: 5. if both email and password in EditTexts match strings.xml, move to RecyclerActivity
             */
        }

        if (cancel) {
            focusView.requestFocus();
        }
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }
}

