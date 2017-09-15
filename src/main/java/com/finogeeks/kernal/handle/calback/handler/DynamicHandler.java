package com.finogeeks.kernal.handle.calback.handler;

/**
 * Created by teril on 2017/7/6.
 */
public interface DynamicHandler {
    // default execute in order to implement callback func
    // allows a serial of args all as String keys each mapped to an Object as execute() params
    public void execute();
    // default function used to initial the back-call execute()
    public void initalExecute(String massage);
}
