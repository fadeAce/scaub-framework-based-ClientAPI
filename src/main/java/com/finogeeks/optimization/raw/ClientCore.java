package com.finogeeks.optimization.raw;

import com.finogeeks.kernal.execute.core.CoreMethod;
import com.finogeeks.kernal.handle.calback.handler.MessageHandler;
import com.finogeeks.kernal.model.InitRes;
import com.finogeeks.kernal.model.QueryRes;
import com.finogeeks.kernal.model.Subscription;
import com.finogeeks.kernal.model.frame.*;
import com.finogeeks.kernal.pattern.dispatcher.Mediator;
import com.finogeeks.optimization.export.Client;

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

    protected int client;

    @Override
    public InitRes init(String name, String instance) {
        EnumTensor enumTensor = new EnumTensor();
        enumTensor.setP(pattern);
        enumTensor.setM(Method.METHOD_INIT);
        Map<Key,Object> paramap = new HashMap<>();
        paramap.put(Key.NAME,name);
        paramap.put(Key.INSTANCE,instance);
        enumTensor.setParam(paramap);
        InitRes initRes = (InitRes) Mediator.match(enumTensor);
        this.client = initRes.getClient();
        return initRes;
    }

    @Override
    public GenaralSpec publish(String topic, Object msgHolder){
        EnumTensor enumTensor = new EnumTensor();
        enumTensor.setP(pattern);
        enumTensor.setM(Method.METHOD_PUB);
        Map<Key,Object> paramap = new HashMap<>();
        paramap.put(Key.TOPIC,topic);
        paramap.put(Key.CLIENT,client);
        paramap.put(Key.METHOD,Method.METHOD_PUB);
        paramap.put(Key.MESSAGEHOLDER,msgHolder);
        enumTensor.setParam(paramap);
        Mediator.match(enumTensor);
        return null;
    }

    @Override
    public Subscription subscribe(String topic, String criteria, MessageHandler handler) {
        EnumTensor enumTensor = new EnumTensor();
        enumTensor.setP(pattern);
        enumTensor.setM(Method.METHOD_SUB);
        Map<Key,Object> paramap = new HashMap<>();
        paramap.put(Key.TOPIC,topic);
        paramap.put(Key.CRITERIA,criteria);
        paramap.put(Key.MESSAGEHANDLER,handler);
        paramap.put(Key.CLIENT,client);
        paramap.put(Key.METHOD,Method.METHOD_SUB);
        enumTensor.setParam(paramap);
        Subscription subscription = (Subscription) Mediator.match(enumTensor);
        return subscription;
    }

    @Override
    public QueryRes query(String topic, String criteria, MessageHandler handler) {
        EnumTensor enumTensor = new EnumTensor();
        enumTensor.setM(Method.METHOD_QUERY);
        enumTensor.setP(pattern);
        Map<Key,Object> paramap = new HashMap<>();
        paramap.put(Key.TOPIC,topic);
        paramap.put(Key.CRITERIA,criteria);
        paramap.put(Key.MESSAGEHANDLER,handler);
        paramap.put(Key.CLIENT,client);
        paramap.put(Key.METHOD,Method.METHOD_QUERY);
        enumTensor.setParam(paramap);
        QueryRes queryRes = (QueryRes) Mediator.match(enumTensor);
        if(queryRes.getTag()){
            return queryRes;
        }else{
            // err expending & tracing TBD
        }
        return queryRes;
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