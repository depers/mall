package cn.bravedawn.tccdemo;

import cn.bravedawn.tccdemo.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author : depers
 * @program : tcc-demo
 * @description: 转账测试
 * @date : Created in 2021/9/18 21:29
 */


@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testTransferAccount() {
        // accountService.transferAccount();
        // accountService.transferAccountTwo();
        // accountService.transferAccountThree();
        accountService.transferAccountFour();
    }

}
