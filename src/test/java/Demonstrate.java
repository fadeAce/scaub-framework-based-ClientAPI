import com.finogeeks.optimization.QuerySubscription;
import com.finogeeks.optimization.Subscription;
import com.finogeeks.optimization.Client;

import static java.lang.Thread.sleep;

/**
 * Created by Teril on 2017/7/5.
 */
public class Demonstrate {
    public static void main(String Args[]){
//        System.out.println(System.getenv("connector"));
        Client loader = new Client("loader","1");
//        loader.query("rds_bond","",new Assembler());
//        Client sub = new Client("sub","1");
//        sub.subscribe("order","account=mike",new Assembler());

        //querysub
        Subscription qusubs =  loader.queryAndSubscribe("rds_bond","",new Assembler());
        try {
            sleep(10000);
            loader.unQuerySub(qusubs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(loader.isSystemService());
    }
}