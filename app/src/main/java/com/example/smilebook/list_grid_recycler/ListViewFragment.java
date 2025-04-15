package com.example.smilebook.list_grid_recycler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.smilebook.R;


public class ListViewFragment extends Fragment {

    // Define Android versions and fun facts
    private final String[] androidVersions = {
            "Cupcake (Android 1.5) 🐻 - Loves to share pictures with friends!",
            "Donut (Android 1.6) 🍩 - Can sniff out turn-by-turn navigation!",
            "KitKat (Android 4.4) 🐱 - Purrs while multitasking efficiently.",
            "Oreo (Android 8.0) 🍪 - Wise enough to snooze notifications.",
            "Pie (Android 9) 🥧 - So sweet, it got an extra slice of performance!",
            "Q (Android 10) 🤖 - Mysterious and full of gestures!",
            "Red Velvet Cake (Android 11) 🎂 - Keeps your chats floating!"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_listview, container, false);

        // Find ListView by ID
        ListView listView = fragmentView.findViewById(R.id.listView);

        // Create ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_list_item_1,
                androidVersions);

        // Set the adapter for ListView
        listView.setAdapter(adapter);

        // Set an item click listener for ListView
        listView.setOnItemClickListener((parent, view, position, id) -> {
            // Display a Toast message with a fun fact
            String versionName = androidVersions[position].split(" ")[0];
            String message = "Fun fact about " + versionName + ": " + getFunFact(position);
            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        });

        return fragmentView;
    }

    // Method to provide fun facts for each Android version
    private String getFunFact(int position) {
        switch (position) {
            case 0:
                return "Introduced the on-screen keyboard.";
            case 1:
                return "First to support different screen sizes.";
            case 2:
                return "Improved memory management.";
            case 3:
                return "Introduced picture-in-picture mode.";
            case 4:
                return "Enhanced AI capabilities.";
            case 5:
                return "Gesture navigation added.";
            case 6:
                return "Increased focus on privacy.";
            default:
                return "A significant update!";
        }
    }
}