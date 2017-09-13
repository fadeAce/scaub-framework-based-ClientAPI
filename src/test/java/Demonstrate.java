//import com.finogeeks.execute.*;
//import com.finogeeks.model.Subscription;
//import quickfix.*;
//import quickfix.plasmon.Heartbeat;
//import static java.lang.Thread.sleep;
//
///**
// * Created by teril on 2017/7/5.
// */
//public class Demonstrate {
//    public static void main(String Args[]){
//
//        //demonstate cross-call & initialize
//        //init Client
//        Client pub_demo = new Client("pub","1");
//        Client sub_demo = new Client("sub","1");
//        Client query_demo = new Client("query","1");
//        Client querysub_demo = new Client("querysub","1");
//
//
//        //demonstrate pub  Message in a multi-thread consequence as Heartbeat
//        class DemonMultiPush implements Runnable {
//            private Client inner;
//            private String topic;
//            private Message msg;
//            public DemonMultiPush(Client inner, String topic, Message msg){
//                this.inner=inner;
//                this.topic=topic;
//                this.msg=msg;
//            }
//            @Override
//            public void run() {
//                try{
//                    while(true){
//                        sleep(1000);
//                        inner.publish(topic,msg);// J/api in run() content as a sender of Heartbeat
//                    }
//                }catch (Exception e){
//                    System.out.println("process in error!"+e);
//                }
//            }
//        }
//        DemonMultiPush demonMultiPush = new DemonMultiPush(pub_demo,"plasmon_heartbeat",new Heartbeat());
//        Thread test = new Thread(demonMultiPush);
//        test.start();
//
//        //demonstrate sub in main thread
//        Assembler SUB=new Assembler();//com.finogeeks.Assembler is one instance of com.finogeeks.handler.MessageHandler individualized by any class implemented it
//        Subscription order_1 = sub_demo.subscribe("order","Account=mike",SUB);
//
//        //demonstrate query
//        Assembler QUERY=new Assembler();
//        query_demo.query("order","Account=mike",QUERY);
//
//        //demonstrate query & sub and close
//        Assembler QUERYSUB=new Assembler();
//        Subscription qs_1 = querysub_demo.queryAndSubscribe("order","Account=mike AND Symbol=IBM",QUERYSUB);
//
//        //test unSub
//        try {
//            sleep(15000);
//            System.out.println("======== unsub ========");
//            sub_demo.unSub(order_1);
//        } catch (InterruptedException e) {
//            System.out.println("time out!");
//        }
//
//        //test unQuerySub
//        try {
//            sleep(10000);
//            System.out.println("======== unsubquery ========");
//            querysub_demo.unQuerySub(qs_1);
//        } catch (InterruptedException e) {
//            System.out.println("time out!");
//        }
//        try {
//            sleep(10000);
//            System.out.println("=======kill querysub demo========");
//            querysub_demo.close();
//        }catch (Exception e){
//            System.out.println("out of time !");
//        }
//
//
//        //test IsSystemService
//        if(querysub_demo.isSystemService()){
//            System.out.println("========system service!=======");
//        }else System.out.println("========not system service!========");
//
//        System.out.println("=======All unit test cases are done !========");
//    }
//}



import com.finogeeks.execute.*;
import com.finogeeks.model.Subscription;
import static java.lang.Thread.sleep;

/**
 * Created by teril on 2017/7/5.
 */
public class Demonstrate {

