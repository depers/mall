package cn.bravedawn.java8.stream.exception;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/5/29 16:23
 */
@Slf4j
public class StreamExceptionExample3 {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 0, 2);

        log.info("开始执行");
        List<Integer> collect = list.stream()
                .map(i -> {
                    return compute(i, a -> 10 / a);
                }).collect(Collectors.toList());
        log.info("结果：{}", collect);
    }

    private static int compute(int i, ThrowableFunction<Integer, Integer> f) {
        try {
            log.error("当前值：{}", i);
            return f.apply(i);
        } catch (Throwable e) {
            log.error("出错了，{}", i);
        }
        return 0;
    }
}
