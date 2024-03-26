package cn.bravedawn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author : depers
 * @program : log4j2-demo
 * @description:
 * @date : Created in 2021/12/31 11:02
 */
public class App {


    private static final Logger log = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        log.info("hello");
    }

    public void printLog() {
        log.info("print log");
    }
}
