package com.countryside_culture.service;

import com.countryside_culture.entity.video;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class history {
    private List<video> items=new ArrayList<video>();

    @JsonIgnore
    public void addItem(video videoItem){
        this.items.add(videoItem);
    }

    public void removeItem(int index){
        this.items.remove(index);
    }
    public List<video> getItems() {
        return items;
    }

    public void setItems(List<video> items) {
        this.items = items;
    }

}
