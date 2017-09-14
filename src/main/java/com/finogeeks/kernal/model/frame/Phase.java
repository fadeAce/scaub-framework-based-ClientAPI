package com.finogeeks.kernal.model.frame;

/**
 * Created by teril on 2017/9/14.
 */
public enum Phase {
    PHASE_MODEL("PHASE_MODEL"), PHASE_PATTERN("PHASE_PATTERN"), PHASE_HANDLER("PHASE_HANDLER"), PHASE_EXECUTE("PHASE_EXECUTE");
    private String phase;

    private Phase (String str){
        this.phase=str;
    }

    public String getPhase() {
        return phase;
    }
    public void setPhase(String phase) {
        this.phase = phase;
    }
}