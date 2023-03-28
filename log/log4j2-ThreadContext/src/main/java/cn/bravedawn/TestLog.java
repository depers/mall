package cn.bravedawn;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.ThreadContext;

/**
 * @author : depers
 * @program : log4j2-ThreadContext
 * @description:
 * @date : Created in 2023/3/28 21:51
 */
@Log4j2
public class TestLog {

    public static void main(String[] args) {
        new Thread(() -> {
            ThreadContext.put("ROUTINGKEY", Thread.currentThread().getName());
            log.info("info");
            log.debug("debug");
            log.error("error");
            ThreadContext.remove("ROUTINGKEY");
        }).start();

        new Thread(() -> {
            ThreadContext.put("ROUTINGKEY", Thread.currentThread().getName());
            log.info("info");
            log.debug("debug");
            log.error("error");
            ThreadContext.remove("ROUTINGKEY");
        }).start();
    }
}
