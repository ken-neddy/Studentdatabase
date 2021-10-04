package com.neddycode.recyclerviewproject2;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


public class MainActivity extends AppCompatActivity {
    // creating variables for recycler view
    private RecyclerView mRecyclerView;
    private Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ExampleItem> exampleList;
    private SwipeRefreshLayout swipeRefresh;
    private TextView balance_tv;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing views.
        exampleList = new ArrayList<>();
        balance_tv = findViewById(R.id.balance_tv);
        swipeRefresh = findViewById(R.id.swiperefresh);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // adding our array list to recycler view adapter class.
        mAdapter = new ExampleAdapter(exampleList);

        // setting adapter to recycler view.
        mRecyclerView.setAdapter(mAdapter);

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
                    // if error is not null we are getting data from our object and passing it to our array list.
                    for (int i = 0; i < object.size(); i++) {
                        // extracting data and adding it to array list

                        //Extracting the data(credit and debit) of the trial object
                        String credit = object.get(i).getString("credit");
                       String debit = object.get(i).getString("debit");
                        String balanceString = String.valueOf(credit);
                       String balance2String = String.valueOf(debit);
                        String objectId = object.get(i).getObjectId();

                        //  adding data to array list.
                        exampleList.add(new ExampleItem(balanceString,balance2String, objectId));
                        Log.d("ParseTing", "New data added to the arrayList" + "balance: " + balanceString  + " objectId: " + objectId + " debit " +  balance2String);

                        // notifying adapter class on adding new data.
                        mAdapter.notifyDataSetChanged();
                    }

                } else {
                    // handling error if any error appears.
                    Toast.makeText(MainActivity.this, "Fail to get data..", Toast.LENGTH_SHORT).show();
                    Log.d("ParseTing", "Error getting data from Parse: ", e);
                }
            }
        });

        //querying the parse database to implement swipe to refresh
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> object, ParseException e) {
                if (e == null) {
                    for (int i = 0; i < object.size(); i++) {
                        String trial = object.get(i).getString("trial");
                        String objectId = object.get(i).getObjectId();
                        String accountBalance = String.valueOf(trial);
                        balance_tv.setText(accountBalance);
                        Log.d("Transaction", "Balance: " + accountBalance);
                    }
                }else{
                    Log.d("Transaction", e.getMessage());
                }
            }
        });

        //implementing swipe to refresh
        swipeRefresh.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        getDataFromServer();
                        swipeRefresh.setRefreshing(false);
                    }
                }
        );

    }

}