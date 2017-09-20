package com.finogeeks.kernal.model.frame;

import com.finogeeks.kernal.pattern.dispatcher.Mediator;

/**
 * Created by teril on 2017/9/20.
 */
public class GeneralBoolean implements GenaralSpec{
    private Method method;
    private Pattern pattern;
    private Boolean tag;

    public GeneralBoolean(Method method , Pattern pattern , Boolean bool){
        this.method = method;
        this.pattern = pattern;
        this.tag = bool;
    };

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public Boolean getTag() {
        return tag;
    }

    public void setTag(Boolean tag) {
        this.tag = tag;
    }
}
