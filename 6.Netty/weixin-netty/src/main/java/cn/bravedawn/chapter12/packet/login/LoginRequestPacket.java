package cn.bravedawn.chapter12.packet.login;


import cn.bravedawn.chapter12.packet.Command;
import cn.bravedawn.chapter12.packet.Packet;
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
