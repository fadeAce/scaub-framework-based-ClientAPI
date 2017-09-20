import com.finogeeks.kernal.handle.calback.handler.MessageHandler;

/**
 * Created by teril on 2017/7/6.
 */
public class Assembler implements MessageHandler {
    int count=0;
    long startTime = System.currentTimeMillis();//获取当前时间
    //function that is used to call-back when message returns from the very topic subscribed former
    @Override
    public void execute(String format,String msg) {
        count++;
        System.out.println("message is :"+ msg);
        System.out.println("======== count is : "+count+" ; format is:"+format+"========");
        if(count==100){
            long endTime = System.currentTimeMillis();
            System.out.println("程序运行时间："+(endTime-startTime)+"ms");
        }
    }
}
