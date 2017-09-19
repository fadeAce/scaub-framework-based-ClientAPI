package com.finogeeks.kernal.model;

/**
 * Created by teril on 2017/9/19.
 */
public class Terminator {
    private Boolean sub_ack ;
    private Boolean querysub_ack ;

    public Terminator(){
        this.sub_ack = true;
        this.querysub_ack = true;
    }

    public Boolean getSub_ack() {
        return this.sub_ack;
    }

    public void setSub_ack(Boolean sub_ack) {
        this.sub_ack = sub_ack;
    }

    public Boolean getQuerysub_ack() {
        return this.querysub_ack;
    }

    public void setQuerysub_ack(Boolean querysub_ack) {
        this.querysub_ack = querysub_ack;
    }
}
