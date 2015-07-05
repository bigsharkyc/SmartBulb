package com.mod.smartbulb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.mod.lib.JniHelper;
import com.mod.ui.CircleImageView;
import com.mod.ui.EditDelText;


public class LoginActivity extends Activity implements View.OnClickListener, JniHelper.MsgHandler{

    CircleImageView circleImageView;
    Button mLoginBtn;
    EditDelText mUserName;
    EditDelText mUserPwd;
    CheckBox mKeepPwd;
    CheckBox mAutoLogin;
    TextView mNewAccount;
    TextView mForgetPwd;

    JniHelper helper;

    LoginHandler mLoginHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        if (PreferenceUtil.getFirstLogin(this)){
//            Intent intent = new Intent(this, WelcomeActivity.class);
//            startActivity(intent);
//        }

        init();
        
        helper = new JniHelper();
        mLoginHandler = new LoginHandler();
    }

    private void init(){
        circleImageView = (CircleImageView)findViewById(R.id.login_avatar);
        mLoginBtn = (Button)findViewById(R.id.btn_login);
        mUserName = (EditDelText)findViewById(R.id.login_user_name);
        mUserPwd = (EditDelText)findViewById(R.id.login_user_pwd);
        mKeepPwd = (CheckBox)findViewById(R.id.login_keep_pwd);
        mAutoLogin = (CheckBox)findViewById(R.id.login_auto);
        mNewAccount = (TextView)findViewById(R.id.tv_create_account);
        mForgetPwd = (TextView)findViewById(R.id.login_find_pwd);
        helper.Init();
        helper.SetMsgHandler(this);

        circleImageView.setOnClickListener(this);
        mLoginBtn.setOnClickListener(this);
        mNewAccount.setOnClickListener(this);
        mForgetPwd.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_avatar:
                break;
            case R.id.btn_login:

                break;
            case R.id.tv_create_account:
                Intent register = new Intent(this, RegisterActivity.class);
                startActivity(register);
                break;
            case R.id.login_find_pwd:
                Intent findPwd = new Intent(this, ForgetPasswordActivity.class);
                startActivity(findPwd);
                break;
        }
    }

    @Override
    public void OnServerDisconnect() {

    }

    @Override
    public void OnServerConnected() {

    }

    @Override
    public void OnMsgpack(byte[] data) {

    }

    private class LoginHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    }
}
