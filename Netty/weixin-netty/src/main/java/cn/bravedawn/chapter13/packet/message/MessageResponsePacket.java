package cn.bravedawn.chapter13.packet.message;

import cn.bravedawn.chapter13.packet.Command;
import cn.bravedawn.chapter13.packet.Packet;
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
