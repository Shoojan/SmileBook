package com.example.smilebook.husbandwife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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

    private String selectedGift;

    private Spinner giftsSpinner;

    private final ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        String resultValue = data.getStringExtra(Constant.GIFT_RESPONSE);

                        Toast.makeText(HusbandActivity.this, "She is " + resultValue, Toast.LENGTH_LONG).show();
                    }
                }
            });

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

        giftsSpinner = findViewById(R.id.giftsSpinner);

        // Setting up the Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, this.gifts);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        giftsSpinner.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();

        Button giftSendBtn = findViewById(R.id.giftSendBtn);

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

            //            activityResultLauncher.launch(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant.GIFT_SEND_CODE && resultCode == RESULT_OK && data != null) {
            String response = data.getStringExtra(Constant.GIFT_RESPONSE);
            // Display response in any suitable way, for example, in a Toast
            Toast.makeText(HusbandActivity.this, response, Toast.LENGTH_LONG).show();
        }
    }

}