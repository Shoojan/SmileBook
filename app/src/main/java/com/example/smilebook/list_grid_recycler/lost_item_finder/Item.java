package com.example.smilebook.list_grid_recycler.lost_item_finder;

public class Item {
    private String name;
    private int imageResource;

    public Item(String name, int imageResource) {
        this.name = name;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }
}
