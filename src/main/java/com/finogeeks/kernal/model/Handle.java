package com.finogeeks.kernal.model;

import com.finogeeks.kernal.model.frame.GenaralSpec;

/**
 * Created by teril on 2017/9/18.
 */
public class Handle implements GenaralSpec{
    private int handle;
    private String err_code;
    private Boolean tag;
    private Terminator terminator;
    public Handle(){
        this.tag = true ;
    }
    public Handle(int handle){
        this.handle = handle;
        this.tag = true ;
        this.terminator = new Terminator();
    }

    public Boolean getTag() {
        return tag;
    }

    public void setTag(Boolean tag) {
        this.tag = tag;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public int getHandle() {
        return handle;
    }

    public void setHandle(int handle) {
        this.handle = handle;
    }

    public Terminator getTerminator() {
        return terminator;
    }

    public void setTerminator(Terminator terminator) {
        this.terminator = terminator;
    }
}
