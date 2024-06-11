package cn.bravedawn.chapter19.packet;

import lombok.Data;

/**
 * 具体消息的抽象类
 */

@Data
public abstract class Packet {

    /**
     * 协议版本
     */
    private Byte version = 1;

    /**
     * 指令
     */
    public abstract Byte getCommand();
}
