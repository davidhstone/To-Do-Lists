package com.example.davidstone.to_do_lists;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by davidstone on 7/7/16.
 */
public class ListsToDoListsSingleton {

    private static ListsToDoListsSingleton toDoListsSingleton = null;

    private static List<String> titles;
    private static List<String> items;
    private static List<String> descriptions;
    List<ListsCustomObject> lists;

    private ListsToDoListsSingleton() {
        titles = new LinkedList<String>();
        items = new LinkedList<String>();
        descriptions = new LinkedList<String>();
        lists = new LinkedList<>();

        ListsCustomObject toDoList1 = new ListsCustomObject("List 1");
        ListsCustomObject toDoList2 = new ListsCustomObject("List 2");

        List todos1 = new LinkedList();
        todos1.add(new ToDoListCustomObject());
        todos1.add(new ToDoListCustomObject());
        todos1.add(new ToDoListCustomObject());
        todos1.add(new ToDoListCustomObject());
        List todos2 = new LinkedList();
        todos2.add(new ToDoListCustomObject());
        todos2.add(1, new ToDoListCustomObject());
        todos2.add(2, new ToDoListCustomObject());
        todos2.add(3, new ToDoListCustomObject());

        toDoList1.setToDoListCustomObjectList(todos1);
        toDoList2.setToDoListCustomObjectList(todos2);

        lists.add(toDoList1);
        lists.add(toDoList2);
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
