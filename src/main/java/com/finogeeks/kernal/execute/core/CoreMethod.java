package com.finogeeks.kernal.execute.core;

import com.finogeeks.kernal.handle.calback.handler.MessageHandler;
import com.finogeeks.kernal.model.Subscription;
import com.finogeeks.kernal.model.frame.GenaralSpec;

public interface CoreMethod {

    GenaralSpec init(String name, String instance);

    GenaralSpec publish(String topic, String message);

    GenaralSpec subscribe(String topic, String criteria, MessageHandler handler);

    GenaralSpec query(String topic,String criteria,MessageHandler handler);

    GenaralSpec queryAndSubscribe(String topic, String criteria, MessageHandler handler);

    GenaralSpec close();

    GenaralSpec unSub(Subscription subSeq);

    GenaralSpec unQuerySub(Subscription querySubSeq);

    GenaralSpec isSystemService();

}