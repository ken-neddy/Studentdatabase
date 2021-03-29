package com.neddycode.recyclerviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_attach_money_24, "AMN73Y69C", "$64875"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_attach_money_24, "AG3CHRUHC", "$83633"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_attach_money_24,"AST62ZTBC" ,"$28852"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_attach_money_24, "AAMDJA9SC", "$88243"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_attach_money_24, "AAMD6E37C", "$58559"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_attach_money_24,"AKVQEFG2C" ,"$95483"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_attach_money_24, "A86G3YDGC", "$83793"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_attach_money_24, "ADPKDNMDC", "$56575"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_attach_money_24,"AEXPVGSHC" ,"$36994"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_attach_money_24, "ARNU7QS4C", "$88853"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_attach_money_24, "APFZ786MC", "$34565"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_attach_money_24,"AN78HBFQC" ,"$84564"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_attach_money_24, "AQVNUX7WC", "$78632"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_attach_money_24, "ABTJ3VP9C", "$28697"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_attach_money_24,"AS2VR29EC" ,"$95652"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_attach_money_24, "AEBAFJPEC", "$76443"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_attach_money_24, "APCPVCX8C", "$93692"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_attach_money_24,"AJBBTD48C" ,"$56576"));


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}