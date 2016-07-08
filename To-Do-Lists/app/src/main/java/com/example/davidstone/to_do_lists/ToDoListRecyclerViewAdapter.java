package com.example.davidstone.to_do_lists;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by davidstone on 7/7/16.
 */
public class ToDoListRecyclerViewAdapter extends RecyclerView.Adapter<ToDoListCustomViewHolder>{

    List<ToDoListCustomObject> toDoListCustomObjectList;

    public ToDoListRecyclerViewAdapter(List<ToDoListCustomObject> toDoListCustomObjects){
        if (toDoListCustomObjects == null)
            toDoListCustomObjectList = new LinkedList<>();
        else
            toDoListCustomObjectList = toDoListCustomObjects;
    }

    @Override
    public ToDoListCustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View parentView = inflater.inflate(R.layout.todolists_custom_layout, parent, false);
        ToDoListCustomViewHolder viewHolder = new ToDoListCustomViewHolder(parentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ToDoListCustomViewHolder holder, int position) {

        final int myPosition = position;
        final ToDoListCustomObject toDoListCustomObject = toDoListCustomObjectList.get(position);
        holder.item.setText(toDoListCustomObject.getItem());
        holder.description.setText(toDoListCustomObject.getDescription());

        holder.checked.setChecked(toDoListCustomObject.getChecked());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return toDoListCustomObjectList.size();
    }


}
