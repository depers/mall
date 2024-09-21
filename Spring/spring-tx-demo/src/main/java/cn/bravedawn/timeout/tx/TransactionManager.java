package cn.bravedawn.timeout.tx;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author : depers
 * @program : spring-tx-demo
 * @date : Created in 2024/8/8 16:47
 */
public class TransactionManager {


    private TransactionStatus transactionStatus;


    private final DataSourceTransactionManager transactionManager = SpringUtil.getBean("transactionManager", DataSourceTransactionManager.class);


    public TransactionManager() {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        def.setTimeout(120);
        this.transactionStatus = transactionManager.getTransaction(def);
    }

    public void commit() {
        transactionManager.commit(this.transactionStatus);
    }


    public void rollback() {
        transactionManager.rollback(this.transactionStatus);
    }
}
