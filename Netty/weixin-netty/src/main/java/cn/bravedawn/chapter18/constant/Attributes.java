package cn.bravedawn.chapter18.constant;

import cn.bravedawn.chapter18.utils.Session;
import io.netty.util.AttributeKey;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/2/20 10:49
 */
public interface Attributes {

    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");

}
