package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class AdapterA extends BaseAdapter {

    private Context mContext;

    public AdapterA(Context mContext, List<MaskaPicture> maskList) {
        this.mContext = mContext;

    }
    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 1;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(mContext,R.layout.add_picture,null);

        return v;
    }
}
