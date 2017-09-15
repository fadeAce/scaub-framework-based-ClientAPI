package com.finogeeks.kernal.execute.executor;

/**
 * Created by teril on 2017/9/15.
 */
public interface DylibExecutor {
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
