package com.gimefive.redisdemo;

import java.io.Serializable;
import java.util.Map;

/**
 * 消息订阅代表接口实现类
 *
 * @author
 * @create 2017-11-09 下午2:12
 **/
public class MyMessageDelegate implements  MessageDelegate {
    @Override
    public void handleMessage(String message) {
        System.out.println("String message:" + message);
    }

    @Override
    public void handleMessage(Map message) {
        System.out.println("Map message:" + message);
    }

    @Override
    public void handleMessage(byte[] message) {
        System.out.println("byte[] message:" + message);
    }

    @Override
    public void handleMessage(Serializable message) {
        System.out.println("Serializable message:" + message);
    }

    @Override
    public void handleMessage(Serializable message, String channel) {
        System.out.println("Serializable message:" + message + "--channel:" + channel);
    }
}
