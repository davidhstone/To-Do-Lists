package com.example.davidstone.to_do_lists;

import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by davidstone on 7/7/16.
 */
public class ToDoListCustomViewHolder extends RecyclerView.ViewHolder {

    TextView item;
    TextView description;
    CheckBox checked;

    public ToDoListCustomViewHolder(View itemView) {
        super(itemView);

        item = (TextView) itemView.findViewById(R.id.item_textview);
        description = (TextView) itemView.findViewById(R.id.description_textview);
        checked = (CheckBox) itemView.findViewById(R.id.checkBox);
    }


}
