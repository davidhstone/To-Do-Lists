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

    public void addTitle(String title){
        titles.add(title);
    }

    public void addItem(String item){
        items.add(item);
    }

    public void addDescription(String description){
        descriptions.add(description);
    }

    /*
    SO I CAN DO THE GETS LIKE THIS TOO WHICH WILL RETURN THE WHOLE LIST
    RATHER THAN THE VALUE OF THE POSITION

    public LinkedList<String>getTitlesList(){
        return titles;
    }    */

    public String getTitles(int position){
        return titles.get(position);
    }

    public String getItems(int position){
        return items.get(position);
    }

    public String getDescriptions(int position){
        return descriptions.get(position);
    }
}
