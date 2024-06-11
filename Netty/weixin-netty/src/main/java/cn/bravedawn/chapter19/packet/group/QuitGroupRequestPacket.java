package cn.bravedawn.chapter19.packet.group;

import cn.bravedawn.chapter19.packet.Command;
import cn.bravedawn.chapter19.packet.Packet;
import lombok.Data;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/11 15:48
 */
@Data
public class QuitGroupRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {
        return Command.QUIT_GROUP_REQUEST;
    }
}