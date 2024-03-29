package cn.bravedawn.jvm.codetracer;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/5/21 15:25
 */
public class ClassModifier {

    private static final int CONSTANT_POOL_COUNT_INDEX = 8;

    // CONSTANT_utf8_info类型的标识字段值是1
    private static final int CONSTANT_utf8_info = 1;

    // 常量池中11种常量所占的长度，CONSTANT_Utf8_info型常量除外，因为它不是定长的
    private static final int[] CONSTANT_ITEM_LENGTH = {-1, -1, -1, 5, 5, 9, 9, 3, 3, 5, 5, 5, 5};
    private static final int u1 = 1;
    private static final int u2 = 2;

    private byte[] classByte;

    public ClassModifier(byte[] classByte) {
        this.classByte = classByte;
    }


    /**
     * 修改常量池中CONSTANT_utf8_info常量的内容
     */
    public byte[] modifyUTF8Constant(String oldStr, String newStr) {
        int cpc = getConstantPoolCount();
        int offset = CONSTANT_POOL_COUNT_INDEX + u2;
        for (int i = 0; i < cpc; i++) {
            int tag = ByteUtils.byte2Int(classByte, offset, u1);
            if (tag == CONSTANT_utf8_info) {
                // 读取CONSTANT_utf8_info常量的长度
                int len = ByteUtils.byte2Int(classByte, offset + u1, u2);
                offset += (u1 + u2);
                String str = ByteUtils.bytes2String(classByte, offset, len);
                // 如果常量值的内容与我们要修改的内容是一致的，进行字符串的替换逻辑
                if (str.equals(oldStr)) {
                    // 将修改内容从字符串转换为字节数组
                    byte[] strBytes = ByteUtils.string2Bytes(newStr);
                    // 将修改内容的整数长度转换为byte数组
                    byte[] strLen = ByteUtils.int2Bytes(strBytes.length, u2);
                    // 替换标识CONSTANT_utf8_info常量的长度的值
                    classByte = ByteUtils.bytesReplace(classByte, offset - u2, u2, strLen);
                    // 替换CONSTANT_utf8_info常量的内容
                    classByte = ByteUtils.bytesReplace(classByte, offset, len, strBytes);
                    return classByte;
                } else {
                    offset += len;
                }
            } else {
                offset += CONSTANT_ITEM_LENGTH[tag];
            }
        }
        return classByte;
    }

    private int getConstantPoolCount() {
        // 解释一下这段代码，因为类文件格式中第9个字节开始才是常量池的定义，
        // 其中常量池开头的两个字节位常量池的大小，素以这里只对第10、11两个字节进行转换
        return ByteUtils.byte2Int(classByte, CONSTANT_POOL_COUNT_INDEX, u2);
    }

}
