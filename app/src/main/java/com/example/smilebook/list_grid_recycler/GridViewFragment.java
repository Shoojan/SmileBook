package com.example.smilebook.list_grid_recycler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.smilebook.R;


public class GridViewFragment extends Fragment {

    // Define meme image resource IDs
    private final int[] memeImages = {
            R.drawable.meme_monday_again, // Replace with actual drawable resource names
            R.drawable.meme_bug_at_3,
            R.drawable.meme_code_finally_work,
            R.drawable.meme_debug,
            R.drawable.meme_delete
    };

    // Define meme descriptions
    private final String[] memeDescriptions = {
            "When you realize it's Monday again.",
            "Trying to fix a bug at 3 AM.",
            "When your code finally works!",
            "Debugging: The real-life horror story.",
            "When you accidentally delete your project."
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_gridview, container, false);

        // Find ListView by ID
        GridView gridView = fragmentView.findViewById(R.id.gridView);

        // Create ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, memeDescriptions);
//        MemeAdapter memeAdapter = new MemeAdapter(requireContext(),this.memeImages,this.memeDescriptions);

        // Set the adapter for GridView
        gridView.setAdapter(adapter);

        // Set an item click listener for ListView
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            // Display a Toast message with a fun fact
            String memeDescription = memeDescriptions[position].split(" ")[0];
            Toast.makeText(getActivity(), memeDescription, Toast.LENGTH_SHORT).show();
        });

        return fragmentView;
    }

}