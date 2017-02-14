package com.khushi.win10.cottageclaiment;




import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.khushi.win10.cottageclaiment.SignUp.isValidEmail;

public class MainActivity extends AppCompatActivity {
    private TextView tvsignup;
    private Button btnlogin;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvsignup=(TextView)findViewById(R.id.main_tv_signup);
        tvsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SignUp.class);

                startActivity(intent);


            }
        });
//        btnlogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });

        final EditText emET=(EditText)findViewById(R.id.main_et_email);
        final EditText passET=(EditText)findViewById(R.id.main_et_password);
        btnlogin=(Button)findViewById(R.id.main_btn_login);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stremail=emET.getText().toString();
                String strpass=passET.getText().toString();
                if (stremail.isEmpty()){
                    Toast.makeText(MainActivity.this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else if (!isValidEmail(stremail)){
                    Toast.makeText(MainActivity.this, "Enter valid email", Toast.LENGTH_SHORT).show();
                }
                else if (strpass.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Login Successfull!!", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(intent);

                }
            }
        });




    }
    public static boolean isValidEmail(CharSequence target)
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern=Pattern.compile(EMAIL_PATTERN);
        matcher=pattern.matcher(target);
        return matcher.matches();
    }
}