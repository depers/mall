package cn.bravedawn.chapter12.utils;

import cn.bravedawn.chapter12.constant.Attributes;
import io.netty.channel.Channel;
import io.netty.util.Attribute;

public class LoginUtil {


    public static void markAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(true);
    }

    public static boolean hasLogin(Channel channel) {
        Attribute<Boolean> loginAttr = channel.attr(Attributes.LOGIN);

        return loginAttr.get() != null;
    }
}
