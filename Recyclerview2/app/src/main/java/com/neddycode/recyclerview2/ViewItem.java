package com.neddycode.recyclerview2;

public class ViewItem {
    private final int mImageResource;
    private String mTextView1;
    private String mTextView2;


    public ViewItem(int ImageResource,String TextView1, String TextView2 ){
        mImageResource = ImageResource;
        mTextView1 = TextView1;
        mTextView2 = TextView2;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public String getmTextView1() {
        return mTextView1;
    }
    public String getmTextView2() {
        return mTextView2;
    }

}
