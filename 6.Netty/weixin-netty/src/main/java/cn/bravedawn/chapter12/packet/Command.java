package cn.bravedawn.chapter12.packet;

/**
 * 指令常量声明
 */

public interface Command {

    Byte LOGIN_REQUEST = 1;
    Byte LOGIN_RESPONSE = 2;

    Byte MESSAGE_REQUEST = 3;
    Byte MESSAGE_RESPONSE = 4;
}
