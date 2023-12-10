package com.channoufiskander.TalkHub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.channoufiskander.TalkHub.databinding.ActivitySignupBinding;

public class Signup extends AppCompatActivity {


    DataBaseHelper dataBaseHelper;
    ActivitySignupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        dataBaseHelper = new DataBaseHelper(this);
        binding.buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName = binding.editTextFullName.getText().toString();
                String email = binding.editTextEmailAddress.getText().toString();
                String phoneNumber = binding.editTextPhoneNumber.getText().toString();
                String password = binding.editTextPass.getText().toString();
                String confirmPassword = binding.editTextConfPass.getText().toString();

                if (fullName.equals("") || email.equals("") || phoneNumber.equals("") || password.equals("") || confirmPassword.equals("")){
                    Toast.makeText(Signup.this,"Make sure that all fields are correct to continue",Toast.LENGTH_SHORT).show();
                }else {
                    if (password.equals(confirmPassword)){
                        boolean checkUserEmail= dataBaseHelper.checkEmail(email);

                        if (checkUserEmail==false){
                            boolean insert= dataBaseHelper.insertData(fullName,email,phoneNumber,password);

                            if (insert==true){
                                Toast.makeText(Signup.this,"SignUp successfully ",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),SinginActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(Signup.this,"SignUp failed successfully  ",Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(Signup.this,"Email already used ",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(Signup.this,"Passwords do NOT match ",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        /*binding.SinginRedirectText.setOnclickListener()*/
    }
}