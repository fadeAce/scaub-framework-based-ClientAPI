import com.finogeeks.kernal.handler.calback.MessageHandler;

/**
 * Created by teril on 2017/7/6.
 */
public class Assembler implements MessageHandler {
    int count=0;
    //function that is used to call-back when message returns from the very topic subscribed former
    @Override
    public void execute(String format,String msg) {
        count++;
        System.out.println("message is :"+ msg);
        System.out.println("======== count is : "+count+" ; format is:"+format+"========");
    }
}
