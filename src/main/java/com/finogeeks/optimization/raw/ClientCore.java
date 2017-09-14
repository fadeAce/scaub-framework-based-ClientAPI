package com.finogeeks.optimization.raw;

import com.finogeeks.kernal.execute.core.CoreMethod;
import com.finogeeks.kernal.handler.calback.MessageHandler;
import com.finogeeks.kernal.model.Subscription;
import com.finogeeks.kernal.model.frame.GenaralSpec;

/**
 * Created by teril on 2017/9/14.
 */
public class ClientCore implements CoreMethod {
/**
 * Extremely important core code for Client API form .
 */
    @Override
    public GenaralSpec publish(String topic, String message) {
        return null;
    }

    @Override
    public Subscription subscribe(String topic, String criteria, MessageHandler handler) {
        return null;
    }

    @Override
    public GenaralSpec query(String topic, String criteria, MessageHandler handler) {
        return null;
    }

    @Override
    public Subscription queryAndSubscribe(String topic, String criteria, MessageHandler handler) {
        return null;
    }

    @Override
    public GenaralSpec close() {
        return null;
    }

    @Override
    public GenaralSpec unSub(Subscription subSeq) {
        return null;
    }

    @Override
    public GenaralSpec unQuerySub(Subscription querySubSeq) {
        return null;
    }

    @Override
    public GenaralSpec isSystemService() {
        return null;
    }

}