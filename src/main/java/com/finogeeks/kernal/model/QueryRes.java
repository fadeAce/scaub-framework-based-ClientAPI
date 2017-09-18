package com.finogeeks.kernal.model;

import com.finogeeks.kernal.model.frame.GenaralSpec;

/**
 * Created by teril on 2017/9/15.
 */
public class QueryRes implements GenaralSpec {

    private int queryHandle;

    private Boolean tag;

    private String err_code;

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

    public int getQueryHandle() {
        return queryHandle;
    }

    public void setQueryHandle(int queryHandle) {
        this.queryHandle = queryHandle;
    }
}
