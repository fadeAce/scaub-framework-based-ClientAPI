package com.finogeeks.kernal.execute.pool;

import com.finogeeks.kernal.execute.executor.DylibExecutor;
import com.finogeeks.kernal.execute.executor.MessageReceiver;
import com.finogeeks.kernal.handle.calback.handler.MessageHandler;
import com.finogeeks.kernal.model.frame.Key;
import com.finogeeks.kernal.model.frame.Method;
import com.finogeeks.kernal.pattern.dispatcher.Mediator;

/**
 * Created by teril on 2017/9/18.
 */
public class LoopFixed implements MessageReceiver,Runnable{
    private int handle;
    private MessageHandler ml;
    private DylibExecutor dylibExecutor ;
    private Method method;
    public void run() {
        dylibExecutor = (DylibExecutor) Mediator.getMultiVal(Key.MULTIEXECUTOR);
        //receive msg in loop
        switch (method){
            case METHOD_QUERY:
                while(true){
                    String msg =  dylibExecutor.RecvQuery(this.handle);
                    if(msg.equals("INNER_CLOSE_PLASMON_QUERY")){
                        break;
                    }
                    //query-back func
                    ml.execute("",msg);
                }
                break;
            case METHOD_SUB:
                    System.out.println("METHOD_SUB");
                break;
            case METHOD_UNQUERYSUB:
                    System.out.println("METHOD_UNQUERYSUB");
                break;
        }
    }

    public int getHandle() {
        return handle;
    }

    public void setHandle(int handle) {
        this.handle = handle;
    }

    public void setMl(MessageHandler ml) {
        this.ml = ml;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
