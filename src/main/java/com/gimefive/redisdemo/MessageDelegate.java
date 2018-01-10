package com.gimefive.redisdemo;

import java.io.Serializable;
import java.util.Map;

/**
 * 消息订阅代表接口类
 *
 * @author
 * @create 2017-11-09 下午2:12
 **/
public interface MessageDelegate {
    void handleMessage(String message);
    void handleMessage(Map message); void handleMessage(byte[] message);
    void handleMessage(Serializable message);
    // pass the channel/pattern as well
    void handleMessage(Serializable message, String channel);
}
