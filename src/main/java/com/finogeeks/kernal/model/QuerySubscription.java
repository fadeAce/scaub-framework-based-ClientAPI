package com.finogeeks.kernal.model;

import com.finogeeks.optimization.Client;

/**
 * Created by teril on 2017/8/21.
 * sub subquery
 */
public class QuerySubscription {
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
}
