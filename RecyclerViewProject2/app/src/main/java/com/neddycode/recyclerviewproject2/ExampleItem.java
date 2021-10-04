package com.neddycode.recyclerviewproject2;

public class ExampleItem {
    //declaring our variables
    private final String mBalance;
    private final String mTransactionId;
    private final String mbalance2String;

    public ExampleItem(String balance2String, String balance, String transactionId) {
        //initializing our variables
        mBalance = balance;
        mTransactionId = transactionId;
        mbalance2String = balance2String;
    }

    public String getTransactionId() {
        return mTransactionId;
    }

    public String getBalance() {
        return mBalance;
    }

    public String getBalance1() {
        return mbalance2String;
    }
}