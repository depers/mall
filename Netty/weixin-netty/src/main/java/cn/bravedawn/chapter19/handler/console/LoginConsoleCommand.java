package cn.bravedawn.chapter19.handler.console;

import cn.bravedawn.chapter19.packet.login.LoginRequestPacket;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/11 11:31
 */
@Slf4j
public class LoginConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {

        log.info("输入用户名登录: ");
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        String userName = scanner.nextLine();
        loginRequestPacket.setUsername(userName);
        // 使用默认密码
        loginRequestPacket.setPassword("pwd");

        // 发送登录数据包
        channel.writeAndFlush(loginRequestPacket);
        waitForLoginResponse();
    }

    private static void waitForLoginResponse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }
}