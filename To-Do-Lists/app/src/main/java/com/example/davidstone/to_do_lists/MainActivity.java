package com.example.davidstone.to_do_lists;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ListsToDoListsSingleton listsToDoListsSingleton;
    ListsRecyclerViewAdapter listsRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Title");

        listsToDoListsSingleton = ListsToDoListsSingleton.getInstance();
        listsRecyclerViewAdapter = new ListsRecyclerViewAdapter(listsToDoListsSingleton.lists);
        mRecyclerView = (RecyclerView) findViewById(R.id.listsrecyclerview);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(listsRecyclerViewAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {



                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

                final EditText listTitle = new EditText(view.getContext());
                listTitle.setHint("Add New To-Do List Title");
                builder.setView(listTitle);

                builder.setPositiveButton("Add", null);
                //setView

                builder.setNegativeButton("Cancel", null);

                final AlertDialog nameDialog = builder.create();
                nameDialog.show();

                nameDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (listTitle.getText().toString().isEmpty()) {
                            listTitle.setError("Invalid Title, Please add a valid Title");
                        }
                        else {
                            //create a new list object and add it to my collection of that list object
                            ListsCustomObject newtitle = new ListsCustomObject(listTitle.getText().toString());
//                            Toast.makeText(view.getContext(), String.valueOf(newtitle.getToDoListCustomObjectList() == null), Toast.LENGTH_SHORT);
//                            listsRecyclerViewAdapter.listsCustomObjectList.add(newtitle);
                            listsToDoListsSingleton.lists.add(newtitle);
                            nameDialog.cancel();
                            listsRecyclerViewAdapter.notifyDataSetChanged();
//                            Intent intent = new Intent(view.getContext(), ToDoListActivity.class);
//                            startActivity(intent);
                        }

                    }
                });

            }
        });

        listsToDoListsSingleton = ListsToDoListsSingleton.getInstance();

        listsToDoListsSingleton.addTitle("My gross shopping list");
        listsToDoListsSingleton.addItem("Cheese");
        listsToDoListsSingleton.addDescription("spoiled cheese");

        listsToDoListsSingleton.getTitles(0);
        listsToDoListsSingleton.getItems(0);
        listsToDoListsSingleton.getDescriptions(0);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    ListsToDoListsSingleton toDoListsSingleton = ListsToDoListsSingleton.getInstance();

    public void setToDoListsSingleton(ListsToDoListsSingleton toDoListsSingleton) {
        this.toDoListsSingleton = toDoListsSingleton;
        toDoListsSingleton.addTitle("");
        toDoListsSingleton.addItem("");
        toDoListsSingleton.addDescription("");

     /*
        addAnotherTitle();
        addAnotherItem();
        addAnotherDescription();
    }

    public static void addAnotherTitle(){
        this.toDoListsSingleton =
        ListsToDoListsSingleton.addTitle("");
    */
    }

}


/*            public void onClick(View view) {


         on a long click remove by using this and just switching add to remove
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    //user clicked add button
                        //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        //      .setAction("Action", null).show();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    //user clicked cancel button
                        //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        //      .setAction("Action", null).show();
                    }
                });

                AlertDialog nameDialog = builder.create();
            }
        }); */


