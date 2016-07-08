package com.example.davidstone.to_do_lists;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by davidstone on 7/7/16.
 */
public class ListsCustomObject {

    String mTitle;
    List<ToDoListCustomObject> toDoListCustomObjectList;

    public ListsCustomObject(){

        mTitle = "title";
        toDoListCustomObjectList = new LinkedList<>();
    }

    public List<ToDoListCustomObject> getToDoListCustomObjectList() {
        return toDoListCustomObjectList;
    }

    public void setToDoListCustomObjectList(List<ToDoListCustomObject> toDoListCustomObjectList) {
        if (toDoListCustomObjectList == null) {
            this.toDoListCustomObjectList = new LinkedList<>();
        } else {
            this.toDoListCustomObjectList = toDoListCustomObjectList;
        }
    }

    public ListsCustomObject(String title) {

        mTitle = title;
        toDoListCustomObjectList = new LinkedList<>();
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }


}

