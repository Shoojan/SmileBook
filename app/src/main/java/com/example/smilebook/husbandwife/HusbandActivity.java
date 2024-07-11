package com.example.smilebook.husbandwife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.smilebook.R;
import com.example.smilebook.constants.Constant;

public class HusbandActivity extends AppCompatActivity {

    // List of gifts
    private final String[] gifts = {"Flowers", "Chocolate", "Jewelry", "Book", "Perfume"};

    private static final int REQUEST_CODE = 1;
    private String selectedGift;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_husband);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Spinner giftsSpinner = findViewById(R.id.giftsSpinner);
        Button giftSendBtn = findViewById(R.id.giftSendBtn);

        // Setting up the Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, this.gifts);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        giftsSpinner.setAdapter(adapter);

        // Listener for Spinner selection
        giftsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedGift = gifts[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedGift = gifts[0];
            }
        });

        giftSendBtn.setOnClickListener(view -> {
            Intent intent = new Intent(HusbandActivity.this, WifeActivity.class);
            intent.putExtra(Constant.GIFT, selectedGift);
            startActivityForResult(intent, Constant.GIFT_SEND_CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String response = data.getStringExtra("response");
            // Display response in any suitable way, for example, in a Toast
            Toast.makeText(HusbandActivity.this, response, Toast.LENGTH_LONG).show();
        }
    }
}