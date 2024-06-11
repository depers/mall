package cn.bravedawn.chapter17.packet.message;

import cn.bravedawn.chapter17.packet.Command;
import cn.bravedawn.chapter17.packet.Packet;
import lombok.Data;

/**
 * @author Chanmoey
 */
@Data
public class MessageResponsePacket extends Packet {

    private String message;
    private String fromUserId;
    private String fromUserName;
    @Override
    public Byte getCommand() {
        return Command.MESSAGE_RESPONSE;
    }

}
