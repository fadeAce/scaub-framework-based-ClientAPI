package com.finogeeks.kernal.execute.pool;

import com.finogeeks.kernal.execute.executor.DylibExecutor;
import com.finogeeks.kernal.execute.executor.LibLoader;
import com.sun.jna.Native;

/**
 * Created by teril on 2017/9/15.
 */
public class DylibLoaderFixed implements LibLoader{
    //read instance.
    public static DylibExecutor getLibInstance(){
        //dynamic loader
        String dir = System.getProperty("user.dir");
        DylibExecutor core =  (DylibExecutor) Native.loadLibrary( dir+"/target/classes/transfer-1.2.1/resources/finogeeks_J.so" , DylibExecutor.class);
        return core;
    }
}
