package com.finogeeks.kernal.pattern.dispatcher;

import com.finogeeks.kernal.model.Handle;
import com.finogeeks.kernal.model.InitRes;
import com.finogeeks.kernal.model.QueryRes;
import com.finogeeks.kernal.model.frame.*;
import com.finogeeks.kernal.pattern.list.PatternMulti;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by teril on 2017/9/14.
 */
public class Mediator {

    //Pattern cache
    private static Map<Key,Object> Multi = new HashMap<>();
    //Pattern cache
    private static Map<Key,Object> Que = new HashMap<>();
    //Pattern cache
    private static Map<Key,Object> Native = new HashMap<>();

    public static void addMultiVal(Key key,Object obj){
        Multi.put(key,obj);
    }

    public static Object getMultiVal(Key key){return Multi.get(key);}

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
                    case METHOD_PUB:
                        PatternMulti patternMultiP = new PatternMulti();
                        patternMultiP.publish(paramap);
                        return null;
                    case METHOD_QUERY:
                        //QUERY MULTI
                        PatternMulti patternMultiQ = new PatternMulti();
                        Handle handle = patternMultiQ.query(paramap);
                        QueryRes queryRes = new QueryRes();
                        return queryRes;
                    case METHOD_SUB:
                        //SUB MULTI
                        PatternMulti patternMultiS = new PatternMulti();
                        patternMultiS.subscribe(paramap);
                        return null;
                    case METHOD_UNQUERYSUB:
                        PatternMulti patternMultiQS = new PatternMulti();
                        patternMultiQS.querySub(paramap);
                    case METHOD_CLOSE:
                        PatternMulti patternMultiC = new PatternMulti();
                        Boolean bool=patternMultiC.Close(paramap);
                        GeneralBoolean generalBoolean = new GeneralBoolean(Method.METHOD_CLOSE,Pattern.PATTERN_MULTI,bool);
                        return generalBoolean;
                }
            case PATTERN_QUE:
                switch(method){
                    case METHOD_INIT:
                        //INIT MULTI
                        PatternMulti patternMultiI = new PatternMulti();
                        return new InitRes(patternMultiI.init(paramap));
                }
            case PATTERN_NATIVE:
                switch(method){
                    case METHOD_INIT:
                        //INIT MULTI
                        PatternMulti patternMultiI = new PatternMulti();
                        return new InitRes(patternMultiI.init(paramap));
                }
        }
        return null;
    }
}
