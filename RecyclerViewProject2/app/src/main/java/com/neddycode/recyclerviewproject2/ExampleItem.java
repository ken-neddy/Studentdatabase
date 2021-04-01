package com.neddycode.recyclerviewproject2;

public class ExampleItem {
    private final String mBalance;
    private final String mTransactionId;

    public ExampleItem(String balance, String transactionId) {
        mBalance = balance;
        mTransactionId = transactionId;
    }

    public String getTransactionId() {
        return mTransactionId;
    }

    public String getBalance() {
        return mBalance;
    }

}