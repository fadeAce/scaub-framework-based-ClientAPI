package com.finogeeks.kernal.model;

import com.finogeeks.kernal.model.frame.GenaralSpec;
import com.finogeeks.kernal.model.frame.Method;

/**
 * Created by teril on 2017/9/20.
 */
public class Subscription implements GenaralSpec{
    private Boolean tag = true;
    private Method source;
    private int subSeq;
    private Terminator terminator;

    public Method getSource() {
        return source;
    }

    public Integer getSubSeq(Method method) {
        if(source==method){
            return subSeq;
        }else{
            return null;
        }
    }

    public void setSubSeq(Method method, int subSeq) {
        if(tag){
            this.subSeq = subSeq;
            this.source = method;
            this.tag=false;
        }else{
            throw new RuntimeException("this subscription has been set");
        }

    }

    public Boolean getTag() {
        return tag;
    }

    private void setTag(Boolean tag) {
        this.tag = tag;
    }

    public Terminator getTerminator() {
        return terminator;
    }

    public void setTerminator(Terminator terminator) {
        this.terminator = terminator;
    }
}
