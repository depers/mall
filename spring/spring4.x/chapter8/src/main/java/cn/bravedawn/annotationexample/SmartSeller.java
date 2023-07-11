package cn.bravedawn.annotationexample;

/**
 * @author : depers
 * @program : chapter8
 * @description:
 * @date : Created in 2023/7/10 16:33
 */
public class SmartSeller implements Seller{

    public int sell(String goods, String clientName) {
        System.out.println("SmartSeller: sell "+goods +" to "+clientName+"...");
        return 100;
    }
}
