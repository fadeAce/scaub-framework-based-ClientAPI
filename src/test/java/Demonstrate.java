import com.finogeeks.optimization.Client;

/**
 * Created by Teril on 2017/7/5.
 */
public class Demonstrate {
    public static void main(String Args[]){
//        System.out.println(System.getenv("connector"));
        Client loader = new Client("loader","1");
        loader.query("rds_bond","",new Assembler());
        System.out.println("=======All unit test cases are done !========");

        Client sub = new Client("sub","1");
        sub.subscribe("order","account=mike",new Assembler());

    }
}