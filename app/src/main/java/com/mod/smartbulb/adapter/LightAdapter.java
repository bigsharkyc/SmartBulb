package com.mod.smartbulb.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.mod.entity.LightInfo;

/**
 * Created by yangc on 2015/7/6.
 */
public class LightAdapter extends ArrayAdapter<LightInfo> {

    public LightAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
