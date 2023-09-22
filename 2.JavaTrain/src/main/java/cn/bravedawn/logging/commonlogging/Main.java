package cn.bravedawn.logging.commonlogging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 * @Description : TODO
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-09-22 11:58
 */
public class Main {

    /**
     * common-logging 是 apache 的一个开源项目。也称Jakarta Commons Logging，缩写 JCL。
     * commons logging的功能是提供日志功能的 API 接口，本身并不提供日志的具体实现是在运行时动态的绑定日志实现组件来工作
     * commons logging 默认会搜索使用Log4j、JDK Logging作为自己的日志系统
     */


    public static void main(String[] args) {
        // 将控制台追加程序添加到Log4j根记录器
        Logger root = Logger.getRootLogger();
        root.addAppender(new ConsoleAppender(new PatternLayout("%r [%t] %p %c %x - %m%n")));


        Log log = LogFactory.getLog(Main.class);
        log.info("stat...");
        log.warn("end.");
    }
}
