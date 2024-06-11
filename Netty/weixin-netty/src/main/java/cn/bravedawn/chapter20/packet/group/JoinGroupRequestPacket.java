package cn.bravedawn.chapter20.packet.group;

import cn.bravedawn.chapter20.packet.Command;
import cn.bravedawn.chapter20.packet.Packet;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/11 15:39
 */
@Getter
@Setter
public class JoinGroupRequestPacket extends Packet {
    @Override
    public Byte getCommand() {
        return Command.JOIN_GROUP_REQUEST;
    }

    private String groupId;
}

