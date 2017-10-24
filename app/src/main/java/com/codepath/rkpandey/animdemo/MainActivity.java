package com.codepath.rkpandey.animdemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /**
     * Objective: Move button to top of screen, then fade out
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btnAnimate = findViewById(R.id.btnAnimate);

        btnAnimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                // 1. Button Y, current => 0
                ObjectAnimator moveToTop = ObjectAnimator.ofFloat(view, View.Y, 0);
                moveToTop.setDuration(500);
                moveToTop.setInterpolator(new DecelerateInterpolator());
                moveToTop.setRepeatCount(3);
                moveToTop.setRepeatMode(ValueAnimator.REVERSE);

                // 2. Button alpha, current => 0
                ObjectAnimator fadeOut = ObjectAnimator.ofFloat(view, "alpha", 0);
                fadeOut.setInterpolator(new BounceInterpolator());


                AnimatorSet animatorSet = new AnimatorSet();
                // animatorSet.playSequentially(moveToTop, fadeOut);
                // Alternate Builder syntax for animator set
                animatorSet.play(moveToTop).before(fadeOut);
                animatorSet.start();
            }
        });
    }
}
