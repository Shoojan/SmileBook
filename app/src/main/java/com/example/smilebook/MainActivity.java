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
import com.example.smilebook.husbandwife.HusbandActivity;

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

        Intent intent = getIntent();
        String profileName = intent.getStringExtra(Constant.PROFILE_NAME);

        TextView profileNameTextView = findViewById(R.id.profile_name);
        profileNameTextView.setText(profileName);

        Toast.makeText(MainActivity.this, "Did you just ignore me?", Toast.LENGTH_LONG).show();

        ImageButton friendImgBtn = findViewById(R.id.friend);
        friendImgBtn.setOnClickListener(view -> {
            Intent husbandIntent = new Intent(MainActivity.this, HusbandActivity.class);
            startActivity(husbandIntent);
        });
    }

}