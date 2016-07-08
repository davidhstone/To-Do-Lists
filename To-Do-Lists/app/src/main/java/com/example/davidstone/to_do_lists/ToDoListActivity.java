package com.example.davidstone.to_do_lists;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class ToDoListActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ListsToDoListsSingleton listsToDoListsSingleton;
    ToDoListRecyclerViewAdapter toDoListRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Second Title");

        final int position = getIntent().getIntExtra("position", 0);
        listsToDoListsSingleton = ListsToDoListsSingleton.getInstance();

        toDoListRecyclerViewAdapter = new ToDoListRecyclerViewAdapter(listsToDoListsSingleton.lists.get(position).getToDoListCustomObjectList());
        mRecyclerView = (RecyclerView) findViewById(R.id.todolistrecyclerview);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(toDoListRecyclerViewAdapter);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                 //       .setAction("Action", null).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

                final LinearLayout linearLayout = new LinearLayout(view.getContext());

                final EditText itemTitle = new EditText(view.getContext());
                itemTitle.setHint("Add New Item");
                linearLayout.addView(itemTitle);

                final EditText descriptionTitle = new EditText(view.getContext());
                descriptionTitle.setHint("Add New Description");
                linearLayout.addView(descriptionTitle);

                builder.setView(linearLayout);

                builder.setPositiveButton("Add", null);
                //setView

                builder.setNegativeButton("Cancel", null);

                final AlertDialog itemDialog = builder.create();
                itemDialog.show();

                itemDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (itemTitle.getText().toString().isEmpty()){
                            itemTitle.setError("Invalid Item, Please add a valid Item");
                        }

                        else if  (descriptionTitle.getText().toString().isEmpty()){
                            descriptionTitle.setError("Invalid Item, Please add a valid Description");
                        }
                        else {
                            //create a new list object and add it to my collection of that list object
                            ToDoListCustomObject newitem = new ToDoListCustomObject(itemTitle.getText().toString(), descriptionTitle.getText().toString(), false);

//                            listsRecyclerViewAdapter.listsCustomObjectList.add(newtitle);
                            listsToDoListsSingleton.lists.get(position).getToDoListCustomObjectList().add(newitem);
                            itemDialog.cancel();
                            toDoListRecyclerViewAdapter.notifyDataSetChanged();
//                            Intent intent = new Intent(view.getContext(), ToDoListActivity.class);
//                            startActivity(intent);
                        }

                    }
                });
            }
        });

      /*  ListsToDoListsSingleton toDoListsSingleton = ListsToDoListsSingleton.getInstance();

    public void setToDoListsSingleton(ListsToDoListsSingleton toDoListsSingleton) {
        this.toDoListsSingleton = toDoListsSingleton;
        */
    }

}
