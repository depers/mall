package cn.bravedawn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @author : depers
 * @program : Log4j2-mkyong
 * @description:
 * @date : Created in 2023/3/24 20:47
 */
public class HelloWorld {

    private static final Logger logger = LogManager.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        logger.debug("hello from Log4j 2");

        // 在之前，我们需要检查日志的等级以提高性能
        /*if (logger.isDebugEnabled()) {
            logger.debug("{}", getNumber());
        }*/

        // 在Java8中我们可以这样做，不用检查日志等级
        // 在2.4版中，Logger 接口添加了对 lambda 表达式的支持。
        // 这允许客户端代码以延迟方式记录消息，而无需显式检查请求的日志级别是否已启用。
        logger.debug("{}", () -> getNumber());
        logger.info("hello info");
    }


    static int getNumber() {
        return 5;
    }
}
