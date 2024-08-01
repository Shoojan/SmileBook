package com.example.smilebook.list_grid_recycler;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.smilebook.R;
import com.example.smilebook.fragments.BlueFragment;
import com.example.smilebook.fragments.PinkFragment;

public class ViewAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_adapter);
    }


    public void selectViews(View view) {
        Fragment fragment;

        if (view == findViewById(R.id.listViewButton)) {
            fragment = new ListViewFragment();
        } else if (view == findViewById(R.id.gridViewButton)) {
            fragment = new ListViewFragment();
        } else {
            fragment = new ListViewFragment();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.viewFragment, fragment);

        fragmentTransaction.commit();

    }
}