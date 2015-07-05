package com.mod.smartbulb;

import android.os.Bundle;

/**
 * Created by yangc on 2015/7/2.
 */
public class ForgetPasswordActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pwd);
        setTitle(R.string.forget_pwd_title);
    }
}
