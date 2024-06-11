package cn.bravedawn.chapter20.packet.group;

import cn.bravedawn.chapter20.packet.Command;
import cn.bravedawn.chapter20.packet.Packet;
import lombok.Data;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/11 15:45
 */
@Data
public class JoinGroupResponsePacket extends Packet {

    private boolean success;
    private String groupId;

    @Override
    public Byte getCommand() {
        return Command.JOIN_GROUP_RESPONSE;
    }
}
