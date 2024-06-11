package cn.bravedawn.chapter20.handler.serverhandler;

import cn.bravedawn.chapter20.packet.login.LoginRequestPacket;
import cn.bravedawn.chapter20.packet.login.LoginResponsePacket;
import cn.bravedawn.chapter20.utils.LoginUtil;
import cn.bravedawn.chapter20.utils.Session;
import cn.bravedawn.chapter20.utils.SessionUtil;
import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author Chanmoey
 * @date 2022年08月31日
 */
@Slf4j
// 加上注解标识，表明该Handler可以是多个Channel共享的
@ChannelHandler.Sharable
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {

    public static final LoginRequestHandler INSTANCE = new LoginRequestHandler();

    protected LoginRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket) throws Exception {
        LoginResponsePacket response = new LoginResponsePacket();
        if (valid(loginRequestPacket)) {
            response.setSuccess(true);
            String userId = randomUserId();
            response.setUserId(userId);
            response.setUserName(loginRequestPacket.getUsername());
            response.setVersion(loginRequestPacket.getVersion());
            SessionUtil.bindSession(new Session(userId, loginRequestPacket.getUsername()), ctx.channel());
            LoginUtil.markAsLogin(ctx.channel());
            log.info("{}: 用户{}，登录成功, id为: {}", new Date(), loginRequestPacket.getUsername(), userId);
        } else {
            response.setReason("账号或密码校验失败");
            response.setSuccess(false);
        }
        ctx.channel().writeAndFlush(response);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        // 用户断线之后取消绑定
        SessionUtil.unBindSession(ctx.channel());
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        log.info("验证登录信息：{}", JSON.toJSONString(loginRequestPacket));
        double luck = Math.random();
        return luck < 0.999999;
    }

    private String randomUserId() {
        // 生成随机的用户id
        return String.valueOf(LoginUtil.ID_CREATE.getAndIncrement());
    }
}
