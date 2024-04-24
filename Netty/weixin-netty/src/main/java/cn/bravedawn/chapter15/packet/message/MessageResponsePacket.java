package cn.bravedawn.chapter15.packet.message;

import cn.bravedawn.chapter15.packet.Command;
import cn.bravedawn.chapter15.packet.Packet;
import lombok.Data;

/**
 * @author Chanmoey
 */
@Data
public class MessageResponsePacket extends Packet {

    private String message;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_RESPONSE;
    }
}
