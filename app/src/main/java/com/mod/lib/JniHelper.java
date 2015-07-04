package com.mod.lib;

import android.util.Log;

/**
 * Created by liuzhiping on 2015/7/4.
 */
public class JniHelper implements Jni.JniMsgHandler {
    final static String TAG = "JniHelper";

    public interface MsgHandler{
        public void OnServerDisconnect();
        public void OnServerConnected();
        public void OnMsgpack(byte[] data);
    }

    private MsgHandler mHandler;

    // 初始化
    public void Init(){
       Jni.NativeInit(this, 0, "/sdcard/light/");
    }

    public void SetMsgHandler(MsgHandler handler){
        mHandler = handler;
    }

    public void ConnectToServer(String server, int port){
        Jni.ConnectToServer(server, port);
    }

    public void DisconnectFromServer(){
        Jni.DisconnectFromServer();
    }

    public void SendBytes(byte[] data){
        Jni.SendBytes(data);
    }

    @Override
    public void handleMsg(int msgid, byte[] msg) {
        switch(msgid) {
            case Jni.JniMsgHandler.MSGID_SIGNAL_FAILED:
                Log.d(TAG, "server connection failed");
                mHandler.OnServerDisconnect();
                break;
            case Jni.JniMsgHandler.MSGID_SIGNAL_SUCCESS:
                Log.d(TAG, "server connect success");
                mHandler.OnServerConnected();
                break;
            case Jni.JniMsgHandler.MSGID_MSGPACK_MESSAGE:
                Log.d(TAG, "recved msgpack data");
                mHandler.OnMsgpack(msg);
                break;
            default:
                Log.w(TAG, "msgid:" + msgid + " not handled");
                break;
        }
    }
}
