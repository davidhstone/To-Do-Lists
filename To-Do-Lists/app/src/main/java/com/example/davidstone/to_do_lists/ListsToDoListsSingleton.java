package com.example.davidstone.to_do_lists;

import java.util.LinkedList;

/**
 * Created by davidstone on 7/7/16.
 */
public class ListsToDoListsSingleton {

    private static ListsToDoListsSingleton toDoListsSingleton = null;

    private static LinkedList<String> titles;
    private static LinkedList<String> items;
    private static LinkedList<String> descriptions;

    private ListsToDoListsSingleton() {
        titles = new LinkedList<String>();
        items = new LinkedList<String>();
        descriptions = new LinkedList<String>();
    }

    public static ListsToDoListsSingleton getInstance() {

        if (toDoListsSingleton == null) {
            toDoListsSingleton = new ListsToDoListsSingleton();
            // return ourInstance;
        }
        return toDoListsSingleton;
    }

    public void addName(String title){
        titles.add(title);
    }

    public void addItem(String item){
        items.add(item);
    }

    public void addDescription(String description){
        descriptions.add(description);
    }

    public LinkedList<String>getTitles(){
        return titles;
    }

    public LinkedList<String>getItems(){
        return items;
    }

    public LinkedList<String>getDescriptions(){
        return descriptions;
    }
}
