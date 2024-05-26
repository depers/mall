package cn.bravedawn.network.socket.nio.v2;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/5/25 18:34
 */
public class NioServer {

    private static NioServerTask nioServerTask;
    public static void main(String[] args){
        nioServerTask = new NioServerTask(8881);
        new Thread(nioServerTask,"NioServer").start();
    }
}
