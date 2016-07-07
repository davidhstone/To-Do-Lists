package com.example.davidstone.to_do_lists;

/**
 * Created by davidstone on 7/7/16.
 */
public class ListsToDoListsSingleton {
    private static ListsToDoListsSingleton ourInstance = new ListsToDoListsSingleton();

    public static ListsToDoListsSingleton getInstance() {
        return ourInstance;
    }

    private ListsToDoListsSingleton() {
    }
}
