package cn.bravedawn.chapter10.utils;

import cn.bravedawn.chapter10.constant.Attributes;
import io.netty.channel.Channel;
import io.netty.util.Attribute;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/2/20 10:50
 */
public class LoginUtil {

    public static void markAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(true);
    }

    public static boolean hasLogin(Channel channel) {
        Attribute<Boolean> loginAttr = channel.attr(Attributes.LOGIN);

        return loginAttr.get() != null;
    }
}
