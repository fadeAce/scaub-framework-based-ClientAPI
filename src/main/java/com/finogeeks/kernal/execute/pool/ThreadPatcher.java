package com.finogeeks.kernal.execute.pool;

import com.finogeeks.kernal.execute.executor.DylibExecutor;
import com.finogeeks.kernal.execute.executor.HandleBinder;
import com.finogeeks.kernal.model.Handle;
import com.finogeeks.kernal.model.frame.Key;
import com.finogeeks.kernal.model.frame.Method;
import com.finogeeks.kernal.pattern.dispatcher.Mediator;

import java.util.Map;

/**
 * Created by teril on 2017/9/18.
 */
public class ThreadPatcher implements HandleBinder {
    @Override
    public Handle bindHandle(Map param) {
        Method method = (Method) param.get(Key.METHOD);
        String topic = (String) param.get(Key.TOPIC);
        String criteria = (String) param.get(Key.CRITERIA);
        int client =  (Integer) param.get(Key.CLIENT);
        switch (method){
            case METHOD_QUERY:
                DylibExecutor dylibExecutor = (DylibExecutor) Mediator.getMultiVal(Key.MULTIEXECUTOR);
                int querySeq = dylibExecutor.CreateQuery(topic,criteria,client);
                Handle queryHandle = new Handle(querySeq);
                return queryHandle;
        }
        return new Handle();
    }
}
