package com.finogeeks.model;

/**
 * Created by teril on 2017/8/22.
 */
public class LoggerDebug {
    public static void debug(Object object){
        System.out.println("========"+object.toString()+"========");
    }
}
