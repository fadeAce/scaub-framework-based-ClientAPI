import com.finogeeks.kernal.model.frame.Pattern;
import com.finogeeks.optimization.export.Client;

/**
 * Created by teril on 2017/9/15.
 */
public class NewFrameTest {
    public static void main(String Args[]){
//        //query
//        Client loader = new Client("loader","1");
//        loader.query("rds_bond","",new Assembler());
//        System.out.println("[client seq:"+loader.getQue()+",client pattern:"+loader.getPattern().toString()+"]");

        //pub
        Client pub = new Client("pub","1", Pattern.PATTERN_MULTI);
        pub.publish("order","8=FIX.4.0\u00019=88\u000135=D\u00011=mike\u000111=SHANGHAI3038\u000121=1\u000138=100.00\u000140=1\u000144=8900\u000154=1\u000155=APPLE\u000159=0\u0001207=SHANGHAI\u000110=128\u0001");
        System.out.println("[client seq:"+pub.getQue()+",client pattern:"+pub.getPattern().toString()+"]");

//        //sub
//        Client sub = new Client("sub","1");
//        sub.subscribe("order","account=mike",new Assembler());


        //querysub
        Client qs = new Client("querysub","1");
        qs.queryAndSubscribe("order","account=mike",new Assembler());
    }
}