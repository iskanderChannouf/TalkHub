package com.channoufiskander.TalkHub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.channoufiskander.TalkHub.databinding.ActivitySinginBinding;

public class SinginActivity extends AppCompatActivity {

    DataBaseHelper dataBaseHelper;
    ActivitySinginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySinginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dataBaseHelper =new DataBaseHelper(this);

        binding.signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.emailEdit.getText().toString();
                String password = binding.passwordEdit.getText().toString();

                if (email.equals("") || password.equals("")){
                    Toast.makeText(SinginActivity.this,"Make sure that all fields are correct to continue",Toast.LENGTH_SHORT).show();
                }else {
                    boolean checkCredentials = dataBaseHelper.checkEmailPassword(email,password);

                    if (checkCredentials){
                        Toast.makeText(SinginActivity.this,"Log in successfully",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),HomeTalkHub.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(SinginActivity.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                    }
                }
            }

            /*famma partie lazma code 2225*/
        });
    }

    public void onSignUpClick(View view) {
        // Créez une intention pour passer à l'activité d'inscription
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }

    /*
    public void onForgetPasswordClick(View view) {
        // Créez une intention pour passer à l'activité de récupération de mot de passe
        Intent intent = new Intent(this, ForgetPasswordActivity.class);
        startActivity(intent);
    }


    public void onLoginClick(View view) {
        // Créez une intention pour passer à l'activité de connexion
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }*/
}
