package cn.bravedawn.chapter20.utils;

import cn.bravedawn.chapter20.constant.Attributes;
import io.netty.channel.Channel;
import io.netty.util.Attribute;

import java.util.concurrent.atomic.AtomicInteger;

public class LoginUtil {

    public static final AtomicInteger ID_CREATE = new AtomicInteger();


    /**
     * 标记用户已登录
     * @param channel
     */
    public static void markAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(true);
    }

    /**
     * 校验用户是否登录
     * @param channel
     * @return
     */
    public static boolean hasLogin(Channel channel) {
        Attribute<Boolean> loginAttr = channel.attr(Attributes.LOGIN);

        return loginAttr.get() != null;
    }
}
