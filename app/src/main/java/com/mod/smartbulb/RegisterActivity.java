package com.mod.smartbulb;

import android.os.Bundle;
import android.view.View;

/**
 * Created by yangc on 2015/6/30.
 */
public class RegisterActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle(getResources().getString(R.string.text_register));
        setOnBackClickLinster(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
