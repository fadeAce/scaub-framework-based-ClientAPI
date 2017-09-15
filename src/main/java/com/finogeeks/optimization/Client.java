/**
 * Created by teril on 2017/7/5.feedback at zbyzhengzong@outlook.com
 */
package com.finogeeks.optimization;
import com.finogeeks.kernal.handle.calback.handler.MessageHandler;
import com.finogeeks.kernal.model.Subscription;

public class Client {

    public static final int TYPE_SUBSCRIBE=0;

    public static final int TYPE_QUERYSUBSCRIBE=1;

    private FICC.ClientCore clientCore;

    private int clientseq;

    public Client(FICC.ClientCore cl){
        this.clientCore=cl;
    }

    public Client(String type , String instance){
        FICC.ClientCoreImp coreImp = new FICC().init(type,instance);
        clientCore = coreImp.getClientCore();
        clientseq=coreImp.getClientSeq();
    }

    public int getClientSeq(){
        return this.clientseq;
    }

    //close
    public boolean close(){
        try{
        clientCore.Close(clientseq);
        return true;
        }catch (Exception e){
            return false;
        }
    }

    //publish
    public void publish(String topic,Object msg){
        Publish pub = new Publish(topic,msg);
        Thread pubthread=new Thread(pub);
        pubthread.start();
    }

    //subscribe
    public Subscription subscribe(String topic, String criteria, MessageHandler handler){
        Subscribe sub = new Subscribe(topic,criteria,handler);
        //create msg one time
        int handle = clientCore.CreateSubscription(topic,criteria,clientseq);
        sub.setSubscription(handle);
        Thread subthread=new Thread(sub);
        subthread.start();
        System.out.println("========sync: sub num = "+ handle +"========");
        Subscription subscription = new Subscription();
        subscription.setSubSeq(handle);
        subscription.setController(TYPE_SUBSCRIBE,sub);
        subscription.setType(TYPE_SUBSCRIBE);
        return subscription;
    }

    //unSub
    public void unSub(Subscription subSeq){
        subSeq.getSubscribe().termiate(true);
        clientCore.UnSub(subSeq.getSubQueByType(TYPE_SUBSCRIBE));
        clientCore.CloseSubscription(subSeq.getSubQueByType(TYPE_SUBSCRIBE));
    }

    //unQuerySub
    public void unQuerySub(Subscription querySubSeq){
        querySubSeq.getQuerysubscribe().terminate(true);
        clientCore.UnQuerySub(querySubSeq.getSubQueByType(TYPE_QUERYSUBSCRIBE));
        clientCore.CloseQuerySub(querySubSeq.getSubQueByType(TYPE_QUERYSUBSCRIBE));
    }

    //query
    public void query(String topic,String criteria,MessageHandler handler){
        Query query = new Query(topic,criteria,handler);
        Thread querythread=new Thread(query);
        querythread.start();
    }

    //sub & query
    public Subscription queryAndSubscribe(String topic, String criteria, MessageHandler handler){
        QueryAndSubscribe querysub = new QueryAndSubscribe(topic,criteria,handler);
        //create querysub one time
        int handle = clientCore.CreateQueryAndSub(topic,criteria,clientseq);
        querysub.setSubscription(handle);
        Thread querysubthread=new Thread(querysub);
        querysubthread.start();
        System.out.println("========sync: querysub num = "+ handle +"========");
        Subscription subscription =new Subscription();
        subscription.setSubSeq(handle);
        subscription.setController(TYPE_QUERYSUBSCRIBE,querysub);
        subscription.setType(TYPE_QUERYSUBSCRIBE);
        return subscription;
    }

    //IsSystemService
    public boolean isSystemService(){
        int tag = clientCore.IsSystemService(clientseq);
        if(tag == 1){
            return  true;
        }else return false;
    }

    //inner class fulfill none-block methods

    public class Publish implements Runnable {
        Object msg;
        String topic;
        public Publish(String topic,Object msg){
            this.msg=msg;
            this.topic=topic;
        }
        public void run() {
            System.out.println(msg.toString());
            System.out.println(topic);
            System.out.println(clientseq);
            clientCore.Publish(topic,msg.toString(),clientseq);
            }
    }

    public class Subscribe implements Runnable {
        private volatile boolean termination = false;
        private int subscription;
        private MessageHandler ml;
        private String criteria;
        private String topic;
        public void termiate(boolean tag){
            this.termination=tag;
        }
        public boolean getTermination(){
            return this.termination;
        }
        public void setSubscription(int handle){
            this.subscription=handle;
        }
        public Subscribe(String topic,String criteria,MessageHandler ml){
            this.criteria=criteria;
            this.topic=topic;
            this.ml=ml;
        }
        public void run(){
            //tag that matters :termination
            //receive msg in loop
            try {
                while (!termination) {
                    System.out.println(termination);
                    String message = clientCore.RecvMessage(subscription);
                    System.out.println(termination);
                    String format = clientCore.GetTopicMessageFormat(topic, clientseq);
                    //sub-back func
                    ml.execute(format, message);
                }
                System.out.println("========come out of loop========");
            }catch (Exception e){
            	e.printStackTrace();
                System.out.println("force stop service!");
            }

        }
    }
    public class Query implements Runnable {
        private MessageHandler ml;
        private String criteria;
        private String topic;
        public Query(String topic,String criteria,MessageHandler ml){
            this.criteria=criteria;
            this.topic=topic;
            this.ml=ml;
        }
        public void run() {
            //create query one time
            int handle = clientCore.CreateQuery(topic,criteria,clientseq);
            //receive msg in loop
            while(true){
                String querymessage =  clientCore.RecvQuery(handle);
                if(querymessage.equals("INNER_CLOSE_PLASMON_QUERY")){
                    break;
                }
                //query-back func
                ml.execute("",querymessage);
            }
        }
    }

    public class QueryAndSubscribe implements Runnable {
        private boolean termination = false;
        private int subscription;
        private MessageHandler ml;
        private String criteria;
        private String topic;
        public void terminate(boolean tag){
            this.termination=tag;
        }
        public void setSubscription(int handle){
            this.subscription=handle;
        }
        public QueryAndSubscribe(String topic,String criteria,MessageHandler ml){
            this.criteria=criteria;
            this.topic=topic;
            this.ml=ml;
        }
        public void run() {
            //receive msg in loop
            while(!termination){
                String querymessage =  clientCore.RecvQueryAndSub(subscription);
                String format = clientCore.GetTopicMessageFormat(topic,clientseq);
                //query-back func
                ml.execute(format,querymessage);
            }
        }
    }

}
