package com.finogeeks.kernal.model;

import com.finogeeks.kernal.model.frame.GenaralSpec;

/**
 * Created by teril on 2017/9/15.
 */
public class InitRes implements GenaralSpec {
    private int client;
    public  InitRes(int client){
        this.client=client;
    }
    public int getClient() {
        return client;
    }
    public void setClient(int client) {
        client = client;
    }
}
