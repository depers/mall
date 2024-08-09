package cn.bravedawn.timeout.controller;

import cn.bravedawn.timeout.dao.AccountInfoMapper;
import cn.bravedawn.timeout.model.AccountInfo;
import cn.bravedawn.timeout.tx.TransactionManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author : depers
 * @program : spring-tx-demo
 * @date : Created in 2024/8/8 16:53
 */

@RestController
@Slf4j
public class TimeoutController {


    @Autowired
    private AccountInfoMapper accountInfoMapper;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @GetMapping("hello")
    public String hello() {
        log.info("进入请求");
        TransactionManager transactionManager = new TransactionManager();
        try {
            log.info("开始执行第一条数据");
            AccountInfo accountInfo = new AccountInfo();
            accountInfo.setAccountNo("110");
            accountInfo.setBizDate(new Date());
            accountInfoMapper.insertSelective(accountInfo);
            log.info("第一条数据已落库");

            Thread.sleep(10000);
            log.info("开始执行第二条数据");
            accountInfoMapper.insertSelective(accountInfo);
            transactionManager.commit();
        } catch (Throwable e) {
            log.error("入库失败，事务回滚", e);
            transactionManager.rollback();
        }

        return "success";
    }


    @GetMapping("hello2")
    public String hello2() {
        log.info("进入请求");

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    log.info("开始执行第一条数据");
                    AccountInfo accountInfo = new AccountInfo();
                    accountInfo.setAccountNo("110");
                    accountInfo.setBizDate(new Date());
                    accountInfoMapper.insertSelective(accountInfo);
                    log.info("第一条数据已落库");

                    Thread.sleep(10000);
                    log.info("开始执行第二条数据");
                    accountInfoMapper.insertSelective(accountInfo);
                } catch (Throwable e) {
                    log.error("入库失败，事务回滚", e);
                }
            }
        });


        return "success";
    }

    @GetMapping("hello3")
    @Transactional(rollbackFor = Exception.class, timeout = 10)
    public String hello3() {
        log.info("进入请求");
        try {
            log.info("开始执行第一条数据");
            AccountInfo accountInfo = new AccountInfo();
            accountInfo.setAccountNo("110");
            accountInfo.setBizDate(new Date());
            accountInfoMapper.insertSelective(accountInfo);
            log.info("第一条数据已落库");

            Thread.sleep(10000);
            log.info("开始执行第二条数据");
            accountInfoMapper.insertSelective(accountInfo);
        } catch (Throwable e) {
            log.error("入库失败", e);
        }

        return "success";
    }
}
