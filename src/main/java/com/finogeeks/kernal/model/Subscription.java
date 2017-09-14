package com.finogeeks.kernal.model;

import com.finogeeks.kernal.model.frame.BaseTag;
import com.finogeeks.kernal.model.frame.GenaralSpec;
import com.finogeeks.kernal.model.frame.Phase;
import com.finogeeks.optimization.Client;

/**
 * Created by teril on 2017/8/21.
 * sub subquery
 */
public class Subscription implements GenaralSpec,BaseTag{
    //int:1 querysub 0:sub
    private int type;
    private int subSeq;
    private int querysubseq;
    private Thread td;
    private Client.Subscribe subscribe;
    private Client.QueryAndSubscribe querysubscribe;

    public void setController(int type,Object object){
        if(type==Client.TYPE_SUBSCRIBE){
            this.subscribe=(Client.Subscribe)object;
        }
        if(type==Client.TYPE_QUERYSUBSCRIBE){
            this.querysubscribe=(Client.QueryAndSubscribe)object;
        }
    }

    public int getSubQueByType(int type){
        if(type==Client.TYPE_SUBSCRIBE){
            return this.subSeq;
        }else{
            return this.querysubseq;
        }
    }

    public int getSubSeq() {
        return subSeq;
    }

    public void setSubSeq(int subSeq) {
        this.subSeq = subSeq;
    }

    public Thread getTd() {
        return td;
    }

    public void setTd(Thread td) {
        this.td = td;
    }

    public Client.Subscribe getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Client.Subscribe subscribe) {
        this.subscribe = subscribe;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getQuerysubseq() {
        return querysubseq;
    }

    public void setQuerysubseq(int querysubseq) {
        this.querysubseq = querysubseq;
    }

    public Client.QueryAndSubscribe getQuerysubscribe() {
        return querysubscribe;
    }

    public void setQuerysubscribe(Client.QueryAndSubscribe querysubscribe) {
        this.querysubscribe = querysubscribe;
    }

    @Override
    public Phase getPhase() {
        return Phase.PHASE_MODEL;
    }
}