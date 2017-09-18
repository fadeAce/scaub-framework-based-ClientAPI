/**
 * Created by teril on 2017/7/5.feedback at zbyzhengzong@outlook.com
 */
package com.finogeeks.optimization.export;

import com.finogeeks.kernal.model.frame.Pattern;
import com.finogeeks.kernal.pattern.def.PatternRouter;
import com.finogeeks.kernal.pattern.list.PatternMulti;
import com.finogeeks.optimization.raw.ClientCore;

public class Client extends ClientCore {

    //main tag of client que
    private int que;

    //two main element to keep it unique
    private String name;
    private String instance;

    // only support what is defined at the period Client Initializing
    private PatternRouter patternRouter;
    private Pattern pattern;

    //tag showing whether initialized
    private boolean origin = false;

    //initializing
    public Client(String name, String instance){
        setName(name);
        setInstance(instance);
        setPattern(Pattern.PATTERN_MULTI);
        super.pattern = this.getPattern();
        setQue(init(name,instance).getClient());
    }
    public Client(String name, String instance,Pattern pattern){
        setName(name);
        setInstance(instance);
        setPattern(pattern);
        super.pattern = this.getPattern();
        setQue(init(name,instance).getClient());
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

    private boolean isOrigin() {
        return origin;
    }

    private void setOrigin(boolean origin) {
        this.origin = origin;
    }

    public Pattern getPattern() {
        return pattern;
    }

    private void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public int getQue() {
        return que;
    }

    private void setQue(int que) {
        this.que = que;
        super.client= que;
    }
}
