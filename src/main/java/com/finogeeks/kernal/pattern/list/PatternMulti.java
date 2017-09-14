package com.finogeeks.kernal.pattern.list;

import com.finogeeks.kernal.model.frame.BaseTag;
import com.finogeeks.kernal.model.frame.Key;
import com.finogeeks.kernal.model.frame.Phase;
import com.finogeeks.kernal.pattern.def.PatternRouter;

import java.util.Map;

/**
 * Created by teril on 2017/9/14.
 */
public class PatternMulti implements PatternRouter,BaseTag {

    @Override
    public Phase getPhase() {
        return Phase.PHASE_PATTERN;
    }

    @Override
    public void pin(Map<Key,Object> paramap) {
        //
    }

}
