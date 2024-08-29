package cn.bravedawn.insert.controller;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author : depers
 * @program : jasper
 * @description:
 * @date : Created in 2023/4/5 15:41
 */
public class TransactionManager {


    private TransactionStatus transactionStatus;

    private final DataSourceTransactionManager transactionManager = (DataSourceTransactionManager) SpringContextUtil.getBean("transactionManager");

    public TransactionManager() {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        def.setTimeout(60);
        this.transactionStatus = transactionManager.getTransaction(def);
    }

    public void commit() {
        transactionManager.commit(transactionStatus);
    }


    public void rollback() {
        transactionManager.rollback(transactionStatus);
    }

}
