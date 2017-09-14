/**
 * Created by teril on 2017/7/5.feedback at zbyzhengzong@outlook.com
 */
package com.finogeeks.optimization.export;

import com.finogeeks.kernal.pattern.def.PatternRouter;
import com.finogeeks.kernal.pattern.list.PatternMulti;
import com.finogeeks.optimization.raw.ClientCore;

public class Client extends ClientCore {

    //two main element to keep it unique
    private String name;
    private String instance;

    // only support what is defined at the period Client Initializing
    private PatternRouter patternRouter;

    //initializing
    public Client(String name, String instance){
        setName(name);
        setInstance(instance);
        /* set default pattern as multiThread mode */
        setPatternRouter(new PatternMulti());
    }

    // public safety packaging
    public PatternRouter getPatternRouter() {
        return patternRouter;
    }

    public String getInstance() {
        return instance;
    }

    // private keeper
    private void setPatternRouter(PatternRouter patternRouter) {
        this.patternRouter = patternRouter;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setInstance(String instance) {
        this.instance = instance;
    }
}
