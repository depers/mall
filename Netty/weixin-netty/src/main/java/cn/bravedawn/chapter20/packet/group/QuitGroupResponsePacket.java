package cn.bravedawn.chapter20.packet.group;

import cn.bravedawn.chapter20.packet.Command;
import cn.bravedawn.chapter20.packet.Packet;
import lombok.Data;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/11 15:49
 */
@Data
public class QuitGroupResponsePacket extends Packet {

    private String groupId;
    private boolean success;

    @Override
    public Byte getCommand() {
        return Command.QUIT_GROUP_RESPONSE;
    }
}
