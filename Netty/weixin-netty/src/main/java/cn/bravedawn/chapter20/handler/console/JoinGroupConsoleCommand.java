package cn.bravedawn.chapter20.handler.console;

import cn.bravedawn.chapter20.packet.group.JoinGroupRequestPacket;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/11 15:38
 */
@Slf4j
public class JoinGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        JoinGroupRequestPacket requestPacket = new JoinGroupRequestPacket();

        log.info("输入 groupId，加入群聊: ");
        String groupId = scanner.next();

        requestPacket.setGroupId(groupId);
        channel.writeAndFlush(requestPacket);
    }
}
