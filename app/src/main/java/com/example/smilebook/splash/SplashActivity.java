package com.example.smilebook.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.smilebook.LoginActivity;
import com.example.smilebook.R;

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_DURATION = 2000; // Duration in milliseconds (3 seconds)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView logoImageView = findViewById(R.id.logoImageView);
        TextView appNameTextView = findViewById(R.id.appNameTextView);

        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.scale);
        logoImageView.startAnimation(fadeInAnimation);
        appNameTextView.startAnimation(fadeInAnimation);

        // Delay the transition to the main activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the main activity
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Close the splash activity
            }
        }, SPLASH_DURATION);
    }
}