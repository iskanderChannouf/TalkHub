package com.channoufiskander.TalkHub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            passerALaSingInActivity();
        }
    }, 2000);
}

    private void passerALaSingInActivity() {

        Intent intent = new Intent(this, SinginActivity.class);
        startActivity(intent);
        finish();
    }
}