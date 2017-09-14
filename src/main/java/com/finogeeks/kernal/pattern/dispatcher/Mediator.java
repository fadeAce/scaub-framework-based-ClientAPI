package com.finogeeks.kernal.pattern.dispatcher;

import com.finogeeks.kernal.model.frame.EnumTensor;
import com.finogeeks.kernal.model.frame.Key;
import com.finogeeks.kernal.model.frame.Method;
import com.finogeeks.kernal.model.frame.Pattern;
import com.finogeeks.kernal.pattern.list.PatternMulti;

import java.util.Map;

/**
 * Created by teril on 2017/9/14.
 */
public class Mediator {
    // All complex matching uniforms are collected here .
    public Boolean match(EnumTensor enumTensor){

        //data repackage
        Method method = enumTensor.getM();
        Pattern pattern = enumTensor.getP();
        Map<Key,Object> paramap = enumTensor.getParam();

        //cases: essential part
        switch(pattern){
            case PATTERN_MULTI:
                switch(method){
                    case METHOD_QUERY:
                        //QUERY MULTI
                        PatternMulti patternMulti = new PatternMulti();
                        patternMulti.pin(paramap);
                }
        }

        return true;
    }
}
