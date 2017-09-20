package com.finogeeks.kernal.pattern.dispatcher;

import com.finogeeks.kernal.model.*;
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

    public static Object getMultiVal(Key key){
        return Multi.get(key);
    }

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
                        Handle handleS = patternMultiS.subscribe(paramap);
                        Subscription subscriptionS = new Subscription();
                        subscriptionS.setSubSeq(Method.METHOD_SUB,handleS.getHandle());
                        subscriptionS.setTerminator(handleS.getTerminator());
                        return subscriptionS;
                    case METHOD_QUERYSUB:
                        PatternMulti patternMultiQS = new PatternMulti();
                        Handle handleQS = patternMultiQS.querySub(paramap);
                        Subscription subscriptionQS = new Subscription();
                        subscriptionQS.setSubSeq(Method.METHOD_QUERYSUB,handleQS.getHandle());
                        subscriptionQS.setTerminator(handleQS.getTerminator());
                        return subscriptionQS;
                    case METHOD_CLOSE:
                        PatternMulti patternMultiC = new PatternMulti();
                        Boolean bool=patternMultiC.Close(paramap);
                        GeneralBoolean generalBooleanC = new GeneralBoolean(Method.METHOD_CLOSE,Pattern.PATTERN_MULTI,bool);
                        return generalBooleanC;
                    case METHOD_ISSYSSERVICE:
                        PatternMulti patternMultiIS = new PatternMulti();
                        Boolean sys = patternMultiIS.checkService(paramap);
                        GeneralBoolean generalBooleanI = new GeneralBoolean(Method.METHOD_ISSYSSERVICE,Pattern.PATTERN_MULTI,sys);
                        return generalBooleanI;
                    case METHOD_UNSUB:
                        PatternMulti patternMultiUS = new PatternMulti();
                        patternMultiUS.unSub(paramap);
                        return null;
                    case METHOD_UNQUERYSUB:
                        PatternMulti patternMultiUQ = new PatternMulti();
                        patternMultiUQ.unQuerySub(paramap);
                        return null;
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
