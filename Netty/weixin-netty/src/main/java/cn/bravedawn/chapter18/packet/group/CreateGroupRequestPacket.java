package cn.bravedawn.chapter18.packet.group;

import cn.bravedawn.chapter18.packet.Command;
import cn.bravedawn.chapter18.packet.Packet;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/11 11:29
 */
@Getter
@Setter
public class CreateGroupRequestPacket extends Packet {

    private List<String> userIdList;

    @Override
    public Byte getCommand() {
        return Command.CREATE_GROUP_REQUEST;
    }
}
