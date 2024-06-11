package cn.bravedawn.chapter18.handler.console;

import cn.bravedawn.chapter18.packet.group.QuitGroupRequestPacket;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/11 15:42
 */
@Slf4j
public class QuitGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        QuitGroupRequestPacket requestPacket = new QuitGroupRequestPacket();

        log.info("输入 groupId，退出群聊：");
        String groupId = scanner.next();
        requestPacket.setGroupId(groupId);

        channel.writeAndFlush(requestPacket);
    }
}
