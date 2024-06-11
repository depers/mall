package cn.bravedawn.chapter16.packet;


import cn.bravedawn.chapter15.serializer.JSONSerializer;
import cn.bravedawn.chapter15.serializer.Serializer;
import cn.bravedawn.chapter15.serializer.SerializerAlgorithm;
import cn.bravedawn.chapter16.packet.login.LoginRequestPacket;
import cn.bravedawn.chapter16.packet.login.LoginResponsePacket;
import cn.bravedawn.chapter16.packet.message.MessageRequestPacket;
import cn.bravedawn.chapter16.packet.message.MessageResponsePacket;
import io.netty.buffer.ByteBuf;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/2/19 15:54
 */
public class PacketCodec {

    public static final int MAGIC_NUMBER = 0x12345678;

    public static final PacketCodec INSTANCE = new PacketCodec();

    private PacketCodec() {
    }

    /**
     * 对消息对象进行编码，或是说是序列化
     */
    public void encode(ByteBuf byteBuf, Packet packet) {
        byte[] bytes = Serializer.DEFAULT.serializer(packet);

        // 写入魔数
        byteBuf.writeInt(MAGIC_NUMBER);

        // 写入协议版本号
        byteBuf.writeByte(packet.getVersion());

        // 写入序列化算法标识
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm());

        // 写入指令
        byteBuf.writeByte(packet.getCommand());

        // 写入数据长度
        byteBuf.writeInt(bytes.length);

        // 写入具体数据
        byteBuf.writeBytes(bytes);
    }


    /**
     * 对响应消息进行解码，或者说是反序列化
     */
    public Packet decode(ByteBuf byteBuf) {
        // 跳过魔数
        byteBuf.skipBytes(4);

        // 跳过版本号
        byteBuf.skipBytes(1);

        // 获取序列化算法标识
        byte serializeAlgorithm = byteBuf.readByte();

        // 获取指令
        byte command = byteBuf.readByte();

        // 数据长度
        int length = byteBuf.readInt();

        // 数据
        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);

        // 获取指令对应的Java实体类的类型
        Class<? extends Packet> requestType = getRequestType(command);

        // 获取序列化算法
        Serializer serializer = getSerializer(serializeAlgorithm);

        if (requestType != null && serializer != null) {
            return serializer.deserializer(requestType, bytes);
        }

        return null;
    }

    private Serializer getSerializer(byte serializeAlgorithm) {
        if (SerializerAlgorithm.JSON == serializeAlgorithm) {
            return new JSONSerializer();
        }

        return null;
    }

    private Class<? extends Packet> getRequestType(byte command) {
        if (Command.LOGIN_REQUEST.equals(command)) {
            return LoginRequestPacket.class;
        }
        if (Command.LOGIN_RESPONSE.equals(command)) {
            return LoginResponsePacket.class;
        }
        if (Command.MESSAGE_REQUEST.equals(command)) {
            return MessageRequestPacket.class;
        }
        if (Command.MESSAGE_RESPONSE.equals(command)) {
            return MessageResponsePacket.class;
        }
        return null;
    }
}
