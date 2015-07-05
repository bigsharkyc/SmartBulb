package com.mod.smartbulb;

import android.os.Bundle;

/**
 * Created by yangc on 2015/7/3.
 */
public class ResetPwdActiity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pwd);
        setTitle(R.string.reset_pwd_title);
    }
}
