package cn.bravedawn.annotationexample;

/**
 * @author : depers
 * @program : chapter8
 * @description:
 * @date : Created in 2023/7/10 15:26
 */
public interface Waiter {

    public void greetTo(String clientName);

    public void serveTo(String clientName);


    public void greetThrowException(String clientName);
}
