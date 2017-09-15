package com.finogeeks.optimization.raw;

import com.finogeeks.kernal.execute.core.CoreMethod;
import com.finogeeks.kernal.handle.calback.handler.MessageHandler;
import com.finogeeks.kernal.model.InitRes;
import com.finogeeks.kernal.model.Subscription;
import com.finogeeks.kernal.model.frame.*;
import com.finogeeks.kernal.pattern.dispatcher.Mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by teril on 2017/9/14.
 */
public class ClientCore implements CoreMethod {
/**
 * Extremely important core code for Client API form .
 */
    protected Pattern pattern ;

    @Override
    public InitRes init(String name, String instance) {
        EnumTensor enumTensor = new EnumTensor();
        enumTensor.setP(Pattern.PATTERN_MULTI);
        enumTensor.setM(Method.METHOD_INIT);
        Map<Key,Object> paramap = new HashMap<>();
        paramap.put(Key.NAME,name);
        paramap.put(Key.INSTANCE,instance);
        enumTensor.setParam(paramap);
        InitRes initRes = (InitRes) Mediator.match(enumTensor);
        return initRes;
    }

    @Override
    public GenaralSpec publish(String topic, String message){
        return null;
    }

    @Override
    public Subscription subscribe(String topic, String criteria, MessageHandler handler) {
        return null;
    }

    @Override
    public GenaralSpec query(String topic, String criteria, MessageHandler handler) {
        EnumTensor enumTensor = new EnumTensor();
        enumTensor.setM(Method.METHOD_QUERY);
        enumTensor.setP(pattern);
        Map<Key,Object> paramap = new HashMap<>();
        paramap.put(Key.TOPIC,topic);
        paramap.put(Key.CRITERIA,criteria);
        paramap.put(Key.MESSAGEHANDLER,handler);
        enumTensor.setParam(paramap);
        Mediator.match(enumTensor);
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