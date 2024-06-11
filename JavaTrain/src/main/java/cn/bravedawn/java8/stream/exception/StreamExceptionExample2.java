package cn.bravedawn.java8.stream.exception;

import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/5/29 16:22
 */
public class StreamExceptionExample2 {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 0);

        list.stream().map(i -> {
            try {
                return 10 / i;
            } catch (Throwable e) {
                // 不允许抛出检查类异常
                // throw new Exception("出错了");
                throw new RuntimeException(e);
            }
        }).forEach(System.out::println);
    }
}
