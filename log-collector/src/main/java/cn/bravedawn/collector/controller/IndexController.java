package cn.bravedawn.collector.controller;

import cn.bravedawn.collector.util.InputMDC;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : depers
 * @program : log-collector
 * @description: controller
 * @date : Created in 2021/3/31 22:34
 */
@Slf4j
@RestController
public class IndexController {


    /**
     * [%d{yyyy-MM-dd'T'HH:mm:ss.SSSZZ}]
     * [%level{length=5}]
     * [%thread-%tid]
     * [%logger]
     * [%X{hostName}]
     * [%X{ip}]
     * [%X{applicationName}]
     * [%F,%L,%C,%M]
     * [%m] ## '%ex'%n
     * -----------------------------------------------
     * [2021-03-31T22:42:28.623+08:00]
     * [INFO]
     * [http-nio-8001-exec-1-29]
     * [cn.bravedawn.collector.controller.IndexController]
     * [] [] []
     * [IndexController.java,34,cn.bravedawn.collector.controller.IndexController,index]
     * [我是一条info日志]
     * ## ''
     * -----------------------------------------------
     */
    @RequestMapping(value = "/index")
    public String index() {

        log.info("我是一条info日志");

        log.warn("我是一条warn日志");

        log.error("我是一条error日志");

        return "idx";
    }


    /**
     * [%d{yyyy-MM-dd'T'HH:mm:ss.SSSZZ}]
     * [%level{length=5}]
     * [%thread-%tid]
     * [%logger]
     * [%X{hostName}]
     * [%X{ip}]
     * [%X{applicationName}]
     * [%F,%L,%C,%M]
     * [%m]
     * ## '%ex'%n
     * -------------------------------------------
     * [2021-03-31T22:46:25.619+08:00]
     * [ERROR]
     * [http-nio-8001-exec-2-29]
     * [cn.bravedawn.collector.controller.IndexController]
     * [] [] []
     * [IndexController.java,70,cn.bravedawn.collector.controller.IndexController,err]
     * [算术异常]
     * ## ' java.lang.ArithmeticException: / by zero
     * 	at cn.bravedawn.collector.controller.IndexController.err(IndexController.java:68)
     */
    @RequestMapping(value = "/err")
    public String err() {
        try {
            int a = 1/0;
        } catch (Exception e) {
            log.error("算术异常", e);
        }
        return "error";
    }


    @RequestMapping(value = "/mdc")
    public String mdc() {
        InputMDC.putMDC();
        log.info("我是一条有mdc的info日志");
        return "mdc";
    }
}
