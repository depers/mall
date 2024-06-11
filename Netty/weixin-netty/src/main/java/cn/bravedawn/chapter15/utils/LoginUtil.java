package cn.bravedawn.chapter15.utils;

import cn.bravedawn.chapter15.constant.Attributes;
import io.netty.channel.Channel;
import io.netty.util.Attribute;

public class LoginUtil {


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
