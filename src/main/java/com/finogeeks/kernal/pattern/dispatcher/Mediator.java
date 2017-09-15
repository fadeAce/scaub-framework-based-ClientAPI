package com.finogeeks.kernal.pattern.dispatcher;

import com.finogeeks.kernal.model.InitRes;
import com.finogeeks.kernal.model.frame.*;
import com.finogeeks.kernal.pattern.list.PatternMulti;

import java.util.Map;

/**
 * Created by teril on 2017/9/14.
 */
public class Mediator {
    // All complex matching uniforms are collected here .
    public static GenaralSpec match(EnumTensor enumTensor){

        //data repackage
        Method method = enumTensor.getM();
        Pattern pattern = enumTensor.getP();
        Map<Key,Object> paramap = enumTensor.getParam();

        //cases: essential part
        switch(pattern){
            case PATTERN_MULTI:
                switch(method){
                    case METHOD_INIT:
                        //INIT MULTI
                        PatternMulti patternMultiI = new PatternMulti();
                        return new InitRes(patternMultiI.init(paramap));
                    case METHOD_QUERY:
                        //QUERY MULTI
                        PatternMulti patternMultiQ = new PatternMulti();
                        patternMultiQ.query(paramap);
                        return null;
                }
        }
        return null;
    }
}
