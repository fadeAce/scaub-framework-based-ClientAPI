package com.finogeeks.optimization;

import com.finogeeks.kernal.model.frame.BaseTag;
import com.finogeeks.kernal.model.frame.GenaralSpec;
import com.finogeeks.kernal.model.frame.Phase;
import com.finogeeks.optimization.Client;

/**
 * Created by teril on 2017/8/21.
 * sub subquery
 */
public class QuerySubscription implements GenaralSpec,BaseTag {
    private int querysubseq;
    private Thread td;
    private Client.QueryAndSubscribe querySubscribe;

    public Client.QueryAndSubscribe getQuerySubscribe() {
        return querySubscribe;
    }

    public void setQuerySubscribe(Client.QueryAndSubscribe querySubscribe) {
        this.querySubscribe = querySubscribe;
    }

    public Thread getTd() {
        return td;
    }

    public void setTd(Thread td) {
        this.td = td;
    }

    public int getQuerysubseq() {
        return querysubseq;
    }

    public void setQuerysubseq(int querysubseq) {
        this.querysubseq = querysubseq;
    }

    @Override
    public Phase getPhase() {
        return Phase.PHASE_MODEL;
    }
}