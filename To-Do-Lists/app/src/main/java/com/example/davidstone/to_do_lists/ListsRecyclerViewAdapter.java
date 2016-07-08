package com.example.davidstone.to_do_lists;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by davidstone on 7/7/16.
 */
public class ListsRecyclerViewAdapter extends RecyclerView.Adapter<ListsCustomViewHolder> {

    List<ListsCustomObject> listsCustomObjectList;

    public ListsRecyclerViewAdapter(List<ListsCustomObject> listsCustomObjects){

        listsCustomObjectList = listsCustomObjects;
    }

    @Override
    public ListsCustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View parentView = inflater.inflate(R.layout.lists_custom_view, parent, false);
        ListsCustomViewHolder viewHolder = new ListsCustomViewHolder(parentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListsCustomViewHolder holder, int position) {
        final int myPosition = position;
        final ListsCustomObject listsCustomObject = listsCustomObjectList.get(position);
        holder.title.setText(listsCustomObject.getTitle());
        holder.itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), ToDoListActivity.class);
                        intent.putExtra("position", myPosition);
                        view.getContext().startActivity(intent);
                    }
                }
        );


    }

    @Override
    public int getItemCount() {
        return listsCustomObjectList.size();
    }
}
