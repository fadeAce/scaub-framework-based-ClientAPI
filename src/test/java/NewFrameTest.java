import com.finogeeks.optimization.export.Client;

/**
 * Created by teril on 2017/9/15.
 */
public class NewFrameTest {
    public static void main(String Args[]){
        Client loader = new Client("loader","1");
        System.out.println(loader.getQue());
    }
}
