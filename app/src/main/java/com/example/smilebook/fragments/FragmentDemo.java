package com.example.smilebook.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.smilebook.R;

public class FragmentDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fragment_demo);

        Button girlButton = findViewById(R.id.pinkButton);
        Button boyButton = findViewById(R.id.blueButton);

        boyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new BlueFragment());
            }
        });

        girlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new PinkFragment());
            }
        });
    }


    private void loadFragment(Fragment fragment) {
//        getSupportFragmentManager().beginTransaction()
//                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
//                .replace(R.id.colorFragment, fragment)
//                .commit();

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.setCustomAnimations(
//                android.R.anim.fade_in,
//                android.R.anim.fade_out
//        );
        fragmentTransaction.setCustomAnimations(
                android.R.anim.slide_in_left,
                android.R.anim.slide_out_right
        );
        fragmentTransaction.replace(R.id.colorFragment, fragment);


        fragmentTransaction.commit();

    }
}