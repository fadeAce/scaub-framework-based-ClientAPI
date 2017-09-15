/**
 * Created by finogeeks.teril on 2017/7/5. do feedback at zbyzhengzong@outlook.com
 */
package com.finogeeks.optimization;
import com.sun.jna.*;
import java.util.*;

public class FICC {
    public interface ClientCore extends Library {
        // Foreign functions
        String Publish(String str1,String str2,int clientSeq);
        // rebuild version of api: sub q sub&q by common receive and create.
        int Init(String str1,String str2);
        // Public method with common dedicated receive and create msg
        int CreateSubscription(String topic,String criteria,int clientSeq);
        int CreateQuery(String str1,String str2,int clientSeq);
        int CreateQueryAndSub(String str1,String str2,int clientSeq);
        String RecvMessage(int msgHandle);
        String RecvQuery(int msgHandle);
        String RecvQueryAndSub(int msgHandle);
        //version 1.1 new features
        void Close(int clientSeq);
        String GetTopicMessageFormat(String topic, int clientSeq);
        int IsSystemService(int clientSeq);
        void UnSub(int subSeq);
        void UnQuerySub(int querysubSeq);
        void CloseSubscription(int subSeq);
        void CloseQuerySub(int querysubseq);
        void CloseQuery(int queryseq);
    }

    public class ClientCoreImp{
        private ClientCore clientCore;
        private int clientSeq;
        public ClientCoreImp(ClientCore clientCore,int clientSeq){
            this.clientCore=clientCore;
            this.clientSeq=clientSeq;
        }
        public int getClientSeq() {
            return clientSeq;
        }
        public void setClientSeq(int clientSeq) {
            this.clientSeq = clientSeq;
        }
        public ClientCore getClientCore() {
            return clientCore;
        }
        public void setClientCore(ClientCore clientCore) {
            this.clientCore = clientCore;
        }
    }

    public ClientCoreImp init(String type,String instance){
        String dir = System.getProperty("user.dir");
        try{
            ClientCore client = (ClientCore) Native.loadLibrary( dir+"/target/classes/transfer-1.2.1/resources/finogeeks_J.so" , ClientCore.class);
            int seq=client.Init(type,instance);
            return new ClientCoreImp(client,seq);
        }
        catch (UnsatisfiedLinkError e){
            ClientCore client = (ClientCore) Native.loadLibrary( dir+"/target/classes/transfer-1.2.1/resources/finogeeks_J.dll" , ClientCore.class);
            int seq=client.Init(type,instance);
            return new ClientCoreImp(client,seq);
        }
    }
}
