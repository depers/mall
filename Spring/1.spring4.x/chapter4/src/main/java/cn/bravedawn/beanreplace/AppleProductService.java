package cn.bravedawn.beanreplace;

/**
 * @author : depers
 * @program : chapter4
 * @description:
 * @date : Created in 2023/7/24 15:34
 */


public class AppleProductService implements ProductService{

    @Override
    public void getInfo() {
        System.out.println("这个是苹果产品");
    }
}
