package cn.bravedawn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App {

    private static final Logger log = LogManager.getLogger(App.class);

    public static void main( String[] args ) {
        new Thread(() -> {
            ThreadContext.put("tradeName", "goods-GET");
            ThreadContext.put("traceId", UUID.randomUUID().toString().replaceAll("-", ""));
            ThreadContext.put("appId", "log4j2-async");
            log.info("这是一条日志");
        }).start();
    }
}
