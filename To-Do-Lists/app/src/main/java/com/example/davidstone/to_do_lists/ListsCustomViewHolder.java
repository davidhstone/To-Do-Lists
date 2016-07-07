package com.example.davidstone.to_do_lists;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by davidstone on 7/7/16.
 */
public class ListsCustomViewHolder extends RecyclerView.ViewHolder {

    TextView title;

    public ListsCustomViewHolder(View itemView){
        super(itemView);

        title = (TextView) itemView.findViewById(R.id.list_title_textview);

    }
}
