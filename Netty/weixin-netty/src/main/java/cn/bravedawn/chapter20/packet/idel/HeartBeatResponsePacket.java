package cn.bravedawn.chapter20.packet.idel;

import cn.bravedawn.chapter20.packet.Command;
import cn.bravedawn.chapter20.packet.Packet;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/12 09:23
 */
public class HeartBeatResponsePacket extends Packet {

    @Override
    public Byte getCommand() {
        return Command.HEART_BEAT_RESPONSE;
    }
}
