package com.example.android.basicandroidapp;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.microsoft.azure.mobile.MobileCenter;
import com.microsoft.azure.mobile.analytics.Analytics;
import com.microsoft.azure.mobile.crashes.Crashes;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable androidAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MobileCenter.start(getApplication(), "a48ababc-9701-425c-b3a0-133d8a73ad37",
                Analytics.class, Crashes.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView androidImage = (ImageView) findViewById(R.id.android);
        androidImage.setBackgroundResource(R.drawable.android_animate);
        androidAnimation = (AnimationDrawable) androidImage.getBackground();
        final Button btnAnimate = (Button) findViewById(R.id.animate);
        View.OnClickListener ocl;
        ocl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                androidAnimation.stop();
                androidAnimation.start();
            }
        };
        Analytics.trackEvent("Animate button clicked");
        btnAnimate.setOnClickListener(ocl);

        final Button btnCrash = (Button) findViewById(R.id.crash);
        View.OnClickListener lsn;
        lsn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Crashes.generateTestCrash();
                // throw new RuntimeException("This is a crash");
            }
        };
        Analytics.trackEvent("Crash button clicked");
        btnCrash.setOnClickListener(lsn);

    }
}
