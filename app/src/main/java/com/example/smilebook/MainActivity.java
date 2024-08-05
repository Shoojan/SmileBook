package com.example.smilebook;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.smilebook.constants.Constant;
import com.example.smilebook.fragments.FragmentDemo;
import com.example.smilebook.intents.HusbandActivity;
import com.example.smilebook.list_grid_recycler.ViewAdapterActivity;
import com.example.smilebook.maps.MapsActivity;
import com.example.smilebook.menus.MenuActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        String profileName = intent.getStringExtra(Constant.PROFILE_NAME);

        TextView profileNameTextView = findViewById(R.id.profile_name);
        profileNameTextView.setText(profileName);

        Toast.makeText(MainActivity.this, "Did you just ignore me?", Toast.LENGTH_LONG).show();

        ImageButton mapHomeImgBtn = findViewById(R.id.home);
        mapHomeImgBtn.setOnClickListener(view -> {
            Intent mapIntent = new Intent(MainActivity.this, MapsActivity.class);
            startActivity(mapIntent);
        });

        ImageButton friendImgBtn = findViewById(R.id.friend);
        friendImgBtn.setOnClickListener(view -> {
            Intent husbandIntent = new Intent(MainActivity.this, HusbandActivity.class);
            startActivity(husbandIntent);
        });

        ImageButton messageImgBtn = findViewById(R.id.message);
        messageImgBtn.setOnClickListener(view -> {
            Intent fragmentIntent = new Intent(MainActivity.this, FragmentDemo.class);
            startActivity(fragmentIntent);
        });


        ImageButton menuImgBtn = findViewById(R.id.menu);
        menuImgBtn.setOnClickListener(view -> {
            Intent fragmentIntent = new Intent(MainActivity.this, MenuActivity.class);
            startActivity(fragmentIntent);
        });

        ImageButton listViewImgBtn = findViewById(R.id.notification);
        listViewImgBtn.setOnClickListener(view -> {
            Intent fragmentIntent = new Intent(MainActivity.this, ViewAdapterActivity.class);
            startActivity(fragmentIntent);
        });
    }
}