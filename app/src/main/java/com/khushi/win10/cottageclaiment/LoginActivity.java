package com.khushi.win10.cottageclaiment;




import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    private TextView tvsignup;
    private Button btnlogin;
    private TextView tvforgotpassword;
    View dialogView;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvsignup=(TextView)findViewById(R.id.main_tv_signup);
        tvsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,SignUp.class);

                startActivity(intent);


            }
        });

        tvforgotpassword=(TextView)findViewById(R.id.main_tv_forgotpassword);
        tvforgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showForgetPwdDialog();

            }
        });
//

        final EditText emET=(EditText)findViewById(R.id.main_et_email);
        final EditText passET=(EditText)findViewById(R.id.main_et_password);
        btnlogin=(Button)findViewById(R.id.main_btn_login);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stremail=emET.getText().toString();
                String strpass=passET.getText().toString();
                if (stremail.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else if (!isValidEmail(stremail)){
                    Toast.makeText(LoginActivity.this, "Enter valid email", Toast.LENGTH_SHORT).show();
                }
                else if (strpass.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(LoginActivity.this, "Login Successfull!!", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(intent);
                }
            }
        });




    }

    private void showForgetPwdDialog() {
        dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_forget_pwd,null);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Security Questions")
                .setView(dialogView)
                .setPositiveButton("Verify", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        handleTextDialog();
//                        Intent intent=new Intent(LoginActivity.this,ForgotPassActivity.class);
//
//                        startActivity(intent);
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setCancelable(false)
                .create();
        dialog.show();
    }

    private void handleTextDialog() {
        if(dialogView != null){
            EditText editText = (EditText) dialogView.findViewById(R.id.forget_et_q1);
            String str = editText.getText().toString();
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
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