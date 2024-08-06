package cn.bravedawn.mdc2.controller;

import cn.bravedawn.mdc.MDCUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

/**
 * @author : depers
 * @program : log4j2-demo
 * @date : Created in 2024/8/6 20:11
 */

@RestController
@Slf4j
public class MdcController {


    @Autowired
    private ExecutorService executorService;


    @GetMapping("runnable")
    public String runnable() {
        log.info("进入runnable Controller的处理逻辑");
        Runnable runnable = () -> {
            log.info("这里是多线程的逻辑");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("多线程执行结束");
        };

        executorService.execute(runnable);
        return "hello";
    }


    @GetMapping("callable")
    public String callable() throws ExecutionException, InterruptedException {
        log.info("进入callable Controller的处理逻辑");
        Callable<Boolean> callable = () -> {
            log.info("这里是多线程的逻辑");
            Thread.sleep(3000);
            log.info("多线程执行结束");
            return true;
        };

        Future<Boolean> result = executorService.submit(callable);
        return result.get().toString();
    }
}
