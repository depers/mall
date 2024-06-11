package cn.bravedawn.chapter20.handler.console;

import cn.bravedawn.chapter20.packet.group.ListGroupMembersRequestPacket;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/11 15:43
 */
@Slf4j
public class ListGroupMembersConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        ListGroupMembersRequestPacket requestPacket = new ListGroupMembersRequestPacket();

        log.info("输入 groupId 获取群聊成员列表: ");
        String groupId = scanner.next();

        requestPacket.setGroupId(groupId);
        channel.writeAndFlush(requestPacket);
    }
}
