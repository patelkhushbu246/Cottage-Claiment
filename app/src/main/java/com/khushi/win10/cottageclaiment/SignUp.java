package com.khushi.win10.cottageclaiment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Win10 on 09-02-2017.
 */

public class SignUp extends AppCompatActivity {

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        final EditText fnET = (EditText) findViewById(R.id.ET_fn_ET);
        final EditText lnET = (EditText) findViewById(R.id.ET_ln_ET);
        final EditText emailET = (EditText) findViewById(R.id.ET_email_ET);
        final EditText passwordET = (EditText) findViewById(R.id.ET_password_ET);
        final EditText cpET = (EditText) findViewById(R.id.ET_cp_ET);
        final TextView genderTV = (TextView) findViewById(R.id.TV_gender_TV);
        final RadioButton femaleRB = (RadioButton) findViewById(R.id.RB_female_RB);
        final RadioButton maleRB = (RadioButton) findViewById(R.id.RB_male_RB);
        final EditText contactnoET=(EditText)findViewById(R.id.ET_contactno_ET);
        Button btnsignup = (Button) findViewById(R.id.btn_signup);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fnstr = fnET.getText().toString();
                String lnstr = lnET.getText().toString();
                String emailstr = emailET.getText().toString();
                String passwordstr = passwordET.getText().toString();
                String cpstr = cpET.getText().toString();
                String genderstr = genderTV.getText().toString();
                {
                    if (femaleRB.isChecked()) {
                        femaleRB.getText().toString();
                    } else {
                        maleRB.getText().toString();
                    }
                }
                String contactnostr=contactnoET.getText().toString();
                if (fnstr.isEmpty()) {
                    Toast.makeText(SignUp.this, "Firstname cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (lnstr.isEmpty()) {
                    Toast.makeText(SignUp.this, "Lastname cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (emailstr.isEmpty()) {
                    Toast.makeText(SignUp.this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(emailstr)) {
                    Toast.makeText(SignUp.this, "Enter valid email", Toast.LENGTH_SHORT).show();
                } else if (passwordstr.isEmpty()) {
                    Toast.makeText(SignUp.this, "Please enter password", Toast.LENGTH_SHORT).show();
                } else if (cpstr.isEmpty()) {
                    Toast.makeText(SignUp.this, "Please enter confirm password", Toast.LENGTH_SHORT).show();
                } else if (genderstr.isEmpty()) {
                    Toast.makeText(SignUp.this, "Please select your gender", Toast.LENGTH_SHORT).show();
                }else if(contactnostr.isEmpty()){
                    Toast.makeText(SignUp.this, "Please enter contact no", Toast.LENGTH_SHORT).show();
                }
                else if (!cpstr.equals(passwordstr)) {
                    Toast.makeText(SignUp.this, "Password dont match", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignUp.this, "Successfull!!", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(SignUp.this,HomeActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public static boolean isValidEmail(CharSequence target) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(target);
        return matcher.matches();
    }
}



