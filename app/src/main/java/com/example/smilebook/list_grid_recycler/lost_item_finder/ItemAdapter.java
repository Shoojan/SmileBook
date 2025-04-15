package com.example.smilebook.list_grid_recycler.lost_item_finder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smilebook.R;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Item> items;

    public ItemAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Item getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getImageResource();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_view, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.gridImage);
        TextView textView = convertView.findViewById(R.id.gridText);

        Item item = this.getItem(position);

        imageView.setImageResource(item.getImageResource());
        textView.setText(item.getName());

        return convertView;
    }
}
