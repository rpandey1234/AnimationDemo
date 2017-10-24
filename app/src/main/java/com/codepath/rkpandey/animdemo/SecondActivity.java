package com.codepath.rkpandey.animdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // TODO: do the reverse transitions here.
        // https://guides.codepath.com/android/Animations#activity-transitions
        // overridePendingTransition();
    }
}
