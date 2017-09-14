package com.finogeeks.kernal.pattern.def;

import com.finogeeks.kernal.model.frame.Key;

import java.util.Map;

/**
 * Created by teril on 2017/9/14.
 */
public interface PatternRouter {
    // [p,m] p as pattern type , m as method type
    public void pin(Map<Key,Object> paramap);
}
