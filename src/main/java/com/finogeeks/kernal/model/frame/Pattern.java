package com.finogeeks.kernal.model.frame;

/**
 * Created by teril on 2017/9/14.
 */
public enum Pattern {

    PATTERN_MULTI("PATTERN_MULTI"), PATTERN_QUE("PATTERN_QUE"), PATTERN_NATIVE("PATTERN_NATIVE");

    private String pattern;

    private Pattern(String str){
        this.pattern=str;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

}