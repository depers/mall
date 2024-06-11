package cn.bravedawn.chapter17.packet;

/**
 * 指令常量声明
 */

public interface Command {

    Byte LOGIN_REQUEST = 1;
    Byte LOGIN_RESPONSE = 2;

    Byte MESSAGE_REQUEST = 3;
    Byte MESSAGE_RESPONSE = 4;

    Byte CREATE_GROUP_REQUEST = 5;
    Byte CREATE_GROUP_RESPONSE = 6;

    Byte LOGOUT_REQUEST = 7;
    Byte LOGOUT_RESPONSE = 8;
}
