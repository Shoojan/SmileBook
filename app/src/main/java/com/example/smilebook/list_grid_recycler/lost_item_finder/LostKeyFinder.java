package com.example.smilebook.list_grid_recycler.lost_item_finder;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smilebook.R;

import java.util.ArrayList;
import java.util.List;

public class LostKeyFinder extends AppCompatActivity {

    ListView listView;
    GridView gridView;
    RecyclerView recyclerView;

    ArrayList<Item> items = new ArrayList<>(
            List.of(
                    new Item("Keys", R.drawable.keys),
                    new Item("Wallets", R.drawable.wallet),
                    new Item("Books", R.drawable.book),
                    new Item("Phones", R.drawable.phone),
                    new Item("Glass", R.drawable.glass),
                    new Item("Remote", R.drawable.remote)
            )
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lost_key_finder);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        listView = findViewById(R.id.listView);
        gridView = findViewById(R.id.gridView);
        recyclerView = findViewById(R.id.recyclerView);

        ArrayList<String> itemNames = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            itemNames.add(items.get(i).getName());
        }

        // ListView Setup
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                itemNames);
        ItemAdapter itemAdapter = new ItemAdapter(this, items);

        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String category = itemNames.get(i);
//                Intent intent = new Intent(LostKeyFinder.this, LostItemsActivity.class);
//                intent.putExtra("category", category);
//                startActivity(intent);
                Toast.makeText(LostKeyFinder.this, "Lost Item:" + category, Toast.LENGTH_SHORT).show();
            }
        });

        // GridView Setup
        gridView.setAdapter(itemAdapter);

        // RecyclerView Setup
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LostItemAdapter adapter = new LostItemAdapter(items);
        recyclerView.setAdapter(adapter);

        // Animations
//        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
//        Animation slideIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

//        recyclerView.setAnimation(slideIn);
//        recyclerView.startAnimation(slideIn);
    }
}