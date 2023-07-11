package cn.bravedawn.annotationexample;

/**
 * @author : depers
 * @program : chapter8
 * @description:
 * @date : Created in 2023/7/10 15:27
 */
public class NaiveWaiter implements Waiter{

    public void greetTo(String clientName) {
        System.out.println("NaiveWaiter:greet to "+clientName+"...");
    }


    public void greetThrowException(String clientName) {
        System.out.println("NaiveWaiter:greetThrowException to "+clientName+"...");
        throw new RuntimeException("出错了");
    }

    public void serveTo(String clientName){
        System.out.println("NaiveWaiter:serving "+clientName+"...");
    }

    public void smile(String clientName,int times){
        System.out.println("NaiveWaiter:smile to  "+clientName+ times+"times...");
    }
}
