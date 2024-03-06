package cn.bravedawn.chapter13.packet.login;

import cn.bravedawn.chapter13.packet.Command;
import cn.bravedawn.chapter13.packet.Packet;
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
