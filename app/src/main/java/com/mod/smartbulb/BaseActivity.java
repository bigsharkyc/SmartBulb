package com.mod.smartbulb;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Created by yangc on 2015/7/2.
 */
public class BaseActivity extends Activity{

    RelativeLayout rootLayout;
    RelativeLayout mContentView;
    ImageView iv_back;
    TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        LayoutInflater inflater = this.getLayoutInflater();
        rootLayout = (RelativeLayout)inflater.inflate(R.layout.base_activity, null);
        mContentView = (RelativeLayout)rootLayout.findViewById(R.id.StandardView_Abstract);
        View v = inflater.inflate(layoutResID, null);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        params.setMargins(0, 0, 0, 0);
        mContentView.addView(v,params);
        super.setContentView(rootLayout);
        initView();
    }

    private void  initView(){
        iv_back = (ImageView)rootLayout.findViewById(R.id.iv_back);
        tv_title = (TextView)rootLayout.findViewById(R.id.tv_title);
    }

    public void setTitle(String string){
        tv_title.setText(string);
    }

    public void setTitle(int id){
        tv_title.setText(id);
    }

    public void setOnBackClickLinster(View.OnClickListener listener){
        iv_back.setOnClickListener(listener);
    }
}
