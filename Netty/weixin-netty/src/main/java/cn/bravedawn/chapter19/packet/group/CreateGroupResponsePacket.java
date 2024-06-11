package cn.bravedawn.chapter19.packet.group;

import cn.bravedawn.chapter19.packet.Command;
import cn.bravedawn.chapter19.packet.Packet;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/11 11:30
 */
@Getter
@Setter
public class CreateGroupResponsePacket extends Packet {

    private Boolean success;
    private String groupId;
    private List<String> userNameList;

    @Override
    public Byte getCommand() {
        return Command.CREATE_GROUP_RESPONSE;
    }
}

