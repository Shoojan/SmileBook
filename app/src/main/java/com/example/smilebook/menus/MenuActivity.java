package com.example.smilebook.menus;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import com.example.smilebook.R;

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Register the TextView for Context Menu
        TextView contentTextView = findViewById(R.id.contentTextView);
        registerForContextMenu(contentTextView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.mainPage) {// Simulate changing theme
            Toast.makeText(this, "Navigating to Main Page...", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.ajhai_padhney) {// Simulate opening settings
            Toast.makeText(this, "Next slide please...", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.aaja_lai_yeti) {// Simulate opening settings
            Toast.makeText(this, "Bye bye!", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.messageMenu) {// Simulate opening settings
            Toast.makeText(this, "Navigating to Messages...", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Context Menu setup
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.rename) {
            Toast.makeText(this, "Renaming...", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.delete) {
            Toast.makeText(this, "Deleting...", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onContextItemSelected(item);
    }


    // Popup Menu setup
    public void showPopupMenu(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.popup_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.share) {// Simulate sharing a recipe
                Toast.makeText(this, "Sharing...", Toast.LENGTH_SHORT).show();
                return true;
            } else if (itemId == R.id.add_to_favorites) {// Simulate adding to favorites
                Toast.makeText(this, "You are added to my favorites!", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });
        popup.show();
    }
}