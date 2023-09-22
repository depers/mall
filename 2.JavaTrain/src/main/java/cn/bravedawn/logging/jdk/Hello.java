package cn.bravedawn.logging.jdk;

import java.util.logging.Logger;

/**
 * @Description : JDK Logging的简单使用
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-09-22 11:45
 */
public class Hello {




    public static void main(String[] args) {
        Logger logger = Logger.getGlobal();
        logger.info("start process...");
        logger.warning("memory is running out...");
        logger.fine("ignored.");
        logger.severe("process will be terminated...");
    }
}
