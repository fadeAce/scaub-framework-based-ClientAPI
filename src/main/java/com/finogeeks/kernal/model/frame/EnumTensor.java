package com.finogeeks.kernal.model.frame;

import java.util.Map;

/**
 * Created by teril on 2017/9/14.
 */
public class EnumTensor {
    private Pattern P;
    private Method M;
    private Map<Key,Object> param;

    public Pattern getP() {
        return P;
    }

    public void setP(Pattern p) {
        P = p;
    }

    public Method getM() {
        return M;
    }

    public void setM(Method m) {
        M = m;
    }

    public Map<Key, Object> getParam() {
        return param;
    }

    public void setParam(Map<Key, Object> param) {
        this.param = param;
    }
}
