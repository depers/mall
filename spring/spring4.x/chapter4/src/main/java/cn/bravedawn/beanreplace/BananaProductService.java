package cn.bravedawn.beanreplace;

/**
 * @author : depers
 * @program : chapter4
 * @description:
 * @date : Created in 2023/7/24 15:35
 */
public class BananaProductService implements ProductService{


    @Override
    public void getInfo() {
        System.out.println("这个是香蕉商品");
    }
}
