package com.finogeeks.kernal.pattern.list;

import com.finogeeks.kernal.execute.executor.DylibExecutor;
import com.finogeeks.kernal.execute.executor.HandleBinder;
import com.finogeeks.kernal.execute.pool.DylibLoaderFixed;
import com.finogeeks.kernal.execute.pool.LoopFixed;
import com.finogeeks.kernal.execute.pool.ThreadPatcher;
import com.finogeeks.kernal.handle.calback.handler.MessageHandler;
import com.finogeeks.kernal.model.Handle;
import com.finogeeks.kernal.model.Terminator;
import com.finogeeks.kernal.model.frame.BaseTag;
import com.finogeeks.kernal.model.frame.Key;
import com.finogeeks.kernal.model.frame.Method;
import com.finogeeks.kernal.model.frame.Phase;
import com.finogeeks.kernal.pattern.def.PatternRouter;
import com.finogeeks.kernal.pattern.dispatcher.Mediator;
import java.util.Map;

/**
 * Created by teril on 2017/9/14.
 */
public class PatternMulti implements PatternRouter,BaseTag {

    /**
     *  what's in a pattern dose change data in media para map.
     */

    @Override
    public Phase getPhase() {
        return Phase.PHASE_PATTERN;
    }

    @Override
    public void pin(Map<Key,Object> paramap) {
        //pin accessories
    }

    //construct a common pattern cache of it's option features


    public Handle query(Map<Key, Object> paramap) {
        //E-H model
        HandleBinder handleBinder = new ThreadPatcher();
        Handle querHandle = (Handle) handleBinder.bindHandle(paramap);
        LoopFixed loopFixed = new LoopFixed();
        loopFixed.setHandle(querHandle.getHandle());
        loopFixed.setClientseq((Integer) paramap.get(Key.CLIENT));
        loopFixed.setTopic((String) paramap.get(Key.TOPIC));
        loopFixed.setMethod(Method.METHOD_QUERY);
        loopFixed.setMl((MessageHandler) paramap.get(Key.MESSAGEHANDLER));
        Thread querythread=new Thread(loopFixed);
        querythread.start();
        return querHandle;
    }

    public int init(Map<Key, Object> paramap) {
        //map dependency
        String name = (String) paramap.get(Key.NAME);
        String instance = (String) paramap.get(Key.INSTANCE);
        //E-H model
        DylibLoaderFixed dylibLoaderFixed = new DylibLoaderFixed();
        DylibExecutor dylibExecutor= dylibLoaderFixed.getExecutor();
        //MultiCache option
        Mediator.addMultiVal(Key.MULTIEXECUTOR,dylibExecutor);
        int clientQue= ((DylibExecutor)Mediator.getMultiVal(Key.MULTIEXECUTOR)).Init(name,instance);

        return clientQue;
    }

    public Handle subscribe(Map<Key, Object> paramap) {
        //E-H model
        HandleBinder handleBinder = new ThreadPatcher();
        Handle subHandle = (Handle) handleBinder.bindHandle(paramap);

        LoopFixed loopFixed = new LoopFixed();
        loopFixed.setHandle(subHandle.getHandle());
        loopFixed.setMethod(Method.METHOD_SUB);
        loopFixed.setMl((MessageHandler) paramap.get(Key.MESSAGEHANDLER));
        loopFixed.setTerminator(new Terminator());
        loopFixed.setTopic((String)paramap.get(Key.TOPIC));
        loopFixed.setClientseq((Integer)paramap.get(Key.CLIENT));
        Thread subthread=new Thread(loopFixed);
        subthread.start();

        return subHandle;
    }

    public void publish(Map<Key, Object> paramap) {
        //map dependency
        String topic = (String) paramap.get(Key.TOPIC);
        String message = paramap.get(Key.MESSAGEHOLDER).toString();
        //E-H model
        //MultiCache option
        ((DylibExecutor)Mediator.getMultiVal(Key.MULTIEXECUTOR)).Publish(topic,message,(Integer) paramap.get(Key.CLIENT));

    }

    public Handle querySub(Map<Key, Object> paramap) {
        //E-H model
        HandleBinder handleBinder = new ThreadPatcher();
        Handle subHandle = (Handle) handleBinder.bindHandle(paramap);
        LoopFixed loopFixed = new LoopFixed();
        loopFixed.setHandle(subHandle.getHandle());
        loopFixed.setMethod(Method.METHOD_QUERYSUB);
        loopFixed.setMl((MessageHandler) paramap.get(Key.MESSAGEHANDLER));
        loopFixed.setTerminator(new Terminator());
        loopFixed.setTopic((String)paramap.get(Key.TOPIC));
        loopFixed.setClientseq((Integer)paramap.get(Key.CLIENT));
        Thread querysubthread=new Thread(loopFixed);
        querysubthread.start();
        return subHandle;
    }

    public Boolean Close(Map<Key, Object> paramap){
        try{
            ((DylibExecutor)Mediator.getMultiVal(Key.MULTIEXECUTOR)).Close((Integer) paramap.get(Key.CLIENT));
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}