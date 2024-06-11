package cn.bravedawn.chapter19.packet.group;

import cn.bravedawn.chapter19.packet.Command;
import cn.bravedawn.chapter19.packet.Packet;
import cn.bravedawn.chapter19.utils.Session;
import lombok.Data;

import java.util.List;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/11 15:49
 */
@Data
public class ListGroupMembersResponsePacket extends Packet {

    private String groupId;
    private List<Session> sessionList;

    @Override
    public Byte getCommand() {
        return Command.LIST_GROUP_MEMBERS_RESPONSE;
    }
}
