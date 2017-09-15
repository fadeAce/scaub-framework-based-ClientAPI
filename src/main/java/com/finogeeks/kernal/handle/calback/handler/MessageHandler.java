package com.finogeeks.kernal.handle.calback.handler;

/**
 * Created by teril on 2017/7/6.
 */
public interface MessageHandler {
    // allows a serial of args all as String keys each mapped to an Object as execute() params
    public void execute(String format,String data);
}
