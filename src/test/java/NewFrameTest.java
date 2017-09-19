import com.finogeeks.kernal.model.frame.Pattern;
import com.finogeeks.optimization.export.Client;

/**
 * Created by teril on 2017/9/15.
 */
public class NewFrameTest {
    public static void main(String Args[]){
        Client loader = new Client("loader","1");
        loader.query("rds_bond","",new Assembler());
        System.out.println("[client seq:"+loader.getQue()+",client pattern:"+loader.getPattern().toString()+"]");
        Client pub = new Client("pub","1", Pattern.PATTERN_QUE);
        System.out.println("[client seq:"+pub.getQue()+",client pattern:"+pub.getPattern().toString()+"]");
        Client sub = new Client("sub","1");
        sub.subscribe("order","account=mike",new Assembler());
    }
}