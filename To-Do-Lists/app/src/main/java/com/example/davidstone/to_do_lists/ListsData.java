package com.example.davidstone.to_do_lists;

/**
 * Created by davidstone on 7/7/16.
 */
public class ListsData {
    private static ListsData ourInstance = new ListsData();

    public static ListsData getInstance() {
        return ourInstance;
    }

    private ListsData() {
    }
}
