package com.finogeeks.kernal.execute.core;

import com.finogeeks.kernal.handle.calback.handler.MessageHandler;
import com.finogeeks.kernal.model.Subscription;
import com.finogeeks.kernal.model.frame.GenaralSpec;

public interface CoreMethod {

    public GenaralSpec init(String name, String instance);

    public GenaralSpec publish(String topic, String message);

    public GenaralSpec subscribe(String topic, String criteria, MessageHandler handler);

    public GenaralSpec query(String topic,String criteria,MessageHandler handler);

    public GenaralSpec queryAndSubscribe(String topic, String criteria, MessageHandler handler);

    public GenaralSpec close();

    public GenaralSpec unSub(Subscription subSeq);

    public GenaralSpec unQuerySub(Subscription querySubSeq);

    public GenaralSpec isSystemService();

}