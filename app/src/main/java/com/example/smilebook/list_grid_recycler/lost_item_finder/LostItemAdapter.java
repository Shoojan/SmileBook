package com.example.smilebook.list_grid_recycler.lost_item_finder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smilebook.R;

import java.util.ArrayList;

class ViewHolder extends RecyclerView.ViewHolder {
    TextView itemName;
    Button foundButton;

    public ViewHolder(View itemView) {
        super(itemView);
        itemName = itemView.findViewById(R.id.itemName);
        foundButton = itemView.findViewById(R.id.foundButton);
    }
}

public class LostItemAdapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<Item> lostItems;

    public LostItemAdapter(ArrayList<Item> lostItems) {
        this.lostItems = lostItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lost_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = lostItems.get(position);
        holder.itemName.setText(item.getName());
        holder.foundButton.setOnClickListener(v -> {
            lostItems.remove(position);
            notifyItemRemoved(position);
        });
    }

    @Override
    public int getItemCount() {
        return lostItems.size();
    }

}
