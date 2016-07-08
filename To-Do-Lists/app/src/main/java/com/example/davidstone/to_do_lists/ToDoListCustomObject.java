package com.example.davidstone.to_do_lists;

/**
 * Created by davidstone on 7/7/16.
 */
public class ToDoListCustomObject {

    String mItem;
    String mDescription;
    Boolean mChecked;

    public ToDoListCustomObject(){

        mItem = "item";
        mDescription = "description";
        mChecked = false;

    }



    public ToDoListCustomObject(String item, String description, boolean checked) {

        mItem = item;
        mDescription = description;
        mChecked = false;
    }

    public String getItem() {
        return mItem;
    }

    public void setItem(String item) {
        mItem = item;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Boolean getChecked() {
        return mChecked;
    }

    public void setChecked(boolean checked) {
        mChecked = checked;
    }


}
