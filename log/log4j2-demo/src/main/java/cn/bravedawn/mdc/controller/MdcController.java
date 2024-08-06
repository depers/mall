package cn.bravedawn.mdc.controller;

import cn.bravedawn.mdc.MDCUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author : depers
 * @program : log4j2-demo
 * @date : Created in 2024/8/6 17:33
 */

@RestController
@Slf4j
public class MdcController {

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;


    @GetMapping("runnable")
    public String runnable() {
        log.info("进入runnable Controller的处理逻辑");
        Runnable runnable = () -> {
            log.info("这里是多线程的逻辑");
        };

        threadPoolExecutor.execute(MDCUtil.wrap(runnable, MDC.getCopyOfContextMap()));
        return "hello";
    }


    @GetMapping("callable")
    public String callable() throws ExecutionException, InterruptedException {
        log.info("进入callable Controller的处理逻辑");
        Callable<Boolean> callable = () -> {
            log.info("这里是多线程的逻辑");
            return true;
        };

        Future<Boolean> result = threadPoolExecutor.submit(MDCUtil.wrap(callable, MDC.getCopyOfContextMap()));
        return result.get().toString();
    }
}
