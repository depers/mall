package cn.bravedawn.chapter20.packet.idel;

import cn.bravedawn.chapter20.packet.Command;
import cn.bravedawn.chapter20.packet.Packet;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/12 09:22
 */
public class HeartBeatRequestPacket extends Packet {

    @Override
    public Byte getCommand() {
        return Command.HEART_BEAT_REQUEST;
    }
}
