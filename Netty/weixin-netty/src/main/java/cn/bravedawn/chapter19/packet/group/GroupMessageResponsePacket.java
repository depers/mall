package cn.bravedawn.chapter19.packet.group;

import cn.bravedawn.chapter19.packet.Command;
import cn.bravedawn.chapter19.packet.Packet;
import cn.bravedawn.chapter19.utils.Session;
import lombok.Data;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/11 16:36
 */
@Data
public class GroupMessageResponsePacket extends Packet {

    private String fromGroupId;
    private Session fromUser;
    private String message;

    @Override
    public Byte getCommand() {
        return Command.GROUP_MESSAGE_RESPONSE;
    }
}
