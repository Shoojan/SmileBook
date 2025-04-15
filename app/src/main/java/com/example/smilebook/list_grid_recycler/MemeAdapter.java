package com.example.smilebook.list_grid_recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smilebook.R;

public class MemeAdapter extends BaseAdapter {
    private final Context context;
    private final int[] memeImages;
    private final String[] memeDescriptions;

    public MemeAdapter(Context context, int[] memeImages, String[] memeDescriptions) {
        this.context = context;
        this.memeImages = memeImages;
        this.memeDescriptions = memeDescriptions;
    }

    @Override
    public int getCount() {
        return memeImages.length;
    }

    @Override
    public Object getItem(int position) {
        return memeImages[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            // Inflate custom grid item layout
            view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        }

        // Find ImageView and TextView by ID
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.gridText);

        // Set image and description
        imageView.setImageResource(memeImages[position]);
        textView.setText(memeDescriptions[position]);

        return view;
    }
}
