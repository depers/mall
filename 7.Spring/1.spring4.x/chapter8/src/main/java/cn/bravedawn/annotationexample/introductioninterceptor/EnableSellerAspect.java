package cn.bravedawn.annotationexample.introductioninterceptor;

import cn.bravedawn.annotationexample.Seller;
import cn.bravedawn.annotationexample.SmartSeller;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * @author : depers
 * @program : chapter8
 * @description:
 * @date : Created in 2023/7/10 16:31
 */
@Aspect
public class EnableSellerAspect {


    /**
     * 引介增强
     */
    @DeclareParents(value = "cn.bravedawn.annotationexample.NaiveWaiter", defaultImpl = SmartSeller.class)
    public Seller seller;
}
