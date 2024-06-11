package cn.bravedawn.chapter19.packet.group;

import cn.bravedawn.chapter19.packet.Command;
import cn.bravedawn.chapter19.packet.Packet;
import lombok.Data;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/11 16:34
 */
@Data
public class GroupMessageRequestPacket extends Packet {

    private String groupId;
    private String message;

    @Override
    public Byte getCommand() {
        return Command.GROUP_MESSAGE_REQUEST;
    }
}

