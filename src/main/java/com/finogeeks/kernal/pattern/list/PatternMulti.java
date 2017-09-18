package com.finogeeks.kernal.pattern.list;

import com.finogeeks.kernal.execute.executor.DylibExecutor;
import com.finogeeks.kernal.execute.executor.HandleBinder;
import com.finogeeks.kernal.execute.pool.DylibLoaderFixed;
import com.finogeeks.kernal.execute.pool.ThreadPatcher;
import com.finogeeks.kernal.model.Handle;
import com.finogeeks.kernal.model.QueryRes;
import com.finogeeks.kernal.model.frame.BaseTag;
import com.finogeeks.kernal.model.frame.Key;
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
}