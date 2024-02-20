package cn.bravedawn.chapter10.packet.message;

import cn.bravedawn.chapter10.packet.Command;
import cn.bravedawn.chapter10.packet.Packet;
import lombok.Data;

/**
 * @author Chanmoey
 */
@Data
public class MessageRequestPacket extends Packet {

    private String message;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_REQUEST;
    }
}
