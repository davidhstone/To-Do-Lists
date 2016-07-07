package com.example.davidstone.to_do_lists;

/**
 * Created by davidstone on 7/7/16.
 */
public class ListsCustomObject {

    String mTitle;

    public ListsCustomObject(){

        mTitle = "title";

    }

    public ListsCustomObject(String title) {

        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }


}

