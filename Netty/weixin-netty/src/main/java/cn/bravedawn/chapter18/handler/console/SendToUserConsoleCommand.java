package cn.bravedawn.chapter18.handler.console;

import cn.bravedawn.chapter18.packet.message.MessageRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/11 11:32
 */
public class SendToUserConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        String toUserId = scanner.next();
        String message = scanner.next();
        channel.writeAndFlush(new MessageRequestPacket(toUserId, message));
    }
}