    public static void main(String Args[]){

        //demonstate cross-call & initialize
        //init Client
//        Client pub_demo = new Client("pub","1");
//        Client loader = new Client("loader","1");
//        Client sub_demo = new Client("sub","1");
//        Client query_demo = new Client("query","1");
//        Client querysub_demo = new Client("querysub","1");
//        Client demo_oms = new Client("webui","1");


//        //demonstrate pub  Message in a multi-thread consequence as Heartbeat
//        class DemonMultiPush implements Runnable {
//            private Client inner;
//            private String topic;
//            private Message msg;
//            public DemonMultiPush(Client inner, String topic, Message msg){
//                this.inner=inner;
//                this.topic=topic;
//                this.msg=msg;
//            }
//            @Override
//            public void run() {
//                try{
//                    while(true){
//                        sleep(1000);
//                        inner.publish(topic,msg);// J/api in run() content as a sender of Heartbeat
//                    }
//                }catch (Exception e){
//                    System.out.println("process in error!"+e);
//                }
//            }
//        }
//        DemonMultiPush demonMultiPush = new DemonMultiPush(pub_demo,"plasmon_heartbeat",new Heartbeat());
//        Thread test = new Thread(demonMultiPush);
//        test.start();

//        //demonstrate pub  Message in a multi-thread consequence as Heartbeat
//        class DemonMultiPush implements Runnable {
//            private Client inner;
//            private String topic;
//            private Message msg;
//            public DemonMultiPush(Client inner, String topic, Message msg){
//                this.inner=inner;
//                this.topic=topic;
//                this.msg=msg;
//            }
//            @Override
//            public void run() {
//                try{
//                    while(true){
//                        sleep(1000);
////                        inner.publish(topic,msg);// J/api in run() content as a sender of Heartbeat
////                        inner.publish("sourceproductmessage","8=PLASMON.1.0\u00019=240\u000135=SPM\u000142=20170831-11:42:11.053\u000152=20170831-11:42:11.053\u0001309=010508.SH\u000120002=WindRepoLoader\u000120007=203028.SH\u000120008=shex\u000120027=REPO\u000120028=Outright\u000120035=0508R007\u000120055=Wind\u000120057=上交所7天国债买断式回购利率\u000120107=Outright\u000120108=7\u000120109=20050825\u000120110=1.5\u000110=029\u0001");
//                        inner.publish("logon","8=FIXT.1.1\u00019=119\u000135=LI\u000152=20170901-15:34:49.595\u000120002=1234\u000120005=test\u000120008=she\u000120023=a12345678\u000120031=a\u000120034=0\u000120036=1234\u000120037=123456\u000110=178\u0001");
//                    }
//                }catch (Exception e){
//                    System.out.println("process in error!"+e);
//                }
//            }
//        }
//        DemonMultiPush demonMultiPush = new DemonMultiPush(demo_oms,"plasmon_heartbeat",new Heartbeat());
//        Thread test = new Thread(demonMultiPush);
//        test.start();

//        //demonstrate sub in main thread
//        Assembler SUB=new Assembler();//com.finogeeks.Assembler is one instance of com.finogeeks.handler.MessageHandler individualized by any class implemented it
//        Subscription order_1 = sub_demo.subscribe("order","Account=mike",SUB);

//        //demonstrate query
//        Assembler QUERY=new Assembler();
//        query_demo.query("order","Account=mike",QUERY);
//
//        //demonstrate query & sub and close
//        Assembler QUERYSUB=new Assembler();
//        Subscription qs_1 = querysub_demo.queryAndSubscribe("order","Account=mike AND Symbol=IBM",QUERYSUB);
//

//        //demonstrate query & sub and close
//        Assembler SUBDEMO=new Assembler();
//        demo_oms.queryAndSubscribe("logonresp","",SUBDEMO);

//        //test unSub
//        try {
//            sleep(15000);
//            System.out.println("======== unsub ========");
//            sub_demo.unSub(order_1);
//        } catch (InterruptedException e) {
//            System.out.println("time out!");
//        }
//
//        //test unQuerySub
//        try {
//            sleep(10000);
//            System.out.println("======== unsubquery ========");
//            querysub_demo.unQuerySub(qs_1);
//        } catch (InterruptedException e) {
//            System.out.println("time out!");
//        }
//        try {
//            sleep(10000);
//            System.out.println("=======kill querysub demo========");
//            querysub_demo.close();
//        }catch (Exception e){
//            System.out.println("out of time !");
//        }
//
//
//        //test IsSystemService
//        if(querysub_demo.isSystemService()){
//            System.out.println("========system service!=======");
//        }else System.out.println("========not system service!========");


//        /**
//         * lineHandle testing from Warren test case by sending message to bus from database
//         * message topic is: sourceproductmessage
//         */
//        // test a pub -> sub -> unSub circumstance
//        // Warren test case
//        // database message -> bus
        Client loader = new Client("loader","1");
//        //demonstrate pub  Message in a multi-thread consequence as Heartbeat
//
//        class LoaderPub implements Runnable {
//            private Client inner;
//            private String topic;
//            private Message msg;
//            public LoaderPub(Client inner, String topic, Message msg){
//                this.inner=inner;
//                this.topic=topic;
//                this.msg=msg;
//            }
//            @Override
//            public void run() {
//                try{
//                    while(true){
//                        sleep(1000);
////                        inner.publish("rds_repo","8=PLASMON.1.0\u00019=197\u000135=Repo\u000115=CNY\u0001779=20170907-10:02:58.962\u000120001=R04MM_IB\u000120002=REPO\u000120003=Outright\u000120006=WindRepoLoader\u000120007=20170907-10:02:58.906\u000120008=Wind\u000120009=R04MM\u000120010=银行间121天买断式回购利率\u000120013=cfets\u000120031=121\u000110=061\u0001");
//                        inner.publish("rds_futures","8=PLASMON.1.0\u00019=365\u000135=Future\u000115=CNY\u0001421=CN\u0001779=20170911-10:17:18.515\u0001898=5.0\u000120001=LR709-CZC\u000120002=FUT\u000120003=谷物\u000120006=WindFutLoader\u000120007=20170911-10:17:18.514\u000120008=Wind\u000120009=晚籼稻1709\u000120010=晚籼稻1709合约\u000120011=LR709\u000120012=CZCE-LR1709\u000120013=czce\u000120014=20160919\u000120015=1.0\u000120016=20.0\u000120018=LR\u000120019=Monthly\u000120021=20170914\u000120022=20170918\u000120023=晚籼稻\u000120024=吨\u000120025=20140708\u000120027=6\u000120028=LR709\u000110=139\u0001");
//                    }
//                }catch (Exception e){
//                    System.out.println("process in error!"+e);
//                }
//            }
//        }
//        LoaderPub loaderpuber = new LoaderPub(loader,"plasmon_heartbeat",new Heartbeat());
//        Thread pub = new Thread(loaderpuber);
//        pub.start();
//
//
//        Client reader = new Client("reader" , "1");
//        Subscription sourceproductmessage = reader.subscribe("rdsrepo","",new SubLoader());
//
//
//        try {
//            sleep(15000);
//            System.out.println("======== unsub reader ========");
//            reader.unSub(sourceproductmessage);
//        } catch (InterruptedException e) {
//            System.out.println("time out!");
//        }

        // test a new query -> querySub -> unQuerySub circumstance
        loader.query("rds_bond","",new Assembler());


//        try {
//            sleep(3000);
//            Subscription querysource = loader.queryAndSubscribe("rdsrepo","",new QueryGeneral());
//            sleep(15000);
//            loader.unQuerySub(querysource);
//        } catch (InterruptedException e) {
//            System.out.println(e);
//        }
//
//        pub.stop();

        System.out.println("=======All unit test cases are done !========");
    }
}
