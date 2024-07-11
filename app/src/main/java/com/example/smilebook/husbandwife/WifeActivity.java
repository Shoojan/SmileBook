package com.example.smilebook.husbandwife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.smilebook.R;
import com.example.smilebook.constants.Constant;

public class WifeActivity extends AppCompatActivity {

    private String response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wife);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView giftMessage = findViewById(R.id.giftMessage);
        Spinner replySpinner = findViewById(R.id.replySpinner);
        Button replyBtn = findViewById(R.id.replyBtn);

        String[] emotions = getResources().getStringArray(R.array.emotions);

        // Retrieve the gift from HusbandActivity
        Intent intent = getIntent();
        String gift = intent.getStringExtra(Constant.GIFT);
        giftMessage.setText("Gift 🎁 from Husband: " + gift);

        // Determine the response based on the gift
        replySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                response = emotions[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                response = emotions[0];
            }
        });

        // Reply to HusbandActivity
        replyBtn.setOnClickListener(view -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("response", response);
            setResult(RESULT_OK, resultIntent);
            finish(); // Ends WifeActivity and returns to HusbandActivity
        });
    }
}