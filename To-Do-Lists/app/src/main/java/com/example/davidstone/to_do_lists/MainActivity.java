package com.example.davidstone.to_do_lists;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ListsToDoListsSingleton listsToDoListsSingleton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Title");

        mRecyclerView = (RecyclerView) findViewById(R.id.listsrecyclerview);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(linearLayoutManager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
