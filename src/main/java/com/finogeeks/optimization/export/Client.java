/**
 * Created by teril on 2017/7/5.feedback at zbyzhengzong@outlook.com
 */
package com.finogeeks.optimization.export;

import com.finogeeks.kernal.pattern.def.PatternRouter;
import com.finogeeks.kernal.pattern.list.PatternMulti;

public class Client{

    //two main element to keep it unique
    private String name;
    private String instance;

    // only support defined at the period Client Initializing
    private PatternRouter patternRouter;

    public Client(String name, String instance){
        setName(name);
        setInstance(instance);
        /* set default pattern as multiThread mode */
        setPatternRouter(new PatternMulti());
    }

    public PatternRouter getPatternRouter() {
        return patternRouter;
    }

    public void setPatternRouter(PatternRouter patternRouter) {
        this.patternRouter = patternRouter;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }
}
