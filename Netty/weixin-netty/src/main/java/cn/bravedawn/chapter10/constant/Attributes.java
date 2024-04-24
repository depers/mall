package cn.bravedawn.chapter10.constant;

import io.netty.util.AttributeKey;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/2/20 10:49
 */
public interface Attributes {

    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");

}
