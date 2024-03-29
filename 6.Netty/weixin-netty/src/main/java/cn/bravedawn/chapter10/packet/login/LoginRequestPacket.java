package cn.bravedawn.chapter10.packet.login;

import cn.bravedawn.chapter10.packet.Command;
import cn.bravedawn.chapter10.packet.Packet;
import lombok.Data;

@Data
public class LoginRequestPacket extends Packet {

    private String userId;

    private String username;

    private String password;

    private boolean success;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
