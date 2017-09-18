package com.finogeeks.kernal.execute.executor;

import com.finogeeks.kernal.model.frame.GenaralSpec;
import com.finogeeks.kernal.model.frame.Pattern;

import java.util.Map;

/**
 * Created by teril on 2017/9/18.
 */
public interface HandleBinder {
    public GenaralSpec bindHandle(Map param);
}
