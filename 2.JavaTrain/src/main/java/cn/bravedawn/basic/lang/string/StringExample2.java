package cn.bravedawn.basic.lang.string;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author : depers
 * @program : JavaTrain
 * @description: 字符串拼接
 * @date : Created in 2022/1/6 15:07
 */
public class StringExample2 {


    /**
     * 删除索引位置的字符，deleteCharAt(index)
     */

    public static void main(String[] args) {
        String methods = "1,2,3";
        StringBuffer buffer = new StringBuffer();

        Arrays.stream(methods.split(","))
                .forEach(method -> buffer.append("'").append(method).append("'").append(","));

        System.out.println(buffer.deleteCharAt(buffer.length() - 1).deleteCharAt(0).deleteCharAt(buffer.length() - 1));


    }
}
