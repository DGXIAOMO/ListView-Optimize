package com.example.miku.listview_youhua_test;

/**
 * Created by miku on 2017/4/8.
 */
public class Moule {
    private int resourceID;
    private String data;

    public Moule(int resourceID, String data) {
        this.resourceID = resourceID;
        this.data = data;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getResourceID() {
        return resourceID;
    }

    public String getData() {
        return data;
    }
}
