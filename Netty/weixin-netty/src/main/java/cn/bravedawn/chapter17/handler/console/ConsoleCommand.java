package cn.bravedawn.chapter17.handler.console;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/11 11:25
 */
public interface ConsoleCommand {

    void exec(Scanner scanner, Channel channel);
}
