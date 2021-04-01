package com.neddycode.recyclerviewproject2;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;


public class MainActivity extends AppCompatActivity {
    // creating variables for recycler view
    private RecyclerView mRecyclerView;
    private Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ExampleItem> exampleList;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing our views.
        exampleList = new ArrayList<>();

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // adding our array list to our recycler view adapter class.
        mAdapter = new ExampleAdapter(exampleList);

        // setting adapter to our recycler view.
        mRecyclerView.setAdapter(mAdapter);

        // prepareRecyclerView();

        // calling a method to get the data from database.
        getDataFromServer();

    }

    private void getDataFromServer() {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("trial");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> object, ParseException e) {
                // in done method checking if the error is null or not.
                if (e == null) {
                    // Adding objects into the Array
                    // if error is not null we are getting data from
                    // our object and passing it to our array list.
                    for (int i = 0; i < object.size(); i++) {
                        // extracting data and adding it to array list
                        // ParseObject balance = object.get(Integer.parseInt("balance"));

                        //Extracting the balance of the current object in the list
                        //int bal = object.get(i).getInt("balance");
                        String credit = object.get(i).getString("credit");
                       String debit = object.get(i).getString("debit");
                        String balanceString = String.valueOf(credit);
                       String balance2String = String.valueOf(debit);

                        String objectId = object.get(i).getObjectId();

                        // on below line we are adding data to our array list.
                        exampleList.add(new ExampleItem(balanceString, objectId));
                        Log.d("ParseTing", "New data added to the arrayList" + "balance: " + balanceString  + " objectId: " + objectId + " debit " +  balance2String);

                        // notifying adapter class on adding new data.
                        mAdapter.notifyDataSetChanged();
                    }

                } else {
                    // handling error if we get any error.
                    Toast.makeText(MainActivity.this, "Fail to get data..", Toast.LENGTH_SHORT).show();
                    Log.d("ParseTing", "Error getting data from Parse: ", e);
                }
            }
        });
    }

}