package cn.bravedawn.chapter18.handler.console;

import cn.bravedawn.chapter18.packet.group.CreateGroupRequestPacket;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/11 11:28
 */
@Slf4j
public class CreateGroupConsoleCommand implements ConsoleCommand {

    private static final String USER_ID_SPLIT = ",";

    @Override
    public void exec(Scanner scanner, Channel channel) {
        CreateGroupRequestPacket createGroupRequestPacket = new CreateGroupRequestPacket();
        log.info("[拉人群聊]，输入 userId 列表，userId 之间用英文逗号隔开：");
        String userIds = scanner.next();
        createGroupRequestPacket.setUserIdList(Arrays.asList(userIds.split(USER_ID_SPLIT)));
        channel.writeAndFlush(createGroupRequestPacket);
    }
}

