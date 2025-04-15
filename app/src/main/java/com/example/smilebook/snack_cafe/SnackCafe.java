package com.example.smilebook.snack_cafe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.smilebook.R;

public class SnackCafe extends AppCompatActivity {

    //    ListView snackListView;
    String selectedSnack;

    TextView orderItem;
    Button btnOffers;
    String[] snacks = {"🍕 Pizza", "🍩 Donut", "🍔 Burger", "\uD83E\uDD5F Momo", "\uD83C\uDF5C Noodles", "\uD83E\uDD5A Egg"};

    private int generateRandomNumber(int totalLength) {
        return (int) (Math.random() * totalLength);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Snack Attack Cafe");
        setContentView(R.layout.activity_snack_cafe);

        // ---------------- CONTEXT MENU ----------------
//        snackListView = findViewById(R.id.snackListView);
        orderItem = findViewById(R.id.orderItem);

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, snacks);
//        snackListView.setAdapter(adapter);

        // Register Context Menu for ListView
//        registerForContextMenu(snackListView);
        registerForContextMenu(orderItem);

        // ---------------- POPUP MENU ----------------
        btnOffers = findViewById(R.id.btnOffers);
        btnOffers.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bounce));

        // Popup Menu for Special Offers
        btnOffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
    }

    // ---------------- OPTION MENU ----------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.snack_option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_snack) {
            this.confirmOrder();
            return true;
        } else if (itemId == R.id.menu_bill) {
            orderItem.setText(null);
            return true;
        } else if (itemId == R.id.menu_exit) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void confirmOrder() {
        selectedSnack = snacks[this.generateRandomNumber(snacks.length)];
//            Toast.makeText(this, "🍩 Snack Ordered!", Toast.LENGTH_SHORT).show();

        this.displayAlertDialog();

    }

    private void displayAlertDialog() {
        new AlertDialog.Builder(this)
                .setTitle("🧾 Your Snack")
                .setMessage("So you love " + selectedSnack + " huh!")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        orderItem.setText(selectedSnack);
                    }
                })
                .setNegativeButton("No!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        orderItem.setText(null);
                    }
                })
                .setNeutralButton("Next Order", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        confirmOrder();
                    }
                })
                .show();
    }

    // ---------------- CONTEXT MENU ----------------
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        v.startAnimation(AnimationUtils.loadAnimation(this, R.anim.shake));
        getMenuInflater().inflate(R.menu.snack_context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if (selectedSnack == null) {
            selectedSnack = snacks[info.position];
        }

        if (selectedSnack.contains("Pizza")) {
            // Show the custom quantity dialog
            PizzaOrderDialogFragment dialog = new PizzaOrderDialogFragment();
            dialog.show(getSupportFragmentManager(), "PizzaDialog");
        } else {
            int itemId = item.getItemId();
            if (itemId == R.id.add_cheese) {
                Toast.makeText(this, "🧀 Extra cheese added to " + selectedSnack, Toast.LENGTH_SHORT).show();
                return true;
            } else if (itemId == R.id.make_spicy) {
                Toast.makeText(this, "🌶️ " + selectedSnack + " is now spicy!", Toast.LENGTH_SHORT).show();
                return true;
            } else if (itemId == R.id.remove_calories) {
                Toast.makeText(this, "❌ Calories removed from your *mind*, not the snack 😆", Toast.LENGTH_SHORT).show();
                return true;
            }
        }


        return super.onContextItemSelected(item);
    }

    // ---------------- POPUP MENU ----------------
    private void showPopupMenu(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.getMenuInflater().inflate(R.menu.snack_popup_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.offer_bogo) {
                Toast.makeText(this, "🍟 Give your Teacher Rs. 1000 to buy one!", Toast.LENGTH_SHORT).show();
                return true;
            } else if (itemId == R.id.offer_delivery) {
                Toast.makeText(this, "🛵 Free delivery applied!", Toast.LENGTH_SHORT).show();
                return true;
            } else if (itemId == R.id.offer_mystery) {
                String[] surprises = {"🥦 Broccoli Momo", "🍫 Chocolate Noodle", "🍕 Jhol Pizza"};
                String random = surprises[this.generateRandomNumber(surprises.length)];
                Toast.makeText(this, "🎲 You got a " + random + "!", Toast.LENGTH_LONG).show();
                return true;
            }
            return false;
        });
        popup.show();
    }

}