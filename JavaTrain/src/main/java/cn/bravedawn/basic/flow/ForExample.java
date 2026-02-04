package cn.bravedawn.basic.flow;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author : depers
 * @Date : Created in 2026-02-02 09:54
 */

@Slf4j
public class ForExample {

    /**
     * for循环中return关键字的使用
     */


    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            if (i == 3) {
                return;
            }

            log.info("打印i={}", i);
        }

        log.info("测试结束");
    }
}
