package com.mod.lib;

/**
 * Created by liuzhiping on 2015/7/4.
 */
public class Jni {

    static{
        System.loadLibrary("light");
    }

    interface JniMsgHandler{
        // handleMsg 的消息id定义
        // 和服务器断开连接，需要每隔3秒再次重连
        public final static int MSGID_SIGNAL_FAILED = 0;
        // 连接服务器成功
        public final static int MSGID_SIGNAL_SUCCESS = 1;
        // 收到服务器msgpack打包消息
        public final static int MSGID_MSGPACK_MESSAGE = 2;

        public void handleMsg(int msgid, byte[] msg);
    }

    /**
     * 初始化jni
     * @param context context 必须实现HandleMsg 回调方法
     * @param role  角色 0：客户端， 1: 灯
     * @param workDir 工作目录，jni日志会记录到这个目录
     * @return
     */
    public static native int NativeInit(JniMsgHandler context, int role, String workDir);

    /**
     * 连接服务器
     * @param addr 域名/IP
     * @param port 端口
     * @return
     */
    public static native int ConnectToServer(String addr, int port);

    /**
     * 断开和服务器连接
     * @return
     */
    public static native int DisconnectFromServer();

    /**
     * 发送msgpack打包的数据
     * @param data 数据内容
     * @return
     */
    public static native int SendBytes(byte[] data);

    /**
     * 记录日志
     * @param msg
     */
    public static native void LogMsg(String msg);

}
